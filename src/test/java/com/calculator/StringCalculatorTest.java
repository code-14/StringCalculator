package com.calculator;



import org.testng.Assert;
import org.testng.annotations.Test;

public class StringCalculatorTest {
   

   //For an empty string the method will return 0
    @Test
    public final void testVerifyCodeAcceptsZeroNumbers() {
        int addition = StringCalculator.add("");
        Assert.assertEquals((addition == 0), "The value is not equal to 0");
      
    }
   //For an single number in the string  the method will return the number
    @Test
    public final void testVerifyCodeAcceptsOneNumber_1() {
      int addition = StringCalculator.add("1,");
      Assert.assertEquals((addition == 1), "The value is not equal to 1");
    }
    //For an single number in the string  the method will return the number
    @Test
    public final void testVerifyCodeAcceptsOneNumber_2() {
      int addition =  StringCalculator.add(",1");
      Assert.assertEquals((addition == 1), "The value is not equal to 1");
    }
    //For an single number in the string  the method will return the number
    @Test
    public final void testVerifyCodeAcceptsOneNumber_3() {
      int addition = StringCalculator.add("1");
      Assert.assertEquals((addition == 1), "The value is not equal to 1");
    }
    //For two numbers in the string the method will return sum of the two numbers
    @Test
    public final void testVerifyCodeAcceptsTwoNumbers_1() {
      int addition = StringCalculator.add("1,2");
      Assert.assertEquals((addition == 3), "The value is not equal to 3");
    }
     //For two numbers in the string the method will return sum of the two numbers
    @Test
    public final void testVerifyCodeAcceptsTwoNumbers_2() {
      int addition = StringCalculator.add("1,2, ");
      Assert.assertEquals((addition == 3), "The value is not equal to 3");
    }
    //For more than two numbers in the string the method will return sum of the numbers
    @Test
    public final void testVerifyCodeAMoreThanTwoNumbers() {
      int addition = StringCalculator.add("1,2,3,4,5,");
      Assert.assertEquals((addition == 15), "The value is not equal to 15");
    }
    

//handle new lines between numbers in the string
@Test
public final void testVerifyCodeForNewLineBetweenNumbers() {
    int addition = StringCalculator.add("1,2,3n4n5");
    Assert.assertEquals((addition == 15), "The value is not equal to 15");
}

//support different delimiters
@Test
public final void testVerifyCodeForExistingDelimiterInStringIsUsed() {
    int addition = StringCalculator.add("//;n1;2;3");
    Assert.assertEquals((addition == 6), "The value is not equal to 6");
}

//throws exception for negative number
@Test
public final void testVerifyCodeIfNegativeNumberExistInString_1() {
    RuntimeException exception = null;
    try {
        StringCalculator.add("1,-2,3");
    } catch (RuntimeException e) {
        exception = e;
    }
    Assert.assertNotNull(exception);
    Assert.assertEquals("Negatives not allowed: [-2]", exception.getMessage());
}
//throws exception for negative number having delimiter specified
@Test
public final void testVerifyCodeIfNegativeNumberExistInString_2() {
    RuntimeException exception = null;
    try {
        StringCalculator.add("//;n1;-2;3;4");
    } catch (RuntimeException e) {
        exception = e;
    }
    Assert.assertNotNull(exception);
    Assert.assertEquals("Negatives not allowed: [-2]", exception.getMessage());
}
//throws exception for negative numbers having delimiter specified
@Test
public final void testVerifyCodeIfNegativeNumberExistInString_3() {
    RuntimeException exception = null;
    try {
        StringCalculator.add("//;n1;-2;3;4;-5");
    } catch (RuntimeException e) {
        exception = e;
    }
    Assert.assertNotNull(exception);
    Assert.assertEquals("Negatives not allowed: [-2,-5]", exception.getMessage());
}

//bigger than 1000 number should be ignored without dilimiter
@Test
public final void testVerifyNumbersGreaterThan1000NotIncludedInAddition_1() {

    int addition = StringCalculator.add("1,1000,1001,2");
    Assert.assertEquals((addition == 1003), "The value is not equal to 1003");
}

//bigger than 1000 number should be ignored with dilimiter
@Test
public final void testVerifyNumbersGreaterThan1000NotIncludedInAddition_2() {

    int addition = StringCalculator.add("//;n1;1000;1001;2;");
    Assert.assertEquals((addition == 1003), "The value is not equal to 1003");
}

//delimiters can be of any length
@Test
public final void testVerifyDElimitersOfAnyLengthInString() {

    int addition = StringCalculator.add("//;n1;;;1000;;1001;2;");
    Assert.assertEquals((addition == 1003), "The value is not equal to 1003");
}




























}


