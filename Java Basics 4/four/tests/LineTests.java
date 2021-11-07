package four.tests;

import org.junit.Before;
import org.junit.Test;

import four.Line;

import static org.junit.Assert.assertEquals;

public class LineTests {
    private Line sut;

    @Before
    public void beforeEach() {
        this.sut = new Line(0, 0, 2, 4);
    }

    @Test
    public void getSlope_returns_correctSlope() {
        assertEquals(2, this.sut.getSlope(), 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void getSlope_throws_whenX1EqualsX0() {
        this.sut = new Line(0, 0, 0, 0);
        this.sut.getSlope();
    }

    @Test
    public void getDistance_returns_correctDistance() {
        assertEquals(4.47213595499958, this.sut.getDistance(), 0.0001);
    }

    @Test
    public void parallelTo_returns_true_whenLinesAreParallel() {
        this.sut = new Line(1, 2, 3, 4);
        final var parallel = new Line(2, 4, 6, 8);

        assertEquals(true, this.sut.parallelTo(parallel));
    }

    @Test
    public void parallelTo_returns_false_whenLinesAreNotParallel() {
        final var notParallel = new Line(10, 20, 30, 40);

        assertEquals(false, this.sut.parallelTo(notParallel));
    }
}
