package ecse428.mcgill.ca.postalratecalculator;

import org.junit.Before;
import org.junit.Test;

import models.LetterMail;

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

    @Test
    public void TestSetDestinationNormal(){
        letterMail.setDestination("Canada");

        assertEquals("Canada", letterMail.getDestination());
    }

    @Test
    public void TestSetDestinationEmpty(){
        letterMail.setDestination("");

        assertEquals("",letterMail.getDestination());
    }

}