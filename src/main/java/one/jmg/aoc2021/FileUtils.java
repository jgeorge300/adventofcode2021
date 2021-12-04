package one.jmg.aoc2021;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> loadFile(String fileName) {
        List<String> entries = new ArrayList<>();
        try (InputStream is = FileUtils.class.getClassLoader().getResourceAsStream(fileName)) {
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
        return entries;
    }
}
