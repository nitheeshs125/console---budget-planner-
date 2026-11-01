import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name, email, currency;
    private List<String> profiles;
    private double balance;
    private static int totalUsers = 0;

    public User(int userId, String name, String email, String currency) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.currency = currency;
        profiles = new ArrayList<>();
        balance = 0;
        totalUsers++;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCurrency() { return currency; }
    public List<String> getProfiles() { return new ArrayList<>(profiles); }
    public double getBalance() { return balance; }
    public static int getTotalUsers() { return totalUsers; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void addProfile(String profile) {
        if (!profiles.contains(profile)) profiles.add(profile);
    }
    public void updateBalance(double amount) { balance += amount; }

    @Override
    public String toString() {
        return userId + " - " + name + " (" + email + ")";
    }
}
