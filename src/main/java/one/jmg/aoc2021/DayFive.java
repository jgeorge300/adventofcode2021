package one.jmg.aoc2021;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class DayFive {
    static int boardSize = 1000;
    int[][] board = new int[boardSize][boardSize];

    public DayFive(String fileName) {
        List<String> entries = FileUtils.loadFile(fileName);

        for (String entry : entries) {
            String[] pairs = entry.split("[ ]+");
            int[] ptA = Arrays.stream(pairs[0].split(",")).mapToInt(Integer::parseInt).toArray();
            int[] ptB = Arrays.stream(pairs[2].split(",")).mapToInt(Integer::parseInt).toArray();
            if (ptA[0] == ptB[0]) {
                int start = Math.min(ptA[1], ptB[1]);
                int end = Math.max(ptA[1], ptB[1]);
                for (int y = start; y <= end; y++) {
                    board[ptA[0]][y]++;
                }
            } else if (ptA[1] == ptB[1]) {
                int start = Math.min(ptA[0], ptB[0]);
                int end = Math.max(ptA[0], ptB[0]);
                for (int x = start; x <= end; x++) {
                    board[x][ptA[1]]++;
                }
            } else if (isDiag(ptA, ptB)) {
                int tmpX = ptA[0];
                int tmpY = ptA[1];

                while (tmpX != ptB[0] && tmpY != ptB[1]) {
                    board[tmpX][tmpY]++;
                    tmpX += (ptA[0] < ptB[0]) ? 1 : -1;
                    tmpY += (ptA[1] < ptB[1]) ? 1 : -1;
                }
                board[tmpX][tmpY]++;
            }
        }
        int crossings = 0;
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                if (board[x][y] > 1) {
                    crossings++;
                }
            }
        }
        log.info("crossings: " + crossings);
    }

    public static void main(String[] args) {
        DayFive dayFiveSimple = new DayFive("input/day5simple.txt");
        DayFive dayFive = new DayFive("input/day5.txt");
    }

    public boolean isDiag(int[] ptA, int[] ptB) {
        float slope = (ptA[1] - ptB[1]) / (ptA[0] - ptB[0]);
        return Math.abs(slope) == 1;
    }
}
