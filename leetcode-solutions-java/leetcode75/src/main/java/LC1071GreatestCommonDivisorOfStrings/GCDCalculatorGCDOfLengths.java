package LC1071GreatestCommonDivisorOfStrings;

/**
 * Assumptions:
 * <ul>
 *   <li>All pairs of strings with non-empty common divisors are equal concatenated either way</li>
 * </ul>
 * <p>
 * Sub-Problems:
 * <ul>
 *     <li>Are the strings equal when concatenated?</li>
 *     <li>What is the GCD of the lengths of the two strings?</li>
 * </ul>
 */
public class GCDCalculatorGCDOfLengths implements GreatestCommonDivisorCalculator {

    @Override
    public String gcdOfStrings(String str1, String str2) {
        // Guard: Edge case for empty strings
        if (str1.isEmpty() || str2.isEmpty()) {
            return "";
        }
        if (haveEqualConcatenations(str1, str2)) {
            return getLongestCommonSubstring(str1, str2);
        }
        return "";
    }

    private String getLongestCommonSubstring(String str1, String str2) {
        return str1.substring(0, gcdOfLengths(str1.length(), str2.length()));
    }

    /*
        Recursive function to determine the GCD of two numbers.
        This will be the length of the GCD substring.
        Assumption: Empty string edge cases are handled BEFORE here...
        Division:
            dividend / divisor = quotient
            dividend % divisor = remainder
     */
    private int gcdOfLengths(int dividend, int divisor) {
        // Guard
        if (divisor == 0) {
            return dividend;
        }
        /*
            Recurse:
                - Shift the divisor left (up, normally) to be the new dividend
                - Replace the previous divisor with the remainder of the division
         */
        return gcdOfLengths(divisor, dividend % divisor);
    }

    /*
        Are the two strings equal when concatenated each way?
     */
    private boolean haveEqualConcatenations(String str1, String str2) {
        return (str1 + str2).equals(str2 + str1);
    }
}
