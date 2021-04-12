import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

class LogInTest {

    @Test
    void logInFromFileTest() {

        ByteArrayInputStream in2 = new ByteArrayInputStream("derek.somerville@glasgow.ac.uk\n1234".getBytes());
        System.setIn(in2);
        LogIn login = new LogIn();
        login.setCustomerDataSource("File");

        boolean loggedIn = login.logIn();

        assertTrue(loggedIn);

    }

    @Test
    void logInFailsWithUnknownUser(){

        ByteArrayInputStream in3 = new ByteArrayInputStream("unknown@gla.ac.uk\n0000".getBytes());
        System.setIn(in3);
        LogIn login = new LogIn();
        login.setCustomerDataSource("File");

        boolean loggedIn = login.logIn();

        assertFalse(loggedIn);

    }

    @Test
    void logInFromStubTest() {

        ByteArrayInputStream in = new ByteArrayInputStream("test@glasgow.ac.uk\n1234".getBytes());
        System.setIn(in);
        LogIn login = new LogIn();
        login.setCustomerDataSource("Stub");

        boolean loggedIn = login.logIn();

        assertTrue(loggedIn);

    }

}