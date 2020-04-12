package greedy;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class SegmentTest {


    @Test
    @Ignore
    public void answer() {
        Long[][] mas = {{4L,7L},{1L,3L},{2L,5L},{5L,6L},{9L,13L}, };
        Segment segment = new Segment(mas);
        Long[] exp = {3L, 5L, 9L};
        assertArrayEquals(exp, segment.answer());
    }
}
