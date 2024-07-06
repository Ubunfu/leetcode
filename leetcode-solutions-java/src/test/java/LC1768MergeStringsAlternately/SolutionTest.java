package LC1768MergeStringsAlternately;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void testBothWordsSameLength() {
        String result = solution.mergeAlternately("abcd", "wxyz");

        assertThat(result).isEqualTo("awbxcydz");
    }

    @Test
    void testFirstWordLonger() {
        String result = solution.mergeAlternately("chocolate", "rain");

        assertThat(result).isEqualTo("crhaoicnolate");
    }

    @Test
    void testSecondWordLonger() {
        String result = solution.mergeAlternately("rain", "chocolate");

        assertThat(result).isEqualTo("rcahioncolate");
    }

    @Test
    void testFirstWordEmpty() {
        String result = solution.mergeAlternately("", "purple");

        assertThat(result).isEqualTo("purple");
    }

    @Test
    void testSecondWordEmpty() {
        String result = solution.mergeAlternately("purple", "");

        assertThat(result).isEqualTo("purple");
    }

    @Test
    void testBothWordsEmpty() {
        String result = solution.mergeAlternately("", "");

        assertThat(result).isEqualTo("");
    }

}