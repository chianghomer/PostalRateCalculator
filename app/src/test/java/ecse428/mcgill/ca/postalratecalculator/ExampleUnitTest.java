package ecse428.mcgill.ca.postalratecalculator;

import org.junit.Test;

import models.LetterMail;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    public LetterMail mail= new LetterMail(10,10,15,15, "international");
    @Test
    public void TestSetandGetDepth(){
        //mail = new LetterMail(10,10,15,15, "international");
        assert((mail.getWidth() == 10) && (mail.getDepth() == 10) && (mail.getWeight() == 15) && (mail.getHeight() == 15));
    }
    @Test
    public void TestDestination(){
        assertEquals("international",mail.getDestination());
    }
}