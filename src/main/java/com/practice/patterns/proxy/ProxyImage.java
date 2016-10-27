package com.practice.patterns.proxy;

/**
 * Created by shankark on 26/9/16.
 */
public class ProxyImage  implements Image{

    RealImage realImage;

    String username;
    String fileName;
    public ProxyImage(String username, String fileName) {
        this.username = username;
        this.fileName = fileName;
    }


    public void loadAndDisplay(String fileNanme) {

        if (null == realImage) {
            realImage = new RealImage(fileNanme);
            System.out.println(" Loaded image from Disk");
        }
        realImage.loadAndDisplay(fileNanme);
    }

    @Override
    public void checkPermissionsAndDisplay() {
            if(username.equalsIgnoreCase("admin")) {
                loadAndDisplay(fileName);
            } else {
                System.out.println(" You don't have permissions. Only admins has");
            }
    }
}
