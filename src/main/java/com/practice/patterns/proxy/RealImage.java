package com.practice.patterns.proxy;

/**
 * Created by shankark on 26/9/16.
 */
public class RealImage implements Image {
    String fileName;
    RealImage(String fileName) {
        this.fileName = fileName;
    }

    public void loadAndDisplay(String fileName) {
        System.out.println(" Displaying file : " + fileName);
    }

    /**
     * For checing permissions and enable access
     */
    @Override
    public void checkPermissionsAndDisplay() {

    }
}
