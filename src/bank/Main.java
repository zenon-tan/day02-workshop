package bank;

public class Main {

    public static void main(String[] args) {

        BankAccount joanne = new BankAccount("Joanne");
        joanne.toString();
        System.out.println(joanne.toString());

        joanne.deposit(100f);
        System.out.println(joanne.toString());

        joanne.withdraw(20f);
        System.out.println(joanne.toString());

        joanne.withdraw(79f);
        System.out.println(joanne.toString());

        System.out.println("----------------------------------");

        FixedDepositAccount gaga = new FixedDepositAccount("gaga", 100f);
        System.out.printf("Account name: %s\n", gaga.getAccountName());
        System.out.printf("Account balance: %s\n", gaga.getBalance());
        System.out.printf("Account Interest %s\n", gaga.getInterest());
        System.out.printf("Interest Duration %s\n", gaga.getDurationInMonths());
        
        gaga.setDurationInMonths(12);
        gaga.setInterest(0.05f);

        System.out.printf("Account balance: %s\n", gaga.getBalance());
        System.out.printf("Account Interest %s\n", gaga.getInterest());
        System.out.printf("Interest Duration %s\n", gaga.getDurationInMonths());


        // Test for exception when setting more than once
        // gaga.setDurationInMonths(18);
        // System.out.printf("Interest Duration %s\n", gaga.getDurationInMonths());
        
        



        
    }
    
}
