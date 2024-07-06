package LC1768MergeStringsAlternately;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        /*
            Questions:
            - Do we assume we start with the first word?
         */
        StringBuilder result = new StringBuilder();

        return getNextCharacter(word1, word2, result).toString();
    }

    private StringBuilder getNextCharacter(String firstWord, String secondWord, StringBuilder result) {
        /*
            Guard clauses to stop recursion
            If either word is empty, append all remaining chars in the other word to the result and return
         */
        if (firstWord.isEmpty()) {
            result.append(secondWord);
            return result;
        }
        if (secondWord.isEmpty()) {
            result.append(firstWord);
            return result;
        }

        /*
            Otherwise, take a bite out of each word, and recurse
         */
        result.append(firstWord.charAt(0));
        result.append(secondWord.charAt(0));

        return getNextCharacter(firstWord.substring(1), secondWord.substring(1), result);
    }
}