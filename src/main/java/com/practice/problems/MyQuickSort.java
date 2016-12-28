
package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        Scanner scan = new Scanner(System.in);
        MyQuickSort quickSort = new MyQuickSort();
        while(scan.hasNext()) {
            int noOfTest = Integer.parseInt(scan.nextLine());
            do {
                int size = Integer.parseInt(scan.nextLine());
                String  array[] = scan.nextLine().split(" ");
//                List<Integer> lst = new ArrayList<>();
                int[] objects = Arrays.asList(array).stream().mapToInt(i -> Integer.parseInt(i)).toArray();
                quickSort.QuickSort(objects, 0, size - 1);
                System.out.println(" After sorting array is:"+ Arrays.toString(objects));

                System.out.println("Second largest in the array" + objects[size - 2]); // O(nlogn) Time complxity for Quicksor
                noOfTest--;
            }while(noOfTest > 0 );

            break;
        }
        }

    }

