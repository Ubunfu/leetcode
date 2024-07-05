package LC1071GreatestCommonDivisorOfStrings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreatestCommonDivisorCalculatorTest {

    private final GreatestCommonDivisorCalculator greatestCommonDivisorCalculator = new GreatestCommonDivisorCalculator();

    @Test
    void given_stringTwoWhollyDividesStringOne_expect_returnsStringTwo() {
        final String result = greatestCommonDivisorCalculator.gcdOfStrings("ABCABC", "ABC");

        assertThat(result).isEqualTo("ABC");
    }

    @Test
    void given_substringOfBothStringsDividesEach_expect_returnsSubstrings() {
        final String result = greatestCommonDivisorCalculator.gcdOfStrings("ABABAB", "ABAB");

        assertThat(result).isEqualTo("AB");
    }

    @Test
    void given_noCommonDivisor_expect_returnsEmptyString() {
        final String result = greatestCommonDivisorCalculator.gcdOfStrings("CHOCOLATE", "RAIN");

        assertThat(result).isEmpty();
    }

    @Test
    void given_bothStringsMatch_expect_returnsTheEquivalentString() {
        final String result = greatestCommonDivisorCalculator.gcdOfStrings("RAIN", "RAIN");

        assertThat(result).isEqualTo("RAIN");
    }

    @Test
    void given_firstStringEmpty_expect_returnsEmptyString() {
        final String result = greatestCommonDivisorCalculator.gcdOfStrings("", "PURPLE");

        assertThat(result).isEmpty();
    }

    @Test
    void given_secondStringEmpty_expect_returnsEmptyString() {
        final String result = greatestCommonDivisorCalculator.gcdOfStrings("PURPLE", "");

        assertThat(result).isEmpty();
    }

    @Test
    void given_bothStringsEmpty_expect_returnsEmptyString() {
        final String result = greatestCommonDivisorCalculator.gcdOfStrings("", "");

        assertThat(result).isEmpty();
    }
}
