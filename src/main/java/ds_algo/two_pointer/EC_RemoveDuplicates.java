package ds_algo.two_pointer;

public class EC_RemoveDuplicates {
    public static int remove(int[] arr) {
        // Fast and slow pointer
        // int i (slow pointer), int j (fast pointer)
        // Iterate through the array using j
        // Increment i only when unique item encountered

        if (arr.length == 0) return 0;
        int i = 0;
        int j = 0;
        for (j = 0; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return i + 1;
        //for the subarray
        //return Arrays.copyOfRange(arr, 0, i+1);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(remove(arr));

        arr = new int[]{2, 2, 2, 11};
        System.out.println(remove(arr));

        arr = new int[]{9};
        System.out.println(remove(arr));

        arr = new int[]{};
        System.out.println(remove(arr));

        arr = new int[]{1,2,3,4,5,6};
        System.out.println(remove(arr));

    }
}
