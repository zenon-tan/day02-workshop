package bank;

public class FixedDepositAccount extends BankAccount {

    // Members 
    private float interest;
    private int durationInMonths;
    private int interestSetCounter = 0;
    private int durationSetCounter = 0;

    // Constructors

    public FixedDepositAccount(String accountName, float balance) {
        super(accountName, balance);
        this.interest = 0.03f;
        this.durationInMonths = 6;
    }

    public FixedDepositAccount(String accountName, float balance, float interest) {
        super(accountName, balance);
        this.interest = interest;
        this.durationInMonths = 6;
    }

    public FixedDepositAccount(String accountName, float balance, float interest, int durationInMonths) {
        super(accountName, balance);
        this.interest = interest;
        this.durationInMonths = durationInMonths;
    }

    // Getters

    public float getInterest() {
        return interest;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    // Setters

    public void setInterest(float interest) {
        if(interestSetCounter < 1) {

            this.interest = interest;
            interestSetCounter++;

        } else {
            throw new IllegalArgumentException();
        }
        
    }

    public void setDurationInMonths(int durationInMonths) {
        if(durationSetCounter < 1) {

            this.durationInMonths = durationInMonths;
            durationSetCounter++;

        } else {
            throw new IllegalArgumentException();

        }
        
    }


    // Methods

    @Override
    public float getBalance() {

        this.balance += (this.balance * this.interest);
        return balance;
    }

    @Override
    public String withdraw(float amount) {

        return "Withdrawal not allowed";

    }

    @Override
    public String deposit(float amount) {

        return "deposit not allowed";

    }


    

    





    

    

    



    

    
}
