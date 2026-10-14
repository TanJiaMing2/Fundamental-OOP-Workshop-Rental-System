import java.util.Scanner;

public class Workshop extends equipments {
    private String workshop_id;
    private String workshop;
    private String location;
    private WorkshopRental rental;
    private Scanner scanner;

    public Workshop(String name, String location, String date, String organizer) {
        this.workshop_id = name;
        this.workshop = name;
        this.location = location;
        this.rental = null;
        this.scanner = new Scanner(System.in);
    }

    public String getWorkshop_id() {
        return workshop_id;
    }

    public String getWorkshop() {
        return workshop;
    }

    public String getLocation() {
        return location;
    }

    public void setWorkshopDetails() {
        System.out.print("Enter the workshop ID: ");
        workshop_id = scanner.nextLine();

        System.out.print("Enter the workshop name: ");
        workshop = scanner.nextLine();

        System.out.print("Enter the workshop location: ");
        location = scanner.nextLine();
        System.out.println();
    }

    public void setRentalDetails() {
        System.out.println("Enter the renter detail");
        System.out.print("Enter the workshop ID: ");
        String workshopId = scanner.nextLine();

        System.out.print("Enter customer name: ");
        String rentalCustomerId = scanner.nextLine();

        System.out.print("Enter total payment: ");
        int rentalPayment = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println();

        rental = new WorkshopRental(workshopId, rentalCustomerId, rentalPayment);
    }

    public WorkshopRental getRental() {
        return rental;
    }
    
    public double calcrentalRate() {
        return rental.gettPayment() * 0.1;
    }

    public static void main(String[] args) {
        Workshop workshop = new Workshop("Workshop A", "", "", "");

        workshop.setWorkshopDetails();
        workshop.setRentalDetails();

        System.out.println("Add the equipments");
        workshop.equipmentlist();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Display workshop detail");
            System.out.println("2. Display rental detail");
            System.out.println("3. Display equipment list");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Workshop ID: " + workshop.getWorkshop_id());
                    System.out.println("Workshop Name: " + workshop.getWorkshop());
                    System.out.println("Location: " + workshop.getLocation());
                    break;
                case 2:
                    WorkshopRental rental = workshop.getRental();
                    System.out.println("Customer's rental detail");
                    System.out.println("Customer name: " + rental.getcustomer_name());
                    System.out.println("Customer ID: " + rental.getcustomer_id());
                    System.out.println("Total payment: " + rental.gettPayment());
                    double rentalRate = workshop.calcrentalRate();
                    System.out.println("Rental Rate 10% for each month(10 month total): " + rentalRate);
                    break;
                case 3:
                    System.out.println("Equipment List:");
                    for (String equipmentName : workshop.getEquipmentList()) {
                        System.out.println(equipmentName);
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("\nPlease choose a valid option (1-4)!");
                    break;
            }
        }
    }
}
