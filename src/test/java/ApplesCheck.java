import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ApplesCheck {

    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int maxWeight = 0;
        int i = 0;

        for (i=0; i< arr.length; i++){
            if (maxWeight + arr[i] <= 5000){
                maxWeight += arr[i];

            } else{
                return i;
            }
        }

        return arr.length;

    }

    @Test
    public void hexTest(){
        String num =  "257";
        String hex = Integer.toHexString(Integer.valueOf(num));
        System.out.println(hex);
    }


    @Test
    public void test(){
        int[] apples = new int[]{900,950,800,1000,700,800};
        System.out.println(maxNumberOfApples(apples));
    }

}
