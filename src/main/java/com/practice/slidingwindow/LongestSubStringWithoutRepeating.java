package com.practice.slidingwindow;

import java.util.HashMap;

public class LongestSubStringWithoutRepeating {
        public static int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            HashMap<Character, Integer> charIndexMap = new HashMap<>();
            int maxLength = 0;
            int left = 0;  // Left pointer of the window

            for (int right = 0; right < s.length(); right++) {
                char currentChar = s.charAt(right);

                // If the current character is already in the map, move the left pointer
                if (charIndexMap.containsKey(currentChar)) {
                    left = Math.max(charIndexMap.get(currentChar) + 1, left);
                }

                // Update the last seen index of the current character
                charIndexMap.put(currentChar, right);

                // Calculate the length of the current window
                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }

        public static void main(String[] args) {
            String input = "aaaaaaa";
            System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(input));
        }

}
