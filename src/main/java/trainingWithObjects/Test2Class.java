package trainingWithObjects;

public class Test2Class extends ParentTestClass{

    public Test2Class(String parentName, int parentId) {
        super(parentName, parentId);
    }

    public Test2Class(String parentName) {
        super(parentName);
    }

    @Override
    public String getSomeTestName() {
        return null;
    }

    public void some(){
        log.error("My fault");
    }


}
