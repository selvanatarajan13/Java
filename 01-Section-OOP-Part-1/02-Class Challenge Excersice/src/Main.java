public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // instantiating new object
        Account bobAccount = new Account();

        bobAccount.setAccountNumber(36046126264L);
        bobAccount.setAccountBalance(5000);
        bobAccount.setCustomerName("Bob Cattle");
        bobAccount.setCustomerEmail("bob@gmail.com");

        bobAccount.depositFund(2500);
        bobAccount.depositFund(7500);

        bobAccount.withdrawAmt(12500);
        bobAccount.withdrawAmt(500);
        bobAccount.withdrawAmt(100);
        bobAccount.accountInfo();
    }
}