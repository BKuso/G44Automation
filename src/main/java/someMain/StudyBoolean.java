package someMain;

public class StudyBoolean {

    private final int someValueTest = 6;
    private int privateInteger = 0;

    /**
     * Method make equal
     *
     * @param someValue Is someMain.Some random value
     * @return Yes|No|Value equal 0
     */
    public StudyBoolean makeEqual(int someValue){
        System.out.println(someValue > 0 ? "Yes" : someValue < 0 ? "No" : "Value equal 0");
        privateInteger = someValue;
        return this;
    }

    public void printPrivateInteger(){
        System.out.println(privateInteger);
    }













    public void makeCycle() {
        int iterator = 0;
        while (true) {
            iterator = iterator + 1;
            if(iterator == 3){
                continue;
            }
            System.out.println("Value of iterator = " + iterator);
            if (iterator < 0) {
                break;
            }
        }
    }
}
