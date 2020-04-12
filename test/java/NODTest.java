import org.junit.Test;
import simple.NOD;

import static org.junit.Assert.*;

public class NODTest {

    @Test
    public void testFindNOD() {
        assertEquals(1, NOD.findNOD(18, 35));
        assertEquals(4, NOD.findNOD(14159572, 63967072));
        assertEquals(257, NOD.findNOD(0, 257));
        assertEquals(18, NOD.findNOD(18, 0));
        assertEquals(0, NOD.findNOD(0, 0));
        assertEquals(546465, NOD.findNOD(546465, 546465));
    }

}