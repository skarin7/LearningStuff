import java.net.URI;

public class ServerContextIssue {
    public static void main(String[] args) {
        String pageKey = "s3";
        String viewKey = "s3";

        if(pageKey.contains(viewKey)) {
            System.out.println("Page key contains view key");
        } else {
            System.out.println("Page key does not contain view key");

        }

    }
}
