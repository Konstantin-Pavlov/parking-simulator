import carStates.OnPark;
import model.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.CarRegNumberGenerator;
import util.ConsoleColors;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CarStateTests {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void test0() {
        Car car = new Car(CarRegNumberGenerator.getNewRegNumber());
        assertEquals("driving", car.getStateMessage());
    }

    @Test
    public void test1() {
        Car car = new Car(CarRegNumberGenerator.getNewRegNumber());
        car.setState(new OnPark());
        assertEquals("parked", car.getStateMessage());
    }

    @Test
    public void test2() {
        //test actually is passed but getting the message that content is different only in line separators
        // it shows that expected is crlf, actual is lf
        // The difference in line separators between CRLF (Carriage Return + Line Feed) and LF (Line Feed) can cause discrepancies when comparing console output.
        // This issue is commonly encountered when working with code editors or version control systems that handle line endings differently.
        // Now test works fine

        Car car = new Car(CarRegNumberGenerator.getNewRegNumber());
        car.leave();
        String expected = ConsoleColors.RED_BACKGROUND +
                "it is impossible to leave the parking lot because the car is on the way and is not in the parking lot" +
                ConsoleColors.RESET + "\n";
        String actual = outputStream.toString().replaceAll("\\r\\n", "\n");
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        Car car = new Car(CarRegNumberGenerator.getNewRegNumber());
        car.setState(new OnPark());
        car.park();
        String expected = ConsoleColors.RED_BACKGROUND +
                "it is impossible to park the car because the car is already parked and is in the parking lot" +
                ConsoleColors.RESET + "\n";
        String actual = outputStream.toString().replaceAll("\\r\\n", "\n");
        assertEquals(expected, actual);
    }
}
