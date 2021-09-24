package com.ecsd.automation.brand;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author olufemi on 2021-09-22
 */
public class Calculations {

    public String getIndexOfBalancedArray(int arrayLength, int[] array){
        int x;
        int y;
        var rTotal = new AtomicInteger();
        var lTotal = new AtomicInteger();


        for( x = 0, y = arrayLength-1 ; x < y ; x++, y-- ){
            lTotal.addAndGet(array[x]);
            rTotal.addAndGet(array[y]);

            while((lTotal.get() < rTotal.get()) && (x < y)){
                lTotal.addAndGet(array[++x]);
            }
            while((rTotal.get() < lTotal.get()) && (x < y)){
                rTotal.addAndGet(array[--y]);
            }
        }

        if(lTotal.get() == rTotal.get() && x == y)
            return String.valueOf(x);
        else return null;
    }
}
