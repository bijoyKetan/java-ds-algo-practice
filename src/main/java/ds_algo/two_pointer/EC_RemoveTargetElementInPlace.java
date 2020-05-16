package ds_algo.two_pointer;

public class EC_RemoveTargetElementInPlace {
    //https://www.educative.io/courses/grokking-the-coding-interview/mEEA22L5mNA
    //Remove the key in place
    public static int remove(int[] arr, int key) {
        //Remove all the keys and return length
        //Two pointers
        //Fast pointer checks if arr[j] != key
        //Then  arr[i+1] = arr[j]
        int i = 0;
        int j = 0;

        for (j = 0; j < arr.length; j++) {
            if (arr[j] != key) {
                arr[i] = arr[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
        System.out.println(remove(arr, 3)); //4

        arr = new int[]{2, 11, 2, 2, 1};
        System.out.println(remove(arr, 2)); //2
    }
}

