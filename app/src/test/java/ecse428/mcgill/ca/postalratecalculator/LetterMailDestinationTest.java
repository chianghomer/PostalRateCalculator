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
        System.out.println("Initialize Letter Mail");
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
    /*
    @Test
    public void TestWidthMeetMin(){
        letterMail.setDestination("canada");
        letterMail.setWidth(110);
        PostRateCalculator pc = new PostRateCalculator();
        double calculatedRate = pc.calculatePostRateFromDest(letterMail.getDestination());
        if(calculatedRate == -1.0){
            assertEquals("The width does not meet the minimum requirement", );
        }
        assertEquals("The width does not meet the minimum requirement", );
    }
    */
}