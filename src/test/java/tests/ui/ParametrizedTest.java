package tests.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ParametrizedTest{

    private int param;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
            {2},
            {6},
            {19},
            {22},
            {23}
    });
    }

    public ParametrizedTest(int parameter){
        this.param = parameter;
    }

    @Test
    public void someParamTest(){
        System.out.println(this.param);
    }

    @Test
    public void someAnotherParamTest(){
        System.out.println(this.param - 5);
    }

}
