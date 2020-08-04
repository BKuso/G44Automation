package someMain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import trainingWithObjects.ParentTestClass;
import trainingWithObjects.Test2Class;
import trainingWithObjects.TestClass;

import java.io.FileNotFoundException;
import java.nio.InvalidMarkException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

public class Application {

    private final static Logger LOG = LogManager.getLogger(Application.class);

    private int some = 20;
    boolean someBoolean;


    private static String name;

    public static void main(String[] args) {
        TestClass test1 = new TestClass("Test One");
        Test2Class test2 = new Test2Class("Test Two");
        Test2Class test21 = new Test2Class("Test 21");

        System.out.println("This for merge resolution");

        test1.printSomethingAsLog("Something");
        test2.printSomethingAsLog("Something");
        test21.getSomeTestName();
    }


    public void a (){
        try {
            LOG.info(String.format("This is Info Message %s", 6));
            LOG.debug("This is Debug Message");
            LOG.error("This is Error Message");


            LOG.trace("This is Trace Message");
            LOG.warn("This is Warning Message");

            LOG.fatal("");
        } catch (NullPointerException
                | NumberFormatException n) {
            LOG.error("Catch NullPointerException: ");
        } catch (IndexOutOfBoundsException ignore) {
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            LOG.error(e.getCause().toString());


            ///     TestClass test = new TestClass("1", 2, "3");
            // test.setTestName("test Name").setTestDescription("").setTestId(1);

            //   test.setTestDescription("test Description");
            //  test.setTestName("test, Name");
            //   test.setTestId(1);


        /*
        Test2Class test2Instance = new Test2Class("test 2 class", 2);

       System.out.println(new ArrayStudy().getDefaultString());

        List<ParentTestClass> testClasses = new ArrayList<>();

        testClasses.add(test);
        testClasses.add(test2Instance);


        for(ParentTestClass testClass : testClasses){
            System.out.println(testClass.getSomeTestName());
        }




        TestClass test2 = new TestClass(
                "Test2",
                2,
                "some test 2");

        System.out.println(test == test2);

        System.out.println(test.equals(test2) ? "Да, они равны": "Нет, они не равны");

        System.out.println(test.toString());


         */
        }

    /*
        Object obj = new Object();
        SomeModel model1 = new SomeModel()
                .setId(25)
                .setName("Some Name for 25")
                .setSomeString("Some string");
        SomeModel model2 = new SomeModel()
                .setId(30)
                .setName("Some Name for 30")
                .setSomeString("Some string");

        Map<String, SomeModel> ourMap = new HashMap<>();
        ourMap.put("model 1", model1);
        ourMap.put("model 2", model2);

        System.out.println(ourMap.get("model 1"));
        ourMap.get("model 1").setSomeString("Changed value");
        System.out.println(ourMap.get("model 1"));

        int one = 2;
        int two = 4;

        System.out.println("" + (one + two));

       // System.out.println(ourMap.get("model 1").toString());
        //study.sum(new int[]{15, 15, 15, 20, 5, 272, 283});
    }

     */

    }
}
