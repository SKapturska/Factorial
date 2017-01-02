import factorial.FactorialIteration;
import factorial.FactorialRecursion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FactorialTests {
    FactorialIteration fu;
    FactorialRecursion fr;
    
    public FactorialTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testFactorialIteration(){
        fu = new FactorialIteration(10);
        fu.run();
        long actualValue = fu.getResult();
        Assert.assertEquals(3628800, actualValue);
    }
    
    @Test
    public void testFactorialRecursion(){
        fr = new FactorialRecursion(10);
        fr.run();
        Assert.assertEquals(3628800, fr.getResult());
    }
    
        
    @Test
    public void testFactorialIteration2(){
        fu = new FactorialIteration(7);
        fu.run();
        long actualValue = fu.getResult();
        Assert.assertEquals(5040, actualValue);
    }
    
    @Test
    public void testFactorialRecursion2(){
        fr = new FactorialRecursion(7);
        fr.run();
        Assert.assertEquals(5040, fr.getResult());
    }
    
    
    @Test
    public void testFactorialIteration3(){
        fu = new FactorialIteration(1);
        fu.run();
        long actualValue = fu.getResult();
        Assert.assertEquals(1, actualValue);
    }
    
    @Test
    public void testFactorialRecursion3(){
        fr = new FactorialRecursion(1);
        fr.run();
        Assert.assertEquals(1, fr.getResult());
    }
}
