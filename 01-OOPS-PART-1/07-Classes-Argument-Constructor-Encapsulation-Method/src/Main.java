public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        // create new instance on BankAccount
        BankAccount myAccount = new BankAccount();

        // set attributes for this instance
        myAccount.setAccountNumber(36046128284L);
        myAccount.setCustomerName("SELVANATARAJAN S");
        myAccount.setCustomerEmail("selva@gmail.com");
        myAccount.setCustomerMobile(9787660170L);
        myAccount.setBankBalance(12500);

        // called the method on this instance
        myAccount.profile();
        myAccount.depositFunds(25000L);
        myAccount.withrawAmount(35000);
        myAccount.withrawAmount(500);
        myAccount.depositFunds(88000);

        BankAccount mahendAccount = new BankAccount(
                36046128285L,20000,"Mahendran","mahend@gmail.com",
                9487270170L
        );

        mahendAccount.profile();
        myAccount.profile();
    }
}