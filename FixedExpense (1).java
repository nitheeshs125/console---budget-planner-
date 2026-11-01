import java.time.LocalDate;

public class FixedExpense extends Transaction {
    private String paymentMode;
    private boolean recurring;

    public FixedExpense(int id, double amount, LocalDate date, Category category,
                        String note, String paymentMode, boolean recurring) {
        super(id, "EXPENSE", amount, date, category, note);
        this.paymentMode = paymentMode;
        this.recurring = recurring;
    }

    public String getPaymentMode() { return paymentMode; }
    public boolean isRecurring() { return recurring; }
    public void setPaymentMode(String mode) { paymentMode = mode; }
    public void setRecurring(boolean value) { recurring = value; }

    @Override
    public String toString() {
        return super.toString() + " [Fixed, " + paymentMode
                + ", recurring=" + recurring + "]";
    }
}
