public class Category {
    protected int categoryId;
    protected String name;
    protected double monthlyLimit, spentSoFar;
    protected String month;
    protected static int categoryCount = 0;

    public Category(int id, String name, double limit, String month) {
        categoryId = id;
        this.name = name;
        monthlyLimit = limit;
        this.month = month;
        spentSoFar = 0;
        categoryCount++;
    }

    public int getCategoryId() { return categoryId; }
    public String getName() { return name; }
    public double getMonthlyLimit() { return monthlyLimit; }
    public double getSpentSoFar() { return spentSoFar; }
    public String getMonth() { return month; }
    public void setName(String name) { this.name = name; }

    public void setMonthlyLimit(double limit) {
        if (limit >= 0) monthlyLimit = limit;
    }

    public void addSpending(double amount) {
        if (amount > 0) spentSoFar += amount;
    }

    public void resetMonthlySpend() { spentSoFar = 0; }
    public double limitRemaining() { return monthlyLimit - spentSoFar; }

    public String getStatus() {
        return spentSoFar > monthlyLimit ? "OVER LIMIT" : "WITHIN LIMIT";
    }

    @Override
    public String toString() {
        return name + ": spent " + spentSoFar + " / " + monthlyLimit;
    }
}
