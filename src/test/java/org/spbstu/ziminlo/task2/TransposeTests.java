package org.spbstu.ziminlo.task2;

import org.junit.jupiter.api.Test;
import org.spbstu.ziminlo.task2.Transpose;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransposeTests {
    @Test
    public void TransposeTest() {
        List<String> test = new ArrayList<>();
        test.add("A D");
        test.add("B E");
        test.add("C");
        Transpose transpose = new Transpose(test, false, 0, false, false);
        transpose.transpose();

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("A B C");
        expectedResult.add("D E");

        assertEquals(expectedResult, transpose.getTranspose());
    }
    @Test
    public void fixedTransposeTest() {
        List<String> test = new ArrayList<>();
        test.add("Some Text");
        test.add("aaa bb");
        test.add("cccc");
        Transpose transpose = new Transpose(test, true, 4, false, false);
        transpose.transpose();

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Some aaa  cccc");
        expectedResult.add("Text bb  ");

        assertEquals(expectedResult, transpose.getTranspose());
    }

    @Test
    public void fixedTransposeTestTrim() {
        List<String> test = new ArrayList<>();
        test.add("loooooong time ago");
        test.add("ng word");

        Transpose transpose = new Transpose(test, true, 4, true, false);
        transpose.transpose();

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("looo ng  ");
        expectedResult.add("time word");
        expectedResult.add("ago ");

        assertEquals(expectedResult, transpose.getTranspose());
    }

    @Test
    public void fixedTransposeTestTrimRight() {
        List<String> test = new ArrayList<>();
        test.add("loooooong time ago");
        test.add("ng word");

        Transpose transpose = new Transpose(test, true, 4, true, true);
        transpose.transpose();

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("looo   ng");
        expectedResult.add("time word");
        expectedResult.add(" ago");

        assertEquals(expectedResult, transpose.getTranspose());
    }

    @Test
    public void transposeTestTrimWithoutA() {
        List<String> test = new ArrayList<>();
        test.add("0123456789 0123456789TenEleven someText");
        test.add("short words");

        Transpose transpose = new Transpose(test, false, 0, true, false);
        transpose.transpose();

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("0123456789 short     ");
        expectedResult.add("0123456789 words     ");
        expectedResult.add("someText  ");

        assertEquals(expectedResult, transpose.getTranspose());
    }
}
