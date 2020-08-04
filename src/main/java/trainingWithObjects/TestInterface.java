package trainingWithObjects;

public interface TestInterface {


    String getSomeTestName();

    default String getDefaultString(){
        return "Default string";
    }

}
