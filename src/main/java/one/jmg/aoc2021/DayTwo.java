package one.jmg.aoc2021;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DayTwo {
    List<String> entries;

    @Getter
    int horizontalPos = 0;

    @Getter
    int depth = 0;

    @Getter
    int aim = 0;

    public DayTwo() {
        entries = new ArrayList<>();
    }

    public void runCourse() {
        for (String entry : entries) {
            String[] plot = entry.split(" ");
            switch (plot[0]) {
                case "forward":
                    horizontalPos += Integer.parseInt(plot[1]);
                    depth += aim * Integer.parseInt(plot[1]);
                    break;
                case "down":
                    aim += Integer.parseInt(plot[1]);
                    break;
                case "up":
                    aim -= Integer.parseInt(plot[1]);
                    break;
                default:
                    log.error("Unknown command");
            }
        }
    }

    public void loadCourse(String fileName) {
        entries = FileUtils.loadFile(fileName);
    }
}
