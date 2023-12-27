import org.junit.Test;
import util.Biller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BillerTests {

    @Test
    public void test0() {
        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 20, 20, 0);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 22, 15, 21);

        BigDecimal answer = getAnswer(entryTime, exitTime);
        assertEquals(BigDecimal.valueOf(23.30).setScale(2, RoundingMode.HALF_UP), answer);
    }

    @Test
    public void test1() {
        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 20, 20, 0);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 20, 22, 21);

        BigDecimal answer = getAnswer(entryTime, exitTime);
        assertEquals(BigDecimal.valueOf(1.20).setScale(2, RoundingMode.HALF_UP), answer);
    }

    @Test
    public void test2() {
        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 20, 20, 0);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 21, 10, 15);

        BigDecimal answer = getAnswer(entryTime, exitTime);
        assertEquals(BigDecimal.valueOf(2.70).setScale(2, RoundingMode.HALF_UP), answer);
    }

    @Test
    public void test3() {
        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 10, 15, 57);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 20, 8, 15);

        BigDecimal answer = getAnswer(entryTime, exitTime);
        assertEquals(BigDecimal.valueOf(135.70).setScale(2, RoundingMode.HALF_UP), answer);
    }

    @Test
    public void test4() {
        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 10, 15, 57);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 10, 13, 27);

        BigDecimal answer = getAnswer(entryTime, exitTime);
        assertEquals(BigDecimal.valueOf(0.0).setScale(2, RoundingMode.HALF_UP), answer);
    }

    @Test
    public void test5() {
        LocalDateTime entryTime = LocalDateTime.of(2023, 12, 10, 15, 57);
        LocalDateTime exitTime = LocalDateTime.of(2023, 12, 10, 16, 26);

        BigDecimal answer = getAnswer(entryTime, exitTime);
        assertEquals(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP), answer);
    }

    private static BigDecimal getAnswer(LocalDateTime entryTime, LocalDateTime exitTime) {
        BigDecimal answer = Biller.calculateBill(entryTime, exitTime);;
        return answer;
    }
}
