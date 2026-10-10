package Phase3.homework;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;

public class Homework1 {
    public static boolean isFloat(String s) {
        var statusTable = new int[][] {
            { 1,  2,  3, -2, -2, -2},
            {-2,  2,  3, -2, -2, -2},
            {-2,  2,  4,  5, -1, -2},
            {-2,  4, -2, -2, -2, -2},
            {-2,  4, -2,  5, -1, -2},
            { 6,  7, -2, -2, -2, -2},
            {-2,  7, -2, -2, -2, -2},
            {-2,  7, -2, -2, -1, -2}
        };

        var it = new StringCharacterIterator(s);

        var status = 0;
        var event = charKind(it.current());
        status = statusTable[status][event];
        while (status >= 0) {
            it.next();
            event = charKind(it.current());
            status = statusTable[status][event];
        }

        return status == -1;
    }

    public static int charKind(char c) {
        if (c == '+' || c == '-') {
            return 0;
        } else if ('0' <= c && c <= '9') {
        	return 1;
        } else if (c == '.') {
        	return 2;
        } else if (c == 'e' || c == 'E') {
        	return 3;
        } else if (c == CharacterIterator.DONE) {
        	return 4;
        } else {
        	return 5;
        }
    }
   
    public static void main(String[] args) {
        var testData = new ArrayList<TestData>(Arrays.asList(
                new TestData(false, ""),
                new TestData(false, "+"),
                new TestData(false, "-"),
                new TestData(false, "."),
                new TestData(false, "+."),
                new TestData(false, "+1+"),
                new TestData(true, "+1"),
                new TestData(true, "-1"),
                new TestData(true, "1"),
                new TestData(true, "+1."),
                new TestData(true, "-1."),
                new TestData(true, "1."),
                new TestData(true, "+.1"),
                new TestData(true, "-.1"),
                new TestData(true, ".1"),
                new TestData(false, ".1+"),
                new TestData(true, "+1.1"),
                new TestData(true, "-1.1"),
                new TestData(true, "1.1"),
                new TestData(false, "+1.1+"),
                new TestData(false, "+1.1E"),
                new TestData(false, "+1.1E+"),
                new TestData(false, "+1.1E-"),
                new TestData(false, "+1.1E."),
                new TestData(true, "+1.1E1"),
                new TestData(true, "+1E+1"),
                new TestData(true, "+1E-1"),
                new TestData(false, "+1E-1+"),
                new TestData(true, "+.1E+1"),
                new TestData(true, "+.1E-1"),
                new TestData(true, "+1.1E+1"),
                new TestData(true, "+1.1E-1"),
                new TestData(false, "+1.1E.1"),
                new TestData(false, "+1.1E1."),
                new TestData(true, "+1.1e+1"),
                new TestData(true, "+1234567890.1234567890E+1234567890")));

        for (var t : testData) {
            System.out.printf("%s \"%s\"は浮動小数点数で%s。\n",
                isFloat(t.data()) == t.expected() ? "OK" : "NG",
                t.data(),
                t.expected() ? "ある" : "はない");
        }
    }
}

class TestData {
    private boolean expected;
    private String data; 
    TestData(boolean expected, String data) {
        this.expected = expected;
        this.data = data;
    }
    boolean expected() {
        return expected;
    }
    String data() {
        return data;
    }
}