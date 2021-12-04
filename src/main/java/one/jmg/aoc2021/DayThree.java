package one.jmg.aoc2021;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DayThree {
    List<String> entries;
    int[] ones;

    @Getter
    int gamma;

    @Getter
    int epsilon;

    int oxygen;

    public DayThree(int numBits) {
        entries = new ArrayList<>();

        ones = new int[numBits];
    }

    public int numberOfOnes(int index, List<String> ratings) {
        int counter = 0;
        for (String entry : ratings) {
            char[] bits = entry.toCharArray();
            if (entry.charAt(index) == '1') {
                counter++;
            }
        }
        return counter;
    }

    public void processDiag() {
        for (String entry : entries) {
            char[] bits = entry.toCharArray();
            for (int i = 0; i < entry.length(); i++) {
                if (bits[i] == '1') {
                    ones[i]++;
                }
            }
        }
        StringBuilder ga = new StringBuilder();
        StringBuilder ep = new StringBuilder();
        for (int one : ones) {
            if (one > (entries.size() / 2)) {
                ga.append("1");
                ep.append("0");
            } else {
                ga.append("0");
                ep.append("1");
            }
        }
        gamma = Integer.parseInt(ga.toString(), 2);
        epsilon = Integer.parseInt(ep.toString(), 2);
    }

    public List<String> getSubset(int pos, char digit, int numToFind, List<String> fullSet) {
        List<String> newEntries = new ArrayList<>();
        int found = 0;
        for (String entry : fullSet) {
            if (entry.charAt(pos) == digit) {
                newEntries.add(entry);
                found++;
                if (found == numToFind) break;
            }
        }
        return newEntries;
    }

    public int getOxygen() {
        List<String> currentSet = new ArrayList<>(entries);
        for (int i = 0; i < ones.length; i++) {
            ones[i] = numberOfOnes(i, currentSet);
            if (ones[i] >= (currentSet.size() - ones[i])) {
                // FindOne
                currentSet = this.getSubset(i, '1', ones[i], currentSet);
            } else {
                // FindZero
                currentSet = this.getSubset(i, '0', currentSet.size() - ones[i], currentSet);
            }
            if (currentSet.size() == 1) {
                break;
            }
        }
        return Integer.parseInt(currentSet.get(0), 2);
    }

    public int getCO2() {
        List<String> currentSet = new ArrayList<>(entries);
        for (int i = 0; i < ones.length; i++) {
            ones[i] = numberOfOnes(i, currentSet);
            if (ones[i] < (currentSet.size() - ones[i])) {
                // FindOne
                currentSet = this.getSubset(i, '1', ones[i], currentSet);
            } else {
                // FindZero
                currentSet = this.getSubset(i, '0', currentSet.size() - ones[i], currentSet);
            }
            if (currentSet.size() == 1) {
                break;
            }
        }
        return Integer.parseInt(currentSet.get(0), 2);
    }

    public void loadDiagnosticReport(String fileName) {
        entries = FileUtils.loadFile(fileName);
    }
}
