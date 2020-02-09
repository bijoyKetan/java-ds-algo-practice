package ds_algo.string;

public class ReverseStrings {
    public static void main(String[] args) {
        String s = "The sky     is blue!";
        String[] strArray = s.trim().split(" ");

        for (int i = 0; i<strArray.length; i++){
            strArray[i].replace(" ","");
        }

        for (int i = 0; i < (strArray.length/2); i++){
            int j = strArray.length-1-i;
            String temp = strArray[i];
            strArray[i] = strArray[j];
            strArray[j] = temp;
        }

        String result = String.join(" ", strArray);
        System.out.println(result);
    }
}
