package tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {
    @BeforeClass // runs only before BeforeMethof,and before all tests
public void beforeclass(){
    System.out.println("Before Class !");
}

@AfterClass
    public void afterclass(){
        System.out.println("After Class !");
    }
    @BeforeMethod //runs method before every test automatily

    public void setup() {
        //some code that will be running before every test, like test2 test2,test3
        //we can use method @Beforemethod annotation
        System.out.println("Before Method !");
    }

    @AfterMethod // runs automativly after every test
    public void teardown(){
        System.out.println("After Method !");
    }
    @Test
    public void test1(){
        System.out.println("Test 1!");
        Assert.assertTrue(5==5);
    }

    @Test
    public void test2(){

        System.out.println("Test 2!");
    }

    @Test
    public void test3(){
        System.out.println("Test 3!");
    }
}
