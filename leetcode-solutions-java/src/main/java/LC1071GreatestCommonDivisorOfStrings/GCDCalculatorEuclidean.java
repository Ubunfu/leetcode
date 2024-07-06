package LC1071GreatestCommonDivisorOfStrings;

/**
 * Assumptions:
 * <ul>
 *   <li>All pairs of strings with non-empty common divisors are equal concatenated either way</li>
 *   <li>The Euclidean Algorithm can be used to find the GCD of two numbers</li>
 * </ul>
 * <p>
 * Sub-Problems:
 * <ul>
 *     <li>Are the strings equal when concatenated?</li>
 *     <li>What is the GCD of the lengths of the two strings? (Euclidean Algorithm)</li>
 *     <li>What is the substring of the above length?</li>
 * </ul>
 */
public class GCDCalculatorEuclidean implements GreatestCommonDivisorCalculator {

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
        return str1.substring(0, getEuclideanGCD(str1.length(), str2.length()));
    }

    /**
     * Recursive function to determine the GCD of two numbers using the Euclidean Algorithm.  This will be the length
     * of the GCD substring.  <a href="https://www.youtube.com/watch?v=JUzYl1TYMcU">See this video.</a>
     * <p>
     * Assumption:
     * Empty string edge cases are handled BEFORE here...
     * <p>
     * Division:
     * <ul>
     *     <li>dividend / divisor = quotient</li>
     *     <li>dividend % divisor = remainder</li>
     * </ul>
     */
    private int getEuclideanGCD(int dividend, int divisor) {
        // Guard
        if (divisor == 0) {
            return dividend;
        }
        /*
            Recurse:
                - Shift the divisor left (up, normally) to be the new dividend
                - Replace the previous divisor with the remainder of the division
         */
        return getEuclideanGCD(divisor, dividend % divisor);
    }

    /*
        Are the two strings equal when concatenated each way?
     */
    private boolean haveEqualConcatenations(String str1, String str2) {
        return (str1 + str2).equals(str2 + str1);
    }
}
