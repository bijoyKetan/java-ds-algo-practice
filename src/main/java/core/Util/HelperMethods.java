package core.Util;

import java.util.Arrays;

public class HelperMethods {
    public static void print2DArray(int[][] arr) {
//        for (int[] row: arr){
//            for (int col: row){
//                System.out.print(col+ "\t");
//            }
//            System.out.println("\n");
//        }
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
