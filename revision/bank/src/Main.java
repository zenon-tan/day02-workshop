public class Main {

    public static void main(String[] args) {
        BankAccount jesus = new BankAccount("jesus", 6000f);
        jesus.deposit(400);
        System.out.println(jesus.getBalance());
        System.out.println(jesus.toString());
        jesus.withdraw(6000);
        System.out.println(jesus.toString());


        FixedDepositAccount joanne = new FixedDepositAccount("joanne", 3000);
        System.out.println(joanne.getBalance());
        System.out.println(joanne.getBalance());

        FixedDepositAccount gaga = new FixedDepositAccount("gaga", 50000, 0.03f, 10);
        System.out.println(gaga.getBalance());
        gaga.setBalance(10000000);
        gaga.setInterest(10);
        System.out.println(gaga.getBalance());
        gaga.setInterest(20);
        gaga.setDurationInMonths(20);
        gaga.setDurationInMonths(50);

    }
    
}
