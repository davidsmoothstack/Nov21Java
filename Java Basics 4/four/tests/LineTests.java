package four.tests;

import org.junit.Before;
import org.junit.Test;

import four.Line;

import static org.junit.Assert.assertEquals;

public class LineTests {
    private Line sut;

    @Before
    public void beforeEach() {
        sut = new Line(0, 0, 2, 4);
    }

    @Test
    public void getSlope_returns_correctSlope() {
        assertEquals(2, sut.getSlope(), 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void getSlope_throws_whenX1EqualsX0() {
        sut = new Line(0, 0, 0, 0);
        sut.getSlope();
    }

    @Test
    public void getDistance_returns_correctDistance() {
        assertEquals(4.47213595499958, sut.getDistance(), 0.0001);
    }

    @Test
    public void parallelTo_returns_true_whenLinesAreParallel() {
        sut = new Line(1, 2, 3, 4);
        var parallel = new Line(2, 4, 6, 8);

        assertEquals(true, sut.parallelTo(parallel));
    }

    @Test
    public void parallelTo_returns_false_whenLinesAreNotParallel() {
        var notParallel = new Line(10, 20, 30, 40);

        assertEquals(false, sut.parallelTo(notParallel));
    }
}
