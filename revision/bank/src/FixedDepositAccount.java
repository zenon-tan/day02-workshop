public class FixedDepositAccount extends BankAccount {

    // Members

    private float interest;
    private int durationInMonths;
    private int interestSetCounter = 0;
    private int durationSetCounter = 0;


    // Getters

    public float getInterest() {
        return interest;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    

    // Setters

    public void setInterest(float interest) {
        if(interestSetCounter >= 1) {
            System.out.println("Interest already set once!");

        } else {
            this.interest = interest;
            interestSetCounter++;

        }

    }

    public void setDurationInMonths(int durationInMonths) {
        if(durationSetCounter >= 1) {
            System.out.println("Duration already set once!");

        } else {
            this.durationInMonths = durationInMonths;
            durationSetCounter++;

        }
    }

    // Constructors

    public FixedDepositAccount(String name, float balance) {
        super(name, balance);

        this.interest = 0.03f;
        durationInMonths = 6;


    }

    public FixedDepositAccount(String name, float balance, float interest) {
        super(name, balance);

        this.interest = interest;
        this.durationInMonths = 6;
    }


    public FixedDepositAccount(String name, float balance, float interest, int duationInMonths) {
        super(name, balance);

        this.interest = interest;
        this.durationInMonths = duationInMonths;
        

    }

    @Override
    public float getBalance() {
        this.balance += (this.balance * this.interest);
        return balance;
        
    }

    @Override
    public void withdraw(float amount) {

        System.out.println("Operation not allowed");


    }

    @Override
    public void deposit(float amount) {

        System.out.println("Operation not allowed");
        

    }

    @Override
    public void setBalance(float amount) {
        System.out.println("Balance cannot be changed");
    }



    
}
