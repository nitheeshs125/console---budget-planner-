public class VariableCategory extends Category {
    private double alertAtPercent;
    private String priority;

    public VariableCategory(int id, String name, double limit, String month,
                            double alertPercent, String priority) {
        super(id, name, limit, month);
        alertAtPercent = alertPercent;
        this.priority = priority;
    }

    public double getAlertAtPercent() { return alertAtPercent; }
    public String getPriority() { return priority; }
    public void setAlertAtPercent(double value) { alertAtPercent = value; }
    public void setPriority(String value) { priority = value; }

    @Override
    public double limitRemaining() {
        double remaining = monthlyLimit - spentSoFar;
        return remaining < 0 ? 0 : remaining;
    }

    public boolean isNearLimit() {
        return spentSoFar >= monthlyLimit * alertAtPercent / 100.0;
    }

    public String getCategoryType() { return "VARIABLE"; }
}
