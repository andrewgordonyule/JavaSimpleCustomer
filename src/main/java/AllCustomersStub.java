import java.util.ArrayList;
import java.util.List;

public class AllCustomersStub implements CustomerInterface {

    private List<Customer> listOfCustomers = new ArrayList<Customer>();

    @Override
    public List<Customer> getListOfCustomers() {
        listOfCustomers.add(new Customer("test@glasgow.ac.uk", "test","user","1234"));
        return listOfCustomers;
    }
}
