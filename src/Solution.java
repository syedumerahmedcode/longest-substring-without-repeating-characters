import java.util.HashSet;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        /**
         * Checking for edge cases
         */
        if (s.length() <= 1) {
            return s.length();
        }
        /**
         * initializing variables
         */
        int left = 0, right = 0, answer = 0;
        /**
         * A hashset which contains the characters vsisited
         */
        HashSet<Character> visiedSet = new HashSet<>();
        /**
         * Keep looping through till we reach the end of the string
         */
        while (right < s.length()) {
            /**
             * Initialize a char variable
             */
            char c = s.charAt(right);
            /**
             * Check if the character exists inside our visitedSet
             * 
             * The reason we do it in a while lopp as opposed to an if statement is because
             * we keep moving the left pointer till we have distinct charcaters in
             * visitedSet only.
             */
            while (visiedSet.contains(c)) {
                /**
                 * We remove the value from our visitedSet and we will also update the left
                 * pointer
                 */
                visiedSet.remove(s.charAt(left));
                left++;
            }
            /**
             * Add the current character to the visitedSet as it is currently not present in
             * the set.
             */
            visiedSet.add(c);
            /**
             * Check if the ans is greater than whatever answer we had before.
             * Why [right-left +1]? Because indexes are ZERO based and numbers are 1 based.
             * To offset the index location to number, we add 1.
             */
            answer = Math.max(answer, right - left + 1);
            /**
             * Update right pointer
             */
            right++;
        }
        return answer;
    }

}
