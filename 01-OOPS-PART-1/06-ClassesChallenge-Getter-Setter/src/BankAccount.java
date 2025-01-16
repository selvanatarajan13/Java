// define class
public class BankAccount {

    // define fields
    private long accountNumber;
    private double bankBalance;
    private String customerName;
    private String customerEmail;
    private long customerMobile;

    final private int minimumBalance = 500;

    // create method for deposting funds
    public void depositFunds(double fund) {
        bankBalance = bankBalance + fund;
        System.out.println("Amount : " + fund + " deposited your account : " + accountNumber + " successfully.");
        System.out.println("Remainig Balance : " + bankBalance);
    }

    // create method for withraw fund
    public void withrawAmount(double amt) {
        if (bankBalance - amt > minimumBalance) {
            bankBalance = bankBalance - amt;
            System.out.println("\n" + amt + " withrawl successfull..");
            System.out.println("Your Remaining Balance : " + bankBalance);
        } else {
            System.out.println("\nYour Account balance is low " + bankBalance + ". Cannot withraw the amount.");
            System.out.println("Because you should maintain your minimum balance : " + minimumBalance);
        }
    }

    // check profile
    public void profile() {
        System.out.println(toString());
    }

    // create getter and setter methods
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public long getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(long customerMobile) {
        this.customerMobile = customerMobile;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", bankBalance=" + bankBalance +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerMobile=" + customerMobile +
                '}';
    }
}
