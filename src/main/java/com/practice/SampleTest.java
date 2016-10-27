package com.practice;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SampleTest {
    public static void main(String[] args) {
/*        StringBuffer sb = new StringBuffer("test");
        StringBuffer sb2 = new StringBuffer("test");
        Set<StringBuffer> sets = new HashSet<StringBuffer>();
        sets.add(sb);
        sets.add(sb2);
        System.out.println(sets);
        System.out.println(sb.indexOf("e"));*/
        Map<String,String> values = new HashMap<>();
        values.put("One", "1");
        values.put("two", "2");
        System.out.println(values);
        Map<String,String> test = null;
        test = values;
        System.out.println(test);

        Map<Long, String> map1 = new HashMap<>();
        map1.put(new Long(1), "P1");
        map1.put(null, "null");
        map1.put(new Long(2), "P2");
        map1.put(new Long(3), "P3");
        Map<Long, String> map2 = new HashMap<>();
        map2.put(new Long(4), "P24");
        map2.put(new Long(3), "P3");
        map1.compute(new Long(1), (k, v) -> v == null ? "new P1" : "P1 modified");
        map1.forEach((k, v) -> alterMap(k, v));

        Function<Map<Long, String>, Map<Long, String>> finalMap = new Function<Map<Long, String>, Map<Long, String>>() {

            @Override
            public Map<Long, String> apply(Map<Long, String> t) {
                // TODO Auto-generated method stub
                return null;
            }

        };
        System.out.println(map1);

        BigDecimal number = BigDecimal.valueOf(2);
        System.out.println((new DecimalFormat("#0").format(number)));
    }

    private static void alterMap(Long k, String v) {
        System.out.println(k + v);
    }

}
