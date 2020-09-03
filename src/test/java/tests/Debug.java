package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static helpers.ExcelHelper.writeToExcelFile;
import static helpers.FileHelper.writeToFile;
import static java.lang.System.getProperty;

public class Debug {

    private final Logger log = LogManager.getLogger("Тест по работе с фалами");

    @Test
    public void some(){
        /*
        List<String> result = readColumnFromExcel(
                getProperty("user.dir") + "/src/test/resources/data/input/TestExcelFile.xlsx",
                "Sheet3"
        );
        */
        String text = "1. This is our text\n";// +
              //  "2. Second line\n";// +
             //   "3. Third line";
/*
        writeToFile(getProperty("user.dir") + "/src/test/resources/data/output/test_out.txt",
                text);
*/
        writeToExcelFile(getProperty("user.dir")+"/src/test/resources/data/output/excel_out.xlsx",
                "Тестовый лист", text);

   /*     Map<String, String> result = new HashMap<>();
       linesFromFile(getProperty("user.dir") + "/src/test/resources/data/input/negativeAuthData.txt")
        .forEach(line -> {
                   String[] tempLineArray = line.split(":");
                   result.put(tempLineArray[0], tempLineArray[1]);
               });
*/
     //  System.out.println(result);
    }

}