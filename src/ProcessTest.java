import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ProcessTest {
    @Test
    public void testingProcessMethod()
    {
        SomeService s = Mockito.mock(SomeService.class);
        when(s.doSomething(7)).thenReturn("Number Passed");

        Process p = new Process(s);
        String result = p.process(7);
        Assert.assertEquals("Result = Number Passed", result);
        verify(s,atMost(1)).doSomething(7);

        when(s.doSomething(anyInt())).thenReturn("Number Passed");
        result = p.process(7);
        Assert.assertEquals("Result = Number Passed", result);

        result = p.process(3);
        Assert.assertEquals("Result = Number Passed", result);
        result = p.process(3);
        Assert.assertEquals("Result = Number Passed", result);
        verify(s,atMost(2)).doSomething(anyInt());

        //verify(s,times(1)).doSomething(anyInt());

    }

}
