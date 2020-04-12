import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import simple.ModFib;

public class ModFibTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void modDiv() {
        Assert.assertEquals(1, ModFib.modDiv(10, 2));
        Assert.assertEquals(1, ModFib.modDiv(1_000_000_000_000_000_000L, 100_000));
    }


}