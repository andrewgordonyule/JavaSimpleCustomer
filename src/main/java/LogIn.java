import java.util.List;
import java.util.Scanner;

public class LogIn implements LogInInterface {
    static Scanner scanner = new Scanner(System.in);

    CustomerInterface allCustomers;

    public void setCustomerDataSource(String type){

        if (type.equalsIgnoreCase("Stub")){
            this.allCustomers = new AllCustomersStub();
        } else {
            this.allCustomers = new AllCustomers();
        }
    }

    public CustomerInterface getCustomerDataSource() { return this.allCustomers; }

    public static String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private String getPassword(String emailAddress){
        CustomerInterface allCustomers = getCustomerDataSource();
        String password = "";
        List<Customer> listOfCustomers = allCustomers.getListOfCustomers();
        for (Customer customer :listOfCustomers){
            if (customer.getEmailAddress().equals(emailAddress)){
                password = customer.getPassword();
            }
        }
        return password;
    }

    public boolean logIn() {
        String emailAddress = getString("Enter Email:");
        String password = getPassword(emailAddress);
        if (password.equals("")) {
            System.out.println("You are not a user");
            return false;
        }
        else if (password.equals(getString("Enter password"))){
            System.out.println("You are logged in");
            return true;
        }
        else {
            System.out.println("Wrong password, no second chances");
            return false;
        }
    }

    public static void main(String[] args){
        LogIn logIn = new LogIn();
        logIn.logIn();
    }
}