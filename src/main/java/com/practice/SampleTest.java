package com.practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SampleTest {

    private static final Logger logger = LogManager.getLogger(SampleTest.class);
    public static void main(String[] args) {
/*        StringBuffer sb = new StringBuffer("test");
        StringBuffer sb2 = new StringBuffer("test");
        Set<SLogAppManagertringBuffer> sets = new HashSet<StringBuffer>();
        sets.add(sb);
        sets.add(sb2);
        logger.info(sets);
        logger.info(sb.indexOf("e"));*/
        Map<String,String> values = new HashMap<>();
        values.put("One", "1");
        values.put("two", "2");
        logger.info("Hello{}", values);
        Map<String,String> test = null;
        test = values;
        logger.info(test);

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

        Function<Map<Long, String>, Map<Long, String>> finalMap = t -> {
            // TODO Auto-generated method stub
            return null;
        };
        logger.info(map1);

        BigDecimal number = BigDecimal.valueOf(2);
        logger.info((new DecimalFormat("#0").format(number)));
    }

    private static void alterMap(Long k, String v) {
        logger.info(k + v);
    }

}
