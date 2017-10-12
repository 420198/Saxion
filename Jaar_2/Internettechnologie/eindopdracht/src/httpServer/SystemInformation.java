package httpServer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Created by sklar on 12/22/2016.
 */
public class SystemInformation {
    private static SystemInformation information = new SystemInformation();
    private HashMap<String, Integer> pathMap = new HashMap<>();
    private int index;
    private char slash = '/';

    private SystemInformation() {
        String os = System.getProperty("os.name");
        if(os.contains("Windows")){
            this.slash = '\\';
        }
        try (Stream<Path> paths = Files.walk(Paths.get("htdocs"))) {
            paths.forEach(filePath -> {
                index++;
                if (Files.isRegularFile(filePath)) {
                    pathMap.put(filePath.toString().substring(6), index);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SystemInformation getInformation() {
        return information;
    }

    public HashMap<String, Integer> getPathMap() {
        return pathMap;
    }

    public char getSlash() {
        return slash;
    }
}
