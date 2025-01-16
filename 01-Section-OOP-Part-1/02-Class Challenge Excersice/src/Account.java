public class Account {

    // define fields
    private String customerName;
    private String customerEmail;
    private long accountNumber;
    private int accountBalance;

    private int minimumBalance = 2000;

    // define functionality

    public void withdrawAmt(int amt) {
        if (accountBalance > minimumBalance && accountBalance-amt >= minimumBalance) {
            accountBalance = accountBalance - amt;
            System.out.println("Amount withdraw successfull..");
            System.out.println("Balance left : " + accountBalance);
        } else {
            System.out.println("Your account balance is to low : " + accountBalance + ".");
            System.out.println("You should maintain the minimum balance " + minimumBalance + ".");
        }
    }

    public void depositFund(Integer amt) {
        if (amt != -1 && amt != null) {
            accountBalance += amt;
            System.out.println("Successfully deposited..");
            System.out.println("Balance left : " + accountBalance);
        } else {
            System.out.println("You have enter wrong value, please enter correct amount..");
        }
    }

    public void accountInfo() {
        System.out.println(toString());
    }

    // define getter and setter


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

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(int minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    // define toString()


    @Override
    public String toString() {
        return "Account{" +
                "customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                ", minimumBalance=" + minimumBalance +
                '}';
    }
}
