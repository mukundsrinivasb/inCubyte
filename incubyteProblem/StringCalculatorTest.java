package comp1110.homework.LoL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    void addTwoNumber() {
        StringCalculator stringCalc = new StringCalculator();
        assertEquals(1, stringCalc.add("1,0"));
        assertEquals(10, stringCalc.add("4,6"));
        assertEquals(6, stringCalc.add("3,3"));
        assertEquals(12, stringCalc.add("8,4"));

    }

    @Test
    void addNoneOne() {
        StringCalculator stringCalc = new StringCalculator();
        assertEquals(0, stringCalc.add(""));
        assertEquals(0, stringCalc.add("0"));
        assertEquals(7, stringCalc.add("7"));
        assertEquals(1, stringCalc.add("1"));
    }

    @Test
    void addMany() {
        StringCalculator stringCalc = new StringCalculator();
        assertEquals(55, stringCalc.add("1\n2,3,4,5,6,7,8,9,1,9"));
        assertEquals(23, stringCalc.add("1,5,6,7,4"));
        assertEquals(25, stringCalc.add("1,5,5,8,1,5"));
        assertEquals(55, stringCalc.add("9,9,9,9,9,1,9"));


    }

    @Test
    void funnyDelimiters() {
        StringCalculator stringCalc = new StringCalculator();
        assertEquals(55, stringCalc.add("//;\n1;//;\n2;//;\n3;4,5,6,7,8,9,1,9"));
        assertEquals(0, stringCalc.add("\\;"));
        assertEquals(8, stringCalc.add("\\;8"));
        assertEquals(1, stringCalc.add("1;\\;"));
    }

    @Test()
    void tegativeInputTest() {
        StringCalculator stringCalc = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> stringCalc.add("-7"));
        assertThrows(IllegalArgumentException.class, () -> stringCalc.add("\\;-8"));

    }

    @Test
    void expectNegatives() {

    }
}