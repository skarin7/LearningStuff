import java.net.URI;

public class ServerContextIssue {
    public static void main(String[] args) {
/*        String test = "http://showtell2-siteqa1.phenompro.com/";
        String newDomain = "showtell2-final-siteqa1.phenompro.com";
   *//*     String onlyDomain = test.substring(test.indexOf("://") + 3);
        onlyDomain = onlyDomain.contains("/") ? onlyDomain.substring(0, onlyDomain.indexOf("/")) : onlyDomain;
        System.out.println(onlyDomain);*//*
        try {
            URI url = new URI(test);
            System.out.println("host:" + url.getHost() + ", scheme: " + url.getScheme() + ", path: " + url.getPath());
            System.out.println("New name >> " + url.getScheme() +"://" + newDomain + url.getPath());
        }catch (Exception ex) {
            ex.printStackTrace();
        }*/

        String pageKey = "s3";
        String viewKey = "s3";

        if(pageKey.contains(viewKey)) {
            System.out.println("Page key contains view key");
        } else {
            System.out.println("Page key does not contain view key");

        }

    }
}
