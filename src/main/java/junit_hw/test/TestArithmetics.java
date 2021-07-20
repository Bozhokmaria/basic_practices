package junit_hw.test;

import junit_hw.for_test.Arithmetics;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestArithmetics {

    private static Arithmetics a;

//    @Rule
//    public ExpectedException exp =  ExpectedException.none();


    //    @Before
    @BeforeClass
    public static void runT() {
        a = new Arithmetics();
    }

//    @AfterClass
//    @After
//    public void T() {
//        a = null;
//    }

    @Test
//    @Ignore
    public void testAdd() {
//        runT();
//        Arithmetics a = new Arithmetics();
        double res = a.add(3, 7);
//        if(res !=10) Assert.fail();
        Assert.assertTrue("Result - 10", res == 10);
        Assert.assertNotNull(res);
//        a = null;
    }

    @Test
    public void testMult() {
//        Arithmetics a = new Arithmetics();
        double res = a.mult(3, 7);
//        if(res !=21) Assert.fail();
        Assert.assertTrue(res == 21);
    }

    @Test
    public void testDeduct() {
//        Arithmetics a = new Arithmetics();
        double res = a.deduct(3, 7);
//        if(res !=-4) Assert.fail();
        Assert.assertTrue(res == -4);

//        //junit3
//        try {
//            a.divide(10,0);
//            Assert.fail();
//        }catch (ArithmeticException e){}
    }


    @Test
    public void testDivide() {
//        Arithmetics a = new Arithmetics();
        double res = a.divide(21, 7);
//        if(res !=3) Assert.fail();
        Assert.assertTrue(res == 3);
    }

//    @Test
//    public void testDivException() {
//        exp.expect(ArithmeticException.class);
//        a.divide(10.0, 0.0);
//    }
}
