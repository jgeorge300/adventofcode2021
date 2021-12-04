package one.jmg.aoc2021;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayThreeTests {
    @Test
    void simple() {
        DayThree dayThree = new DayThree(5);
        dayThree.loadDiagnosticReport("input/day3simple.txt");
        dayThree.processDiag();
        assertEquals(198, dayThree.getEpsilon() * dayThree.getGamma());
    }

    @Test
    void partA() {
        DayThree dayThree = new DayThree(12);
        dayThree.loadDiagnosticReport("input/day3.txt");
        dayThree.processDiag();
        assertEquals(3882564, dayThree.getEpsilon() * dayThree.getGamma());
    }

    @Test
    void getOxygen() {
        DayThree dayThree = new DayThree(5);
        dayThree.loadDiagnosticReport("input/day3simple.txt");
        dayThree.processDiag();
        assertEquals(23, dayThree.getOxygen());
    }

    @Test
    void getCO2() {
        DayThree dayThree = new DayThree(5);
        dayThree.loadDiagnosticReport("input/day3simple.txt");
        dayThree.processDiag();
        assertEquals(10, dayThree.getCO2());
    }

    @Test
    void getSubset() {
        ArrayList<String> start = new ArrayList<>(Arrays.asList("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000", "11001", "00010", "01010"));
        DayThree dayThree = new DayThree(5);
        dayThree.loadDiagnosticReport("input/day3simple.txt");
        dayThree.processDiag();
        ArrayList<String> end = new ArrayList<>(Arrays.asList("11110", "10110", "10111", "10101", "11100", "10000", "11001"));
        List<String> subset = dayThree.getSubset(0, '1', 7, start);
        assertEquals(end, subset);
    }

    @Test
    void simpleB() {
        DayThree dayThree = new DayThree(5);
        dayThree.loadDiagnosticReport("input/day3simple.txt");
        dayThree.processDiag();
        assertEquals(230, dayThree.getOxygen() * dayThree.getCO2());
    }

    @Test
    void partB() {
        DayThree dayThree = new DayThree(12);
        dayThree.loadDiagnosticReport("input/day3.txt");
        dayThree.processDiag();
        assertEquals(3385170, dayThree.getOxygen() * dayThree.getCO2());
    }

}
