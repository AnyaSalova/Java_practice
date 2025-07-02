import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class BankAccount {

    String name;
    double balance;
    LocalDateTime opdate;
    boolean state;
    String number;

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0;
        this.opdate = LocalDateTime.now();
        this.state = true;
        this.number = AccountNumber();
    }

    private String AccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", opdate=" + opdate +
                ", state=" + (state ? "active" : "blocked") +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public boolean deposit(double amount) {
        if (!state || amount <= 0) {
            return false; }
        balance += amount;
        return true; 
    }

    public boolean withdraw(double amount) {
        if (!state || amount <= 0 || amount > balance) {
            return false; 
        }
        balance -= amount;
        return true; 
    }

    public boolean transfer(BankAccount otherAccount, double amount) {
        if (!state || otherAccount == null || !otherAccount.state || 
            amount <= 0 || amount > balance) {
            return false; 
        }
        
        this.balance -= amount;
        otherAccount.balance += amount;
        return true;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDateTime getOpdate() {
        return opdate;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean newState) {
        this.state = newState;
    }

}
