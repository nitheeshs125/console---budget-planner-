public class FixedCategory extends Category {
    private double fixedAmount;
    private String billingCycle;

    public FixedCategory(int id, String name, double limit, String month,
                         double fixedAmount, String cycle) {
        super(id, name, limit, month);
        this.fixedAmount = fixedAmount;
        billingCycle = cycle;
    }

    public double getFixedAmount() { return fixedAmount; }
    public String getBillingCycle() { return billingCycle; }
    public void setFixedAmount(double amount) {
        if (amount >= 0) fixedAmount = amount;
    }
    public void setBillingCycle(String cycle) { billingCycle = cycle; }

    @Override
    public double limitRemaining() {
        return Math.min(monthlyLimit - spentSoFar, fixedAmount - spentSoFar);
    }

    public String getCategoryType() { return "FIXED"; }
}
