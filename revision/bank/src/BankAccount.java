import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class BankAccount {

    // Members
    private String name;
    private String account;
    protected float balance;
    private LinkedList<String> transactions;
    private boolean isClosed;
    private String creationDate;
    private String closingDate;

    // Getters
    public String getName() {
        return name;
    }
    public String getAccount() {
        return account;
    }
    public float getBalance() {
        return balance;
    }
    public LinkedList<String> getTransactions() {
        return transactions;
    }
    public String getCreationDate() {
        return creationDate;
    }
    public String getClosingDate() {
        return closingDate;
    }

    // Setters
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public void setTransactions(LinkedList<String> transactions) {
        this.transactions = transactions;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    // Constructors

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0f;
        this.isClosed = false;
        this.creationDate = getTimeNow();
        this.transactions = new LinkedList<String>();
        this.account = generateRandomAccount();
    }

    public BankAccount(String name, float balance) {
        this.name = name;
        this.balance = balance;
        this.isClosed = false;
        this.creationDate = getTimeNow();
        this.transactions = new LinkedList<String>();
        this.account = generateRandomAccount();
    }

    
    // To String
    @Override
    public String toString() {
        return "BankAccount [name=" + name + ", account=" + account + ", balance=" + balance + ", transactions="
                + transactions + ", isClosed=" + isClosed + ", creationDate=" + creationDate + ", closingDate="
                + closingDate + "]";
    }

    //Methods
    public void deposit(float amount) {

        if(amount < 0 || isClosed) {
            System.out.println("IllegalArgumentException");

        } else {
            this.balance += amount;
            transactions.add(String.format("deposit $%f at <%s>" , amount, getTimeNow()));
        }

    }

    public void withdraw(float amount) {

        if(amount < 0 || (this.balance - amount < 0) || isClosed) {
            System.out.println("IllegalArgumentException");

        } else {
            this.balance -= amount;
            transactions.add(String.format("withdraw $%f at <%s>" , amount, getTimeNow()));
        }

    }
    
    public String getTimeNow() {
        LocalDateTime transactionDateTime = LocalDateTime.now();
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
        String transactionTime = FOMATTER.format(transactionDateTime);
        return transactionTime;
    }

    public String generateRandomAccount() {

        String randomString = "";
        Random rn = new Random();
        for(int i = 0; i < 8; i++) {
            randomString += rn.nextInt(9);
        }

        return randomString;

    }
    
    
    

    

    
    
}
