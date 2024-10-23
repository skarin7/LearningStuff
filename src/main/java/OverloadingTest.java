import java.util.*;

/**
 * Created by shankark on 4/1/17.
 */
public class OverloadingTest {

    private boolean isPersonaExistsInKeyPattern(String keyPattern, Set<String> siteVariants) {
        return siteVariants.stream().anyMatch(keyPattern::contains);
    }
    private Map<String, String> personaNamesContainsSubstringOfAnother(List<String>  siteVariants) {
        Map<String, String> result = new HashMap<>(); // Sort the array by length
        siteVariants.sort(Comparator.comparingInt(String::length));
        // Use a HashSet to track seen strings
        Set<String> seen = new HashSet<>(); // Iterate over the sorted array
        for (String st : siteVariants) {
            for (String existing : seen) {
                if (st.contains(existing)) {
                    result.put(existing, st);
                }
            }
            seen.add(st);
        }
        //"canada", "360", "canada360", "360canada", "hello", "helloworld"
        System.out.println(" small persona vs big persona names map" + result);
        return result;
    }

    private Set<String> extractPersonasFromPattern(String keyPattern, Set<String> siteVariants) {
        Set<String> matchedVariants = new HashSet<>();
        Map<String, String> variantsMap = personaNamesContainsSubstringOfAnother(new ArrayList<>(siteVariants));
        if(!variantsMap.isEmpty() && keyPatternContainsSubStringPersonas(keyPattern, variantsMap)) {
            // determining correct persona
            variantsMap.forEach((p1, p2) -> {
                if(keyPattern.contains(p2)) {
                    matchedVariants.add(p2);
                } else if(keyPattern.contains(p1)) {
                    matchedVariants.add(p1);
                }
            });
        } else {
            for (String variant : siteVariants) {
                if (keyPattern.contains(variant)) {
                    matchedVariants.add(variant);
                    System.out.println("Variants matching the pattern, when persona names are not substrings, : " +
                            " and variantsMap empty, for key: {} are : " + matchedVariants);
                    return matchedVariants;
                }
            }

        }
        System.out.println("Variants matching the pattern, when persona names are #substrings#,  for key: {} are : {}");
        return matchedVariants;
    }

    /**
     * if pattern contain non-substring personas, no need of determining the persona, you can directly return the matching
     * name from persona list
     * @param keyPattern
     * @param variantsMap
     * @return
     */
    private boolean keyPatternContainsSubStringPersonas(String keyPattern, Map<String, String> variantsMap) {
        return variantsMap.keySet().stream().anyMatch(keyPattern::contains);
    }

    public static void main(String[] args) {
        Set<String> siteVariants = new HashSet<>(Arrays.asList("canada", "360", "canada360", "360canada", "hello", "helloworld"));
        String pattern = "ph:page:DEMOUS:*hello*";
        OverloadingTest test = new OverloadingTest();
        boolean personaExistsInKeyPattern = test.isPersonaExistsInKeyPattern(pattern, siteVariants);
        System.out.println("personaExistsInKeyPattern : " + personaExistsInKeyPattern);
        if(personaExistsInKeyPattern) {
            Set<String> strings = test.extractPersonasFromPattern(pattern, siteVariants);
            System.out.println(" Extracted pattern" + strings);
        }

    }
}
