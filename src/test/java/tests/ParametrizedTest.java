package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ParametrizedTest{

/*
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        List<String> result = new ArrayList<>();
        result.add("One");
        result.add("Two");
        result.add("Three");
        return result;
    }
*/
    @Test
    public void someParamTest(String data){
        System.out.println(data);
    }

}
