import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import simple.LastDigitFib;

public class LastDigitFibTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void fib() {
        Assert.assertEquals(9, LastDigitFib.fib(696352));
    }
}