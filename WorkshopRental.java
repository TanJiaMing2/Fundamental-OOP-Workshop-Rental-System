import java.util.Scanner;

public class WorkshopRental {
    private String  customer_name;
    private String customer_id;
    private int tpayment;
    private Scanner scanner;

     public WorkshopRental(String workshopId, String customerId, int payment) {
        this.customer_name = workshopId;   
        this.customer_id = customerId;     
        this.tpayment = payment;            
        this.scanner = new Scanner(System.in);
    }
    public String getcustomer_name() {
        return customer_name;
    }

    public String getcustomer_id() {
        return customer_id;
    }

    public int gettPayment() {
        return tpayment;
    }

    public void setRentalDetails() {
        System.out.print("Enter the customer name: ");
        customer_name = scanner.nextLine();

        System.out.print("Enter the customer ID: ");
        customer_id = scanner.nextLine();

        System.out.print("Enter total payment: ");
        tpayment = scanner.nextInt();
        scanner.nextLine(); 
    }

    public static void main(String[] args) {
        WorkshopRental rental = new WorkshopRental("", "", 0);

        rental.setRentalDetails();

        System.out.println("Customer name: " + rental.getcustomer_name());
        System.out.println("Customer ID: " + rental.getcustomer_id());
        System.out.println("Total payment: " + rental.gettPayment());
    }
}
