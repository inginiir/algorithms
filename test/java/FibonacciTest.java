import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FibonacciTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void fib() {
        Assert.assertEquals(6765, Fibonacci.fib(20));
    }
}