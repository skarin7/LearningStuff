package com.practice;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shankark on 20/2/17.
 */
public class TargetBoxCalculation {

    boolean isMagicBoxPossible(int small, int big, int target) {

        final int SMALL_SIZE = 1;
        final int BIG_SIZE = 5;
        int i = 1;
        boolean targetSmall = false;
        int remaining = target;
        while (i <= big) {
          remaining = remaining - BIG_SIZE;
            if (remaining == 0) {
                return true;
            } else if (remaining < 0 && i ==1){
                targetSmall = true;
                break;
            }else if(remaining < 0 ) {
                break;
            }

            i++;
        }

        int j = 1;
        int finalTargetValue = target;

        int finalSmallValue = remaining;
        while (j <= small) {
            if(targetSmall) {
                finalTargetValue = finalTargetValue - SMALL_SIZE;
                if(finalTargetValue == 0) {
                    return true;
                }
            } else {
                finalSmallValue = finalSmallValue - SMALL_SIZE;
                if(finalSmallValue == 0) {
                    return true;
                }

            }
            j++;
        }


     return false;
    }

    @Test
    public void testMagic() {
        TargetBoxCalculation box = new TargetBoxCalculation();

        Assert.assertFalse(box.isMagicBoxPossible(1, 1, 0));
        Assert.assertTrue(box.isMagicBoxPossible(1, 1, 5));
        Assert.assertTrue(box.isMagicBoxPossible(1, 3, 16));
        Assert.assertTrue(box.isMagicBoxPossible(1, 4, 20));
        Assert.assertTrue(box.isMagicBoxPossible(1, 1, 6));
    }
}
