package one.jmg.aoc2021;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
public class DayOne implements CommandLineRunner {
    public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
        SpringApplication.run(DayOne.class, args);
        log.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) throws URISyntaxException, IOException {
        partA();
        partB();
    }

    public void partA() throws URISyntaxException, IOException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("input/day1.txt")).toURI());

        Stream<String> lines = Files.lines(path);
        Object[] data = lines.toArray();
        lines.close();
        int increasing = 0;
        int previous = Integer.MAX_VALUE;
        for (Object x : data) {
            String y = x.toString();
            int value = Integer.parseInt(y);
            log.debug(String.valueOf(value));
            if (value > previous) {
                increasing++;
            }
            previous = value;
        }
        log.info("Increasing: " + increasing);

    }

    public void partB() throws URISyntaxException, IOException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource("input/day1simple.txt")).toURI());

        Stream<String> lines = Files.lines(path);
        Object[] data = lines.toArray();
        lines.close();
        int increasing = 0;
        int previous = Integer.MAX_VALUE;
        for (int i = 2; i < data.length; i++) {
            int value = Integer.parseInt((String) data[i]) + Integer.parseInt((String) data[i - 1]) + Integer.parseInt((String) data[i - 2]);
            log.debug(String.valueOf(value));
            if (value > previous) {
                increasing++;
            }
            previous = value;
        }
        log.info("Increasing: " + increasing);

    }

}
