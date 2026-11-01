import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class BudgetService {
    private User user;
    private List<Category> categories;
    private List<Transaction> transactions;
    private int nextTxnId;
    private double totalIncome, totalExpense;
    private String reportCurrency;

    public BudgetService(User user) {
        this.user = user;
        categories = new ArrayList<>();
        transactions = new ArrayList<>();
        nextTxnId = 1;
        totalIncome = 0;
        totalExpense = 0;
        reportCurrency = user.getCurrency();
    }

    public void addCategory(Category category) { categories.add(category); }
    public List<Category> getCategories() { return new ArrayList<>(categories); }
    public List<Transaction> getTransactions() { return new ArrayList<>(transactions); }
    public double getTotalIncome() { return totalIncome; }
    public double getTotalExpense() { return totalExpense; }
    public double getSavings() { return totalIncome - totalExpense; }

    public void addIncome(double amount, String note) {
        if (amount <= 0) return;
        Transaction t = new Transaction(nextTxnId++, "INCOME", amount,
                java.time.LocalDate.now(), null, note);
        transactions.add(t);
        totalIncome += amount;
        user.updateBalance(amount);
    }

    // Method overloading: addExpense() with different parameter lists
    public void addExpense(double amount, Category category) {
        addExpense(amount, category, "General expense");
    }

    public void addExpense(double amount, Category category, String note) {
        addExpense(amount, category, note, new ArrayList<String>());
    }

    public void addExpense(double amount, Category category, String note, List<String> tags) {
        if (amount <= 0 || category == null) return;
        Transaction t = new Transaction(nextTxnId++, "EXPENSE", amount,
                java.time.LocalDate.now(), category, note);
        for (String tag : tags) t.addTag(tag);
        transactions.add(t);
        totalExpense += amount;
        category.addSpending(amount);
        user.updateBalance(-amount);
    }

    // Polymorphism: stored as Transaction objects
    public void addFixedExpense(double amount, Category category, String note) {
        transactions.add(new FixedExpense(nextTxnId++, amount,
                java.time.LocalDate.now(), category, note, "UPI", true));
        totalExpense += amount;
        category.addSpending(amount);
        user.updateBalance(-amount);
    }

    public void addVariableExpense(double amount, Category category, String note) {
        transactions.add(new VariableExpense(nextTxnId++, amount,
                java.time.LocalDate.now(), category, note, "Local Store", true));
        totalExpense += amount;
        category.addSpending(amount);
        user.updateBalance(-amount);
    }

    public Category findCategory(String name) {
        for (Category c : categories)
            if (c.getName().equalsIgnoreCase(name)) return c;
        return null;
    }

    public void categoryReport() {
        System.out.println("\\nCATEGORY-WISE BUDGET");
        for (Category c : categories)
            System.out.printf("%-14s Spent: %8.2f Limit: %8.2f Remaining: %8.2f %s%n",
                    c.getName(), c.getSpentSoFar(), c.getMonthlyLimit(),
                    c.limitRemaining(), c.getStatus());
    }

    public void monthlyReport(YearMonth month) {
        System.out.println("\\nMONTHLY STATEMENT - " + month);
        System.out.println("ID | DATE | TYPE | AMOUNT | CATEGORY | NOTE");
        for (Transaction t : transactions)
            if (YearMonth.from(t.getDate()).equals(month)) System.out.println(t);
        System.out.printf("Income: %.2f Expense: %.2f Savings: %.2f%n",
                totalIncome, totalExpense, getSavings());
    }

    public void topSpendingCategories() {
        List<Category> copy = new ArrayList<>(categories);
        copy.sort((a, b) -> Double.compare(b.getSpentSoFar(), a.getSpentSoFar()));
        System.out.println("\\nTOP SPENDING CATEGORIES");
        for (int i = 0; i < Math.min(3, copy.size()); i++)
            System.out.println((i + 1) + ". " + copy.get(i).getName() + " - "
                    + copy.get(i).getSpentSoFar());
    }

    public void printSummary() {
        System.out.println("\\nOVERALL SUMMARY (" + reportCurrency + ")");
        System.out.printf("Income : %.2f%nExpense: %.2f%nSavings: %.2f%n",
                totalIncome, totalExpense, getSavings());
        System.out.println("Transactions: " + transactions.size());
    }
}
