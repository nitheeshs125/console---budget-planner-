import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private int txnId;
    private String type;
    private double amount;
    private LocalDate date;
    private Category category;
    private String note;
    private List<String> tags;
    private static int transactionCount = 0;

    public Transaction(int id, String type, double amount, LocalDate date,
                       Category category, String note) {
        txnId = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.note = note;
        tags = new ArrayList<>();
        transactionCount++;
    }

    public int getTxnId() { return txnId; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public Category getCategory() { return category; }
    public String getNote() { return note; }
    public List<String> getTags() { return new ArrayList<>(tags); }
    public static int getTransactionCount() { return transactionCount; }
    public void setNote(String note) { this.note = note; }

    public void addTag(String tag) {
        if (!tags.contains(tag)) tags.add(tag);
    }

    public double signedAmount() {
        return type.equals("INCOME") ? amount : -amount;
    }

    @Override
    public String toString() {
        return txnId + " | " + date + " | " + type + " | " + amount + " | "
                + (category == null ? "Income" : category.getName()) + " | " + note;
    }
}
