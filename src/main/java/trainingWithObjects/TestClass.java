package trainingWithObjects;

import someMain.ArrayStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestClass extends ParentTestClass{

    private List<String> privateList;

    public TestClass(String one, String two, String three){
        super(one, 2);
        privateList = new ArrayList<>();
        privateList.add(one);
        privateList.add(two);
        privateList.add(three);
    }

    public TestClass(String name){
        super(name);
        log.debug("");
    }

    public TestClass(String testName,
                     int testId,
                     String testDescription) {
        super(testName);
        this.testName = testName;
        this.testId = testId;
        this.testDescription = testDescription;
    }

    public TestClass(List<String> privateList) {
        super("That`s for you, dad");
        this.privateList = privateList;
    }

    public List<String> getPrivateList() {
        return privateList;
    }

    private String testName;
    private int testId;
    private String testDescription;

    @TestAnnotation(id = 1, name = "Some Test Name")
    public TestClass setTestName(String testName) {
        this.testName = testName;
        return this;
    }

    public TestClass setTestId(int testId) {
        this.testId = testId;
        return this;
    }

    public TestClass setTestDescription(String testDescription) {
        this.testDescription = testDescription;
        return this;
    }

    public String getTestName() {
        String[] charArray = testName.split(", ");
        for (String symbol : charArray){
            System.out.println(symbol);
        }
        return testName;
    }

    public int getTestId() {
        return testId;
    }

    public String getTestDescription() {
        return testDescription;
    }

    @Override
    public String toString(){
        return String.format("{Это наш экземпляр модели. Параметры:\n" +
                        "Идентификатор: %s, \n" +
                        "Имя: %s, \n" +
                        "Описание: %s" +
                        "}",
                this.testId,
                this.testName,
                this.testDescription );
    }

    @Override
    public boolean equals(Object o) {
        return ((TestClass) o).getTestId() == this.testId;
    }

    @Override
    public String getSomeTestName() {
        return null;
    }
}
