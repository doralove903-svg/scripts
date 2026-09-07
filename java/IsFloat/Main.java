import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static boolean isFloat(String s) {
        var status = 0;

        var it = new StringCharacterIterator(s);
        while (true) {
            // ここを埋めてください
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
