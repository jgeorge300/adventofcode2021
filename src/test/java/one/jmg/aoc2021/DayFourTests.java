package one.jmg.aoc2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayFourTests {
    @Test
    void simple() {
        DayFour dayFour = new DayFour("input/day4simple.txt");
        assertEquals(2, dayFour.firstWinningBoard());
        assertEquals(11, dayFour.winningIndex(2));
        assertEquals(188, dayFour.sumOfUnmarked(2, 11));
        assertEquals(4512, dayFour.numberCalled(11) * 188);
        assertEquals(1, dayFour.lastWinningBoard());
    }

    @Test
    void partA() {
        DayFour dayFour = new DayFour("input/day4.txt");
        assertEquals(93, dayFour.firstWinningBoard());
        assertEquals(29, dayFour.winningIndex(93));
        assertEquals(693, dayFour.sumOfUnmarked(93, 29));
        assertEquals(27027, dayFour.numberCalled(29) * 693);
    }

    @Test
    void partB() {
        DayFour dayFour = new DayFour("input/day4.txt");
        assertEquals(21, dayFour.lastWinningBoard());
        assertEquals(87, dayFour.winningIndex(21));
        assertEquals(425, dayFour.sumOfUnmarked(21, 87));
        assertEquals(36975, dayFour.numberCalled(87) * 425);
    }

}
