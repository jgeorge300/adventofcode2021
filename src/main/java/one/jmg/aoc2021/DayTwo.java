package one.jmg.aoc2021;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Slf4j
public class DayTwo {
    ArrayList<String> entries;

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
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            try {
                assert is != null;
                try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
                     BufferedReader reader = new BufferedReader(streamReader)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        entries.add(line);
                    }
                }
            } catch (IIOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
