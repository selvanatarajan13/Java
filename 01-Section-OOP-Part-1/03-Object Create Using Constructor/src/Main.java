public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // instantiating new object
        Account kevinAccount = new Account(
                "Kevin","kevin@gmail.com",36046128284L,6000
        );
        kevinAccount.accountInfo();

        Account markAccount = new Account(
                "Mark","mark@gmail.com",36004628281L
        );
        markAccount.accountInfo();
    }
}