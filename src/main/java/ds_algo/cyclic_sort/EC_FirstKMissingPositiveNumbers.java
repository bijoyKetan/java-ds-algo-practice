package ds_algo.cyclic_sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class EC_FirstKMissingPositiveNumbers {

    public List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();

        int n = nums.length;
        int i = 0;

        while (i < n) {
            int j = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < n && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else{
                i++;
            }
        }

        int counter = 0;
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
                counter++;
            }
            if (counter >= k) break;
        }

        if (counter < k){
            //IntStream.range(missingNumbers.get(counter-1), missingNumbers.get(counter-1) +k).forEach(x -> missingNumbers.add(x));
            int start = missingNumbers.get(counter-1) +1;
            IntStream.range(start, k-counter +1 + start).forEach(x -> missingNumbers.add(x));
        }

        return missingNumbers;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void testFirstKMissing(){
        List<Integer> missingNumbers = findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
        System.out.println("Missing numbers: " + missingNumbers); //[1, 2, 6]

        missingNumbers = findNumbers(new int[] { 2, 3, 4 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = findNumbers(new int[] { -2, -3, 4 }, 2);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}
