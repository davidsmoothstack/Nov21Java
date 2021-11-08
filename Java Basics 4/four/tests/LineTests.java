package four.tests;

import org.junit.Before;
import org.junit.Test;

import four.Line;

import static org.junit.Assert.assertEquals;

public class LineTests {
    public static final double DELTA = 0.0001;
    private Line sut;

    @Before
    public void beforeEach() {
        this.sut = new Line(0, 0, 2, 4);
    }

    @Test
    public void getSlope_returns_correctSlope() {
        assertEquals(2, this.sut.getSlope(), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void getSlope_throws_whenX1EqualsX0() {
        this.sut = new Line(0, 0, 0, 0);
        this.sut.getSlope();
    }

    @Test
    public void getDistance_returns_correctDistance() {
        double expected = 4.47213595499958;
        assertEquals(expected, this.sut.getDistance(), DELTA);
    }

    @Test
    public void parallelTo_returns_true_whenLinesAreParallel() {
        this.sut = new Line(1, 2, 3, 4);
        final Line parallel = new Line(2, 4, 6, 8);

        assertEquals(true, this.sut.parallelTo(parallel));
    }

    @Test
    public void parallelTo_returns_false_whenLinesAreNotParallel() {
        final Line notParallel = new Line(10, 20, 30, 40);

        assertEquals(false, this.sut.parallelTo(notParallel));
    }
}
