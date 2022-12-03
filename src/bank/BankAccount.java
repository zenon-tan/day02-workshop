package bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BankAccount {

    // Members

    protected String accountName;
    private String ranAcc;
    protected float balance = 0f;
    private List<String> transactions;
    private Boolean isClosed;
    private Date openingDate;
    private Date closingDate;

    //Constructors

    public BankAccount(String accountName) {
        this.accountName = accountName;
        this.ranAcc = generateRandomAccountNumber();
        this.balance = 0f;
        this.isClosed = false;
        this.openingDate = new java.util.Date();
        this.transactions = new LinkedList<>();

    }

    public BankAccount(String accountName, float balance) {
        this.accountName = accountName;
        this.ranAcc = generateRandomAccountNumber();
        this.balance = balance;
        this.isClosed = false;
        this.openingDate = new java.util.Date();
        this.transactions = new LinkedList<>();

    }

    // Getters

    public String getAccountName() {
        return accountName;
    }
    public String getRanAcc() {
        return ranAcc;
    }
    public float getBalance() {
        return balance;
    }
    public List<String> getTransactions() {
        return transactions;
    }
    public Boolean getIsClosed() {
        return isClosed;
    }
    public Date getOpeningDate() {
        return openingDate;
    }
    public Date getClosingDate() {
        return closingDate;
    }

    // Setters

    public void setBalance(float balance) {
        this.balance = balance;
    }
    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }
    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }
    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    

    @Override
    public String toString() {
        return "BankAccount [accountName=" + accountName + ", ranAcc=" + ranAcc + ", balance=" + balance
                + ", transactions=" + transactions + ", isClosed=" + isClosed + ", openingDate=" + openingDate
                + ", closingDate=" + closingDate + "]";
    }

    private String generateRandomAccountNumber() {

        Random rand = new Random();
        String accountNumber = "";

        for(int i = 0; i < 8; i++) {
            accountNumber += Integer.toString(rand.nextInt(10));
        }

        return accountNumber;
    }

    private String formatDate(Date dateTime) {

        String formattedDate = "";

        DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        formattedDate = dateFormat.format(dateTime);

        return formattedDate;
    }

    public String deposit(float amount) {

        String transactionLog = "";

        if (amount <= 0 || isClosed) {
            throw new IllegalArgumentException();
        }

        else {
            this.balance += amount;
            Date dateNow = new java.util.Date();
            String stringDate = formatDate(dateNow);
            transactionLog = String.format("deposit $%f at <%s>", amount, stringDate);
            this.transactions.add(transactionLog);

        }

        return transactionLog;
    }

    public String withdraw(float amount) {

        String transactionLog = "";

        if (amount <= 0 || isClosed || (this.balance - amount) < 0) {
            throw new IllegalArgumentException();
        }

        else {

            balance -= amount;
            Date dateNow = new java.util.Date();
            String stringDate = formatDate(dateNow);
            transactionLog = String.format("withdraw $%f at <%s>", amount, stringDate);
            this.transactions.add(transactionLog);

        }

        return transactionLog;
    }

    

    

    
}
