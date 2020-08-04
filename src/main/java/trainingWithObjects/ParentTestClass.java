package trainingWithObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ParentTestClass implements TestInterface{

    protected Logger log;

    protected String parentName;

    public ParentTestClass(String parentName){
        this.parentName = parentName;
        log = LogManager.getLogger(this.parentName);
    }

    public ParentTestClass(String parentName, int parentId){
        this.parentName = parentName;
    }

    public void printSomethingAsLog(String something){
        log.info(something);
    }

}
