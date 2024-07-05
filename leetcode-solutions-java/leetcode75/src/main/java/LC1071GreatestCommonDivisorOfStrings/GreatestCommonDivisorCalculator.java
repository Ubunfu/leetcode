package LC1071GreatestCommonDivisorOfStrings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GreatestCommonDivisorCalculator {
    /**
     * Assumptions:
     * - These strings can be long
     * - They could share quite a few substrings
     * - Not all common substrings will be divisors
     * -
     * <p>
     * Sub-Problems:
     * 1. What are the divisors of each string?
     * 2. Which divisors are common to both strings?
     * 3. Which of the common divisors is longest?
     * <p>
     * Approach:
     * - Scan through each string one char at a time until a char doesn't match
     * - Filter for the substrings that are divisors of each string
     * - Return the longest of the divisors
     */
    public String gcdOfStrings(String str1, String str2) {
        /*
            These two guards trade a tiny bit of efficiency to solve easy problems instantly.
         */
        if (str1.isEmpty() || str2.isEmpty()) {
            return "";
        }
        if (str1.equals(str2)) {
            return str1;
        }

        /*
            Find the list of divisors for each string
         */
        Set<String> str1Divisors = getDivisorsOfString(str1);
        Set<String> str2Divisors = getDivisorsOfString(str2);

        /*
            Find common divisors
         */
        Set<String> sharedDivisors = str1Divisors.stream()
                .filter(str2Divisors::contains)
                .collect(Collectors.toSet());

        /*
            Find the longest of the common divisors
         */
        return sharedDivisors.stream()
                .max((o1, o2) -> {
                    if (o1.length() == o2.length()) {
                        return 0;
                    }
                    return o1.length() > o2.length() ? 1 : -1;
                })
                .orElse("");
    }

    private Set<String> getDivisorsOfString(String input) {
        Set<String> divisors = new HashSet<>();
        for (int i = 0; i <= input.length(); i++) {
            String potentialDivisor = input.substring(0, i);
            if (isDivisor(input, potentialDivisor)) {
                divisors.add(potentialDivisor);
            }
        }
        return divisors;
    }

    /*
        Determine if a string is a divisor of another string.

        Approach:
        - A divisor must equal the target string when replicated N number of times, where N
        is the quotient of the target string length and divisor string length.
        - Calculate these values, and replicate the potential divisor
        - Test equality
     */
    private boolean isDivisor(String input, String potentialDivisor) {
        /*
            Guard: Empty string is not a divisor
         */
        if (potentialDivisor.isEmpty()) {
            return false;
        }

        /*
            Guard: The length of a divisor must evenly divide the length of the string it divides.
         */
        if (input.length() % potentialDivisor.length() != 0) {
            return false;
        }

        int divisorLengthDividend = input.length() / potentialDivisor.length();

        String testString = replicateString(potentialDivisor, divisorLengthDividend);

        return testString.equals(input);
    }

    private String replicateString(String replicant, int replicantCount) {
        StringBuilder clone = new StringBuilder();
        while (replicantCount > 0) {
            clone.append(replicant);
            replicantCount--;
        }
        return clone.toString();
    }

}
