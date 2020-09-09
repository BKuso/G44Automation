package tests.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static helpers.ExcelHelper.readProviderDataFromExcel;
import static helpers.FileHelper.linesFromFile;
import static java.lang.Integer.parseInt;
import static java.lang.System.getProperty;

@RunWith(Parameterized.class)
public class ParametrizedTest{

    private int param;
    private int param2;
    private List<Integer> labels;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        /*

        List<String> data = linesFromFile(getProperty("user.dir")
                + "/src/test/resources/data/input/data.txt");
        List<Object[]> result = new ArrayList<>();
        data.forEach(value ->{
            String[] values = value.split(", ");
            String[] labels = values[2].split(",");
            Object[] tepm = new Object[]{
                    values[0].trim(), values[1].trim(), Arrays.asList(labels)
            };
            result.add(tepm);
        });
        return result;
         */

        return readProviderDataFromExcel(getProperty("user.dir")
                + "/src/test/resources/data/input/test.xlsx", "Sheet1");
    }

    public ParametrizedTest(Object parameter1, Object parameter2, List<Integer> labels){
        this.param = parseInt(parameter1.toString());
        this.param2 = parseInt(parameter2.toString());
        this.labels = labels;
    }

    @Test
    public void someParamTest(){
        System.out.println(this.param+this.param2);
    }

    @Test
    public void someAnotherParamTest(){
        System.out.println(this.param - this.param2);
    }

    @Test
    public void showLabels(){
        System.out.println(this.labels);
    }

}
