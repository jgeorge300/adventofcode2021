package one.jmg.aoc2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayTwoTests {
//    @Test
//    void simple() {
//        DayTwo dayTwo = new DayTwo();
//        dayTwo.loadCourse("input/day2simple.txt");
//        dayTwo.runCourse();
//
//        assertEquals(150, dayTwo.getHorizontalPos() * dayTwo.getDepth());
//    }
//
//    @Test
//    void partA() {
//        DayTwo dayTwo = new DayTwo();
//        dayTwo.loadCourse("input/day2.txt");
//        dayTwo.runCourse();
//
//        assertEquals(1693300, dayTwo.getHorizontalPos() * dayTwo.getDepth());
//    }

    @Test
    void simpleB() {
        DayTwo dayTwo = new DayTwo();
        dayTwo.loadCourse("input/day2simple.txt");
        dayTwo.runCourse();

        assertEquals(900, dayTwo.getHorizontalPos() * dayTwo.getDepth());
    }

    @Test
    void partB() {
        DayTwo dayTwo = new DayTwo();
        dayTwo.loadCourse("input/day2.txt");
        dayTwo.runCourse();

        assertEquals(1857958050, dayTwo.getHorizontalPos() * dayTwo.getDepth());
    }

}
