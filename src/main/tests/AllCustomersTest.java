import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AllCustomersTest {

    @Test
    public void getListOfCustomersFromMock(){

        AllCustomers customerMock = mock(AllCustomers.class);
        List<Customer> listOfCustomers = new ArrayList<Customer>();

        listOfCustomers.add(new Customer("andy@glasgow.ac.uk", "andy","yule","9999"));

        when(customerMock.getListOfCustomers()).thenReturn(listOfCustomers);

        assertEquals("andy@glasgow.ac.uk", customerMock.getListOfCustomers().get(0).getEmailAddress());


    }

}
