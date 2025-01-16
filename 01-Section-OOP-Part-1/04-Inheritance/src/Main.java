public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // instantiate the object
        Worker worker = new Worker(
                "Mahendran","12/06/2003"
        );
        doWorkerStuff(worker);

        SalariedEmployee mahendran = new SalariedEmployee(
                "Mahendran", "12/06/2003", "20/08/2023", 625000
        );
        doWorkerStuff(mahendran);

        HourlyEmployee karthik = new HourlyEmployee(
                "Karthik", "20/05/1994", "15/05/2008", 200
        );
        System.out.println( karthik.getName() +" collect pay per day : " + karthik.collectPay());
    }

    private static void doWorkerStuff(Worker worker) {

        worker.getAge();
        System.out.println(worker);
        System.out.println("Collect Pay per month : " + worker.collectPay());
        System.out.println(worker.getEndDate());
        System.out.println("----------------------------------");
    }
}