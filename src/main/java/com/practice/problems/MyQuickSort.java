package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shankark on 17/12/16.
 */
public class MyQuickSort {


    void QuickSort(int[] array,int start, int end) {

        if(start < end) {
            int position = Partition(array, start, end);
            //sort Left to the postion
            QuickSort(array, start, position - 1 );
            QuickSort(array, position + 1 , end );
        }

    }

    private int Partition(int[] array, int start, int end) {

        int Pindex = start, pivot_item = array[end];

    for(int i = start; i< end; i++) {
            if(array[i] < pivot_item) {
                swap(array, i, Pindex);
                Pindex++;
            }
        }
        swap(array, Pindex, end);

        return Pindex;
    }

    private void swap(int arry[], int a, int b) {
        int temp;
        temp = arry[a];
        arry[a] = arry[b];
        arry[b] = temp;
    }

    public static void main(String[] args) {
        MyQuickSort quickSort = new MyQuickSort();
        int arr[] = {1,4,3,29,6,2,56,21,90,20};
        quickSort.QuickSort(arr, 0, arr.length - 1);
        System.out.println(" After sorting array is:"+ Arrays.toString(arr));

    }

}
