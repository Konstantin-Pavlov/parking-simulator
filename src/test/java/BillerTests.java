import customExceptions.IlligalDateException;
import org.junit.Test;
import util.Biller;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BillerTests {
    String fmt = "%.2f";

    @Test
    public void test0() {
        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 20, 20, 0);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 22, 15, 21);

        String answer = null;
        try {
            answer = String.format(fmt, Biller.calculateBill(entryTime, exitTime));
        } catch (IlligalDateException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("23,30", answer);
    }

    @Test
    public void test1() {
        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 20, 20, 0);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 20, 22, 21);

        String answer = null;
        try {
            answer = String.format(fmt, Biller.calculateBill(entryTime, exitTime));
        } catch (IlligalDateException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("1,20", answer);
    }

    @Test
    public void test2() {
        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 20, 20, 0);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 21, 10, 15);

        String answer = null;
        try {
            answer = String.format(fmt, Biller.calculateBill(entryTime, exitTime));
        } catch (IlligalDateException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("2,70", answer);
    }

    @Test
    public void test3() {
        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 10, 15, 57);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 20, 8, 15);

        String answer = null;
        try {
            answer = String.format(fmt, Biller.calculateBill(entryTime, exitTime));
        } catch (IlligalDateException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("135,70", answer);
    }

    @Test
    public void test4() {
        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 10, 15, 57);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 10, 13, 27);

        String answer = null;
        try {
            answer = String.format(fmt, Biller.calculateBill(entryTime, exitTime));
        } catch (IlligalDateException e) {
            System.out.println(e.getMessage());
        }
        assertNull(answer);
    }    @Test
    public void test5() {
        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 10, 15, 57);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 10, 16, 26);

        String answer = null;
        try {
            answer = String.format(fmt, Biller.calculateBill(entryTime, exitTime));
        } catch (IlligalDateException e) {
            System.out.println(e.getMessage());
        }
        assertEquals("0,00", answer);    }
}
