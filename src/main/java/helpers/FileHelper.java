package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.System.getProperty;

public class FileHelper {

    private final static Logger log = LogManager.getLogger("Помошник для работы с файлами");

    public static List<String> linesFromFile(String filePath){
        try {
            return Files.readAllLines(Paths.get(filePath));//, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    public static Map<String, String> loadDataForProvider(){
        String path = getProperty("user.dir") + "/src/test/resources/data/negativeAuthData.txt";
        Map<String, String> result = new TreeMap<>();
        linesFromFile(path).forEach(line -> {
            String[] tempLineArray = line.split(":");
            result.put(tempLineArray[0], tempLineArray[1]);
        });
        return result;
    }

    public static Map<String, String> loadDataForProvider(String filePath){
        Map<String, String> result = new TreeMap<>();
        linesFromFile(filePath).forEach(line -> {
            String[] tempLineArray = line.split(":");
            result.put(tempLineArray[0], tempLineArray[1]);
        });
        return result;
    }

    public static void writeToFile(String filePath, String text){
        List<String> textLines = Arrays.asList(text.split("\n"));
        try {
            File file = new File(filePath);
            if (!file.exists()){
                File dir = file.getParentFile();
                if(!dir.exists()){
                    dir.mkdirs();
                }
                file.createNewFile();
            }
            Files.write(Paths.get(filePath), textLines);
        } catch (IOException e) {
            log.error(e);
        }
    }

}
