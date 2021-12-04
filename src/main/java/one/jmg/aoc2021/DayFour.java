package one.jmg.aoc2021;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class DayFour {
    int[][][] bingoBoards;
    int numOfBoards;
    ArrayList<Integer> callSheet;

    public DayFour(String fileName) {
        ArrayList<String> lines = (ArrayList<String>) FileUtils.loadFile(fileName);

        callSheet = new ArrayList<>();
        for (String str : lines.get(0).split(",")) {
            callSheet.add(Integer.parseInt(str));
        }

        numOfBoards = (lines.size() - 1) / 6;
        bingoBoards = new int[numOfBoards][5][5];

        for (int i = 0; i < numOfBoards; i++) {
            int boardIdx = i * 6;
            bingoBoards[i][0] = Arrays.stream(lines.get(boardIdx + 2).trim().split("[ ]+")).mapToInt(Integer::parseInt).toArray();
            bingoBoards[i][1] = Arrays.stream(lines.get(boardIdx + 3).trim().split("[ ]+")).mapToInt(Integer::parseInt).toArray();
            bingoBoards[i][2] = Arrays.stream(lines.get(boardIdx + 4).trim().split("[ ]+")).mapToInt(Integer::parseInt).toArray();
            bingoBoards[i][3] = Arrays.stream(lines.get(boardIdx + 5).trim().split("[ ]+")).mapToInt(Integer::parseInt).toArray();
            bingoBoards[i][4] = Arrays.stream(lines.get(boardIdx + 6).trim().split("[ ]+")).mapToInt(Integer::parseInt).toArray();
        }
    }

    public int winningIndex(int board) {
        int index = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            int[] hlocs = {-1, -1, -1, -1, -1};
            int[] vlocs = {-1, -1, -1, -1, -1};
            for (int j = 0; j < 5; j++) {
                if (callSheet.contains(bingoBoards[board][i][j])) {
                    hlocs[j] = callSheet.indexOf(bingoBoards[board][i][j]);
                }
                if (callSheet.contains(bingoBoards[board][j][i])) {
                    vlocs[j] = callSheet.indexOf(bingoBoards[board][j][i]);
                }
            }
            Arrays.sort(hlocs);
            Arrays.sort(vlocs);
            if ((hlocs[0] != -1) && (hlocs[4] < index)) {
                index = hlocs[4];
            }
            if ((vlocs[0] != -1) && (vlocs[4] < index)) {
                index = vlocs[4];
            }
        }

        return index;
    }

    public int sumOfUnmarked(int board, int index) {
        int sum = 0;
        List<Integer> called = callSheet.subList(0, index + 1);

        List<Integer> sheet = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Collections.addAll(sheet, Arrays.stream(bingoBoards[board][i]).boxed().toArray(Integer[]::new));
        }
        for (Integer number : called) {
            sheet.remove(number);
        }
        for (Integer number : sheet) {
            sum += number;
        }
        return sum;
    }

    public int numberCalled(int index) {
        return callSheet.get(index);
    }

    public int firstWinningBoard() {
        int index = Integer.MAX_VALUE;
        int winningBoard = -1;
        for (int i = 0; i < numOfBoards; i++) {
            int win = this.winningIndex(i);
            if (win < index) {
                index = win;
                winningBoard = i;
            }
        }
        return winningBoard;
    }

    public int lastWinningBoard() {
        int index = 0;
        int winningBoard = -1;
        for (int i = 0; i < numOfBoards; i++) {
            int win = this.winningIndex(i);
            if (win > index) {
                index = win;
                winningBoard = i;
            }
        }
        return winningBoard;
    }

}
