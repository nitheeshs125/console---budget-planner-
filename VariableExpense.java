import java.time.LocalDate;

public class VariableExpense extends Transaction {
    private String merchant;
    private boolean essential;

    public VariableExpense(int id, double amount, LocalDate date, Category category,
                           String note, String merchant, boolean essential) {
        super(id, "EXPENSE", amount, date, category, note);
        this.merchant = merchant;
        this.essential = essential;
    }

    public String getMerchant() { return merchant; }
    public boolean isEssential() { return essential; }
    public void setMerchant(String value) { merchant = value; }
    public void setEssential(boolean value) { essential = value; }

    @Override
    public String toString() {
        return super.toString() + " [Variable, " + merchant
                + ", essential=" + essential + "]";
    }
}
