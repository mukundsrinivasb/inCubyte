import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    //Pass a string with length two
    void addTwoNumber() {
        StringCalculator stringCalc = new StringCalculator();
        assertEquals(1, stringCalc.add("1,0"));
        assertEquals(10, stringCalc.add("4,6"));
        assertEquals(6, stringCalc.add("3,3"));
        assertEquals(12, stringCalc.add("8,4"));

    }
    //Pass and empty string and a string with length one
    @Test
    void addNoneOne() {
        StringCalculator stringCalc = new StringCalculator();
        assertEquals(0, stringCalc.add(""));
        assertEquals(0, stringCalc.add("0"));
        assertEquals(7, stringCalc.add("7"));
        assertEquals(1, stringCalc.add("1"));
    }

    @Test
    //Pass many inputs
    void addMany() {
        StringCalculator stringCalc = new StringCalculator();
        assertEquals(55, stringCalc.add("1\n2,3,4,5,6,7,8,9,1,9"));
        assertEquals(23, stringCalc.add("1,5,6,7,4"));
        assertEquals(25, stringCalc.add("1,5,5,8,1,5"));
        assertEquals(55, stringCalc.add("9,9,9,9,9,1,9"));


    }

    @Test
    //Test with delimiters
    void funnyDelimiters() {
        StringCalculator stringCalc = new StringCalculator();
        assertEquals(55, stringCalc.add("//;\n1;//;\n2;//;\n3;4,5,6,7,8,9,1,9"));
        assertEquals(0, stringCalc.add("\\;"));
        assertEquals(8, stringCalc.add("\\;8"));
        assertEquals(1, stringCalc.add("1;\\;"));
    }

    @Test()
    //Test with negatives
    void testSingleNegativeInput() {
        StringCalculator stringCalc = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> stringCalc.add("-7"),"negatives not allowed -7");
        assertThrows(IllegalArgumentException.class, () -> stringCalc.add("\\;-8"),"negatives not allowed -8");
        assertThrows(IllegalArgumentException.class, () -> stringCalc.add("//;\n-1;//;\n2;//;\n3;4,5,6,\n7,8,9,1,9"),"negatives not allowed -1");

    }
    @Test
    //Test with more than one negatives and delimiters
    void testManyNegativeInputs(){
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class,()->stringCalculator.add("-1,-5,-6,-7,-4"),"negatives not allowed -1,-5,-6,-7,-4");
        assertThrows(IllegalArgumentException.class,()->stringCalculator.add("//;1;2;8;-1;\n-5;-6;-7;-4"),"negatives not allowed -1,-5,-6,-7,-4");

    }


}