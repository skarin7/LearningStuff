import java.util.Arrays;
import java.util.List;

/**
 * Created by shankark on 20/1/17.
 */
public class WordBreak {

    final List<String > dictionary = Arrays.asList(new String[] {"I", "am", "legend", "an","engineer", "Ia"});

    boolean checkWordMatch(String str) {
        int size = str.length();
        if(size == 0) {
            return true;
        }

        for (int i = 1; i <= size; i++) {
            System.out.println(" Trying :...." + str.substring(0, i) + " Need to try .." + str.substring(i, size));
            if(dictionary.contains(str.substring(0, i)) && checkWordMatch(str.substring(i, size))) {
                return true;
            }

        }

    return false;
    }

    public static void main(String[] args) {
        WordBreak test = new WordBreak();
        System.out.println(" Result: "+ test.checkWordMatch("Iamanengineer"));

        String samp = "nrjkwkrwlrk";
//        System.out.println(samp.substring(1));

    }

}
