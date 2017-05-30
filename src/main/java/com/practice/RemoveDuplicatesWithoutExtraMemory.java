package com.practice;

/**
 * Created by shankark on 30/1/17.
 */
public class RemoveDuplicatesWithoutExtraMemory {

    void removeDuplicateWithExtraArray(String input) {
        char[] array = input.toCharArray();

        int[] founds = new int[256];
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < array.length; i++) {
                founds[(int) array[i]]++;
        }

        for (int i = 0; i < founds.length; i++) {
            if(founds[i] > 0) {
                sb.append((char)i);
            }
        }

        System.out.println(sb.toString());

    }
    void removeWithout(String input) {
        String cleanedString = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(!cleanedString.contains("" + c)) {
                cleanedString+= c;
            }
        }

        System.out.println(cleanedString);
    }

    public static void main(String[] args) {
        String input = "abcdwaaaddddaaaaqqqq";
        RemoveDuplicatesWithoutExtraMemory remove = new RemoveDuplicatesWithoutExtraMemory();
//        remove.removeDuplicateWithExtraArray(input);
        remove.removeWithout(input);
    }
}
