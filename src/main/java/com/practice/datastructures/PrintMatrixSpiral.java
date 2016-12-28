package com.practice.datastructures;

/**
 * Created by shankark on 20/12/16.
 */
public class PrintMatrixSpiral {

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},{6,7,8,9},{10,11,12,13}};
        if(matrix.length == 0)
            return;
        // Initialize our four indexes
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(true)
        {
            // Print top row
            for(int j = left; j <= right; ++j) System.out.print(matrix[top][j] + " ");
            top++;
            if(top > down || left > right) break;
            //Print the rightmost column
            for(int i = top; i <= down; ++i) System.out.print(matrix[i][right] + " ");
            right--;
            if(top > down || left > right) break;
            //Print the bottom row
            for(int j = right; j >= left; --j) System.out.print(matrix[down][j] + " ");
            down--;
            if(top > down || left > right) break;
            //Print the leftmost column
            for(int i = down; i >= top; --i) System.out.print(matrix[i][left] + " ");
            left++;
            if(top > down || left > right) break;
        }

    }
}
