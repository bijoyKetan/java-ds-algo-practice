package ds_algo.sorting_algorithms;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
//        int[] input = new int[]{};
//        int[] input = new int[]{9, 7, 5, 2, 1};
//        int[] input = new int[]{3, 6, 2, 8, 3, 9, 1};
        int[] input = new int[]{9, 1, 6, 10, 0, 18, 9, 8, 5, 6, 3, 22, -10, -8, 2};
        System.out.println("Input array: " + Arrays.toString(input));

        int[] sortedArr = heapSort(input);
        System.out.println("Final result:  " + Arrays.toString(sortedArr));
    }

    public static int[] heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) return arr;
        heapify(arr);
        bubbleDownSort(arr);
        return arr;
    }

    private static void heapify(int[] arr) {
        //Traverse left to right
        //Rightmost item in window is the newly inserted child
        //Check if arr[parent] < arr[child]
        //If so, swap with parent(s) until heap order restored

        int i = 0;
        int parent, child;

        while (i < arr.length) {
            child = i;
            parent = (child - 1) / 2;
            while (arr[parent] < arr[child]) {
                swap(arr, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
            i++;
        }
        System.out.println("Post heapify: " + Arrays.toString(arr));
    }

    private static void bubbleDownSort(int[] arr) {
        //From Maxheap, pop from the root (first item)
        //swap with last item
        //Reduce heap size
        //Check if left and right children exist
        //If so, check which one is bigger and swap
        //If only left child exist, then
        //Check if left child is bigger and of so, swap

        int lastIndex = arr.length - 1;
        int parent, leftChild, rightChild, biggerChild;

        while (lastIndex >= 0) {
            //swap the first (max) item with the last item
            swap(arr, 0, lastIndex);
            parent = 0;
            leftChild = 2 * parent + 1;
            rightChild = 2 * parent + 2;
            //reduce heap size
            //think of this like partition
            // LHS of partition is heap
            //RHS of partition is sorted array
            lastIndex--;

            //restore heap property
            //case 1: both children exist
            while (leftChild <= lastIndex && rightChild <= lastIndex &&
                    (arr[parent] < arr[leftChild] || arr[parent] < arr[rightChild])) {
                biggerChild = arr[leftChild] > arr[rightChild] ? leftChild : rightChild;
                swap(arr, parent, biggerChild);
                parent = biggerChild;
                leftChild = 2 * parent + 1;
                rightChild = 2 * parent + 2;
            }

            //case 2: only left child exist
            //In this case, there will never be a right child post swap
            //due to complete binary tree and heap property
            while (leftChild <= lastIndex && arr[parent] < arr[leftChild]) {
                swap(arr, parent, leftChild);
                parent = leftChild;
                leftChild = 2 * parent + 1;
            }
        }
        System.out.println("Post sorted: " + Arrays.toString(arr));
    }

    private static void swap(int[] arr, int parent, int child) {
        int temp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = temp;
    }
}
