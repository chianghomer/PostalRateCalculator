package ecse428.mcgill.ca.postalratecalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import models.LetterMail;
import models.PostRateCalculator;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class LetterMailDestinationTest {

    private LetterMail letterMail;

    @Before
    public void initializeLetterMail() {
        letterMail = new LetterMail();
    }

    @After
    public void tearDown() {
        letterMail = null;
    }


    @Test
    public void TestSetDestinationNormal(){
        letterMail.setDestination("Canada");
        assertEquals("Canada", letterMail.getDestination());
    }

    @Test
    public void TestSetDestinationEmpty(){
        letterMail.setDestination("");
        assertEquals("Please select your destination", letterMail.getDestination());
    }
    @Test
    public void TestSetWidth() {
        letterMail.setWidth(100.00);
        assertEquals(100.00, letterMail.getWidth(), 0.0);
    }

    @Test
    public void TestSetHeight() {
        letterMail.setHeight(50.50);
        assertEquals(50.50, letterMail.getHeight(), 0.0);
    }

    @Test
    public void TestSetDepth() {
        letterMail.setDepth(45.45);
        assertEquals(45.45, letterMail.getDepth(), 0.0);
    }

    @Test
    public void TestSetWeight() {
        letterMail.setWeight(25.25);
        assertEquals(25.25, letterMail.getWeight(), 0.0);
    }

    @Test
    public void TestWidthMeetMinRequirement(){
        letterMail.setDestination("canada");
        letterMail.setWidth(110);
        letterMail.setDepth(110);
        letterMail.setHeight(0.2);
        PostRateCalculator pr = new PostRateCalculator(letterMail.getWidth(), letterMail.getDepth(), letterMail.getHeight(),letterMail.getWeight());
        double calculatedRate = pr.calculatePostRateFromDest(letterMail.getDestination());
            assert calculatedRate == -1.0:"test fail to check whether the width meet the minimum width requirement";
            //System.out.println("successful to check whether the width meet the minimum width requirement");
    }
    @Test
    //8
    public void TestDepthMeetMinRequirement(){
        letterMail.setDestination("canada");
        letterMail.setWidth(170);
        letterMail.setDepth(80);
        letterMail.setHeight(0.2);
        PostRateCalculator pr = new PostRateCalculator(letterMail.getWidth(), letterMail.getDepth(), letterMail.getHeight(),letterMail.getWeight());
        double calculatedRate = pr.calculatePostRateFromDest(letterMail.getDestination());
        assert calculatedRate == -1.0:"test fail to check whether the depth meet the minimum width requirement";
        //System.out.println("successful to check whether the depth meet the minimum width requirement");
    }
    @Test
    //9
    public void TestHeightMeetMinRequirement(){
        letterMail.setDestination("canada");
        letterMail.setWidth(170);
        letterMail.setDepth(130);
        letterMail.setHeight(0.15);
        PostRateCalculator pr = new PostRateCalculator(letterMail.getWidth(), letterMail.getDepth(), letterMail.getHeight(),letterMail.getWeight());
        double calculatedRate = pr.calculatePostRateFromDest(letterMail.getDestination());
        assert calculatedRate == -1.0:"test fail to check whether the height meet the minimum height requirement";
        //System.out.println("successful to check whether the height meet the minimum width requirement");
    }
    @Test
    //10
    public void  TestWidthExceedMaxRequirement(){
        letterMail.setDestination("canada");
        letterMail.setWidth(400);
        letterMail.setDepth(130);
        letterMail.setHeight(0.7);
        PostRateCalculator pr = new PostRateCalculator(letterMail.getWidth(), letterMail.getDepth(), letterMail.getHeight(),letterMail.getWeight());
        double calculatedRate = pr.calculatePostRateFromDest(letterMail.getDestination());
        assert calculatedRate == -1.0:"test fail to check whether the Width exceed the maximum Width requirement";
        //System.out.println("successful to check whether the width meet the maximum width requirement");
    }

    @Test
    //11
    public void  TestDepthExceedMaxRequirement(){
        letterMail.setDestination("canada");
        letterMail.setWidth(300);
        letterMail.setDepth(300);
        letterMail.setHeight(0.7);
        PostRateCalculator pr = new PostRateCalculator(letterMail.getWidth(), letterMail.getDepth(), letterMail.getHeight(),letterMail.getWeight());
        double calculatedRate = pr.calculatePostRateFromDest(letterMail.getDestination());
        assert calculatedRate == -1.0:"test fail to check whether the Depth exceed the maximum Depth requirement";
        //System.out.println("successful to check whether the Depth meet the maximum Depth requirement");
    }

    @Test
    //12
    public void  TestHeightExceedMaxRequirement(){
        letterMail.setDestination("canada");
        letterMail.setWidth(300);
        letterMail.setDepth(250);
        letterMail.setHeight(30);
        PostRateCalculator pr = new PostRateCalculator(letterMail.getWidth(), letterMail.getDepth(), letterMail.getHeight(),letterMail.getWeight());
        double calculatedRate = pr.calculatePostRateFromDest(letterMail.getDestination());
        assert calculatedRate == -1.0:"test fail to check whether the Height exceed the maximum Height requirement";
        //System.out.println("successful to check whether the Height meet the maximum height requirement");
    }
    @Test
    //13 test whether the letter mail is standard or not: oversize means the dimension is larger than 245*156*5 or larger than 50g
    public void TestStandardMailLetterCanada(){
        letterMail.setDestination("canada");
        letterMail.setWidth(240);
        letterMail.setDepth(100);
        letterMail.setHeight(2);
        letterMail.setWeight(45);
        PostRateCalculator pr = new PostRateCalculator(letterMail.getWidth(), letterMail.getDepth(), letterMail.getHeight(),letterMail.getWeight());
        double calculatedRate = pr.calculatePostRateFromDest(letterMail.getDestination());
        assert calculatedRate == 1.20:"test is failed or unavailable to check whether mail letter is standard";
        //System.out.println("Test case has validated the functionality for calculate the post rate of the within-Canada mail letter");
    }

    @Test
    //14 test whether the letter mail is oversize: oversize means the dimension is larger than 245*156*5 or larger than 50g
    public void TestOversizeMailLetterCanada(){
        letterMail.setDestination("canada");
        letterMail.setWidth(300);
        letterMail.setDepth(200);
        letterMail.setHeight(15);
        letterMail.setWeight(490);
        PostRateCalculator pr = new PostRateCalculator(letterMail.getWidth(), letterMail.getDepth(), letterMail.getHeight(),letterMail.getWeight());
        double calculatedRate = pr.calculatePostRateFromDest(letterMail.getDestination());
        assert calculatedRate == 5.05:"test is failed or unavailable to check whether mail letter is oversize or not";
       // System.out.println("Test case has validated the functionality for calculate the post rate of the within-Canada oversize mail letter");
    }

    @Test
    //15 test whether the USA letter mail is standard or not: oversize means the dimension is larger than 245*156*5 or larger than 50g
    public void TestStandardMailLetterUSA(){
        letterMail.setDestination("USA");
        letterMail.setWidth(240);
        letterMail.setDepth(100);
        letterMail.setHeight(2);
        letterMail.setWeight(45);
        PostRateCalculator pr = new PostRateCalculator(letterMail.getWidth(), letterMail.getDepth(), letterMail.getHeight(),letterMail.getWeight());
        double calculatedRate = pr.calculatePostRateFromDest(letterMail.getDestination());
        assert calculatedRate == 1.80:"test is failed or unavailable to check whether mail letter is standard";
        //System.out.println("Test case has validated the functionality for calculate the post rate of the Canada - USA standard mail letter");
    }
    @Test
    //16 test whether the letter mail is oversize: oversize means the dimension is larger than 245*156*5 or larger than 50g
    public void TestOversizeMailLetterUSA(){
        letterMail.setDestination("USA");
        letterMail.setWidth(300);
        letterMail.setDepth(200);
        letterMail.setHeight(15);
        letterMail.setWeight(490);
        PostRateCalculator pr = new PostRateCalculator(letterMail.getWidth(), letterMail.getDepth(), letterMail.getHeight(),letterMail.getWeight());
        double calculatedRate = pr.calculatePostRateFromDest(letterMail.getDestination());
        assert calculatedRate == 10.30:"test is failed or unavailable to check whether USA mail letter is oversize or not";
        //System.out.println("Test case has validated the functionality for calculate the post rate of the to-USA oversize mail letter");
    }
    @Test
    //17 test whether the USA letter mail is standard or not: oversize means the dimension is larger than 245*156*5 or larger than 50g
    public void TestStandardMailLetterInternational(){
        letterMail.setDestination("international");
        letterMail.setWidth(240);
        letterMail.setDepth(100);
        letterMail.setHeight(2);
        letterMail.setWeight(45);
        PostRateCalculator pr = new PostRateCalculator(letterMail.getWidth(), letterMail.getDepth(), letterMail.getHeight(),letterMail.getWeight());
        double calculatedRate = pr.calculatePostRateFromDest(letterMail.getDestination());
        assert calculatedRate == 3.60:"test is failed or unavailable to check whether the international mail letter is standard";
        System.out.println("Test case has validated the functionality for calculate the post rate of the international standard mail letter");
    }
    @Test
    //18 test whether the letter mail is oversize: oversize means the dimension is larger than 245*156*5 or larger than 50g
    public void TestOversizeMailLetterInternational(){
        letterMail.setDestination("international");
        letterMail.setWidth(300);
        letterMail.setDepth(200);
        letterMail.setHeight(15);
        letterMail.setWeight(490);
        PostRateCalculator pr = new PostRateCalculator(letterMail.getWidth(), letterMail.getDepth(), letterMail.getHeight(),letterMail.getWeight());
        double calculatedRate = pr.calculatePostRateFromDest(letterMail.getDestination());
        assert calculatedRate == 20.60:"test is failed or unavailable to check whether international mail letter is oversize or not";
        System.out.println("Test case has validated the functionality for calculate the post rate of the international oversize mail letter");
    }
}