package com.practice;

import java.util.Arrays;

/**
 * Created by shankark on 27/10/16.
 */
public class MainMethodTest {
    public static void main(String[] args) {
        String[] vals = {"One", "Two"};
        main(vals, "yes");
    }

    public static void main(String[] args, String overidden) {
        System.out.println("values are: " + Arrays.toString(args) + " overiiden" + overidden);
    }
}
