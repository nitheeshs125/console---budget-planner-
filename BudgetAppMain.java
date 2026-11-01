import java.time.YearMonth;
import java.util.Arrays;

public class BudgetAppMain {
    public static void main(String[] args) {
        System.out.println("===== CONSOLE BUDGET PLANNER =====");
        User user = new User(101, "Arun", "arun@mail.com", "INR");
        user.addProfile("Personal");
        user.addProfile("Monthly Planner");
        System.out.println("User: " + user);

        BudgetService service = new BudgetService(user);
        Category rent = new FixedCategory(1, "Rent", 10000, "2026-10", 10000, "Monthly");
        Category food = new VariableCategory(2, "Food", 5000, "2026-10", 80, "HIGH");
        Category travel = new VariableCategory(3, "Travel", 3000, "2026-10", 80, "MEDIUM");
        Category bills = new FixedCategory(4, "Bills", 2000, "2026-10", 2000, "Monthly");
        service.addCategory(rent);
        service.addCategory(food);
        service.addCategory(travel);
        service.addCategory(bills);

        service.addIncome(30000, "Monthly salary");
        service.addIncome(5000, "Freelance work");
        service.addFixedExpense(9000, rent, "House rent");
        service.addExpense(2500, food, "Groceries");
        service.addExpense(1200, food, "Restaurant", Arrays.asList("Dining"));
        service.addVariableExpense(1800, travel, "Bus and cab");
        service.addExpense(1500, bills, "Electricity bill");

        service.categoryReport();
        service.printSummary();
        service.monthlyReport(YearMonth.now());
        service.topSpendingCategories();
        System.out.println("\\nAvailable balance: " + user.getBalance() + " " + user.getCurrency());
        System.out.println("Budget Planner Completed Successfully!");
    }
}
