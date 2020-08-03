package CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HighestAndLowestNum {
//Version 1
    public static String highAndLow(String numbers){

        String[] value = numbers.split(" ");
        int lNum = Integer.parseInt(value[0]);
        int hNum = Integer.parseInt(value[0]);
        for (int i = 1; i <value.length; i++) {
            if(lNum>Integer.parseInt(value[i]))
                lNum = Integer.parseInt(value[i]);
            if(hNum<Integer.parseInt(value[i]))
                hNum = Integer.parseInt(value[i]);
        }
    return String.valueOf(hNum)+ " " + String.valueOf(lNum);

}
//Version 2
    public static String highAndLow1(String numbers) {
        String[] val = numbers.split(" ");
        int[] arr = new int[val.length];
        for (int i = 0; i < val.length; i++) {
            arr[i] = Integer.parseInt(val[i]);
        }
        Arrays.sort(arr);

        String high = arr[arr.length - 1] + " " + arr[0];

        return high;
    }

    public static void main(String[] args) {
        String nums = "8 3 -5 42 -1 0 0 -9 4 7 4 -4";
        System.out.println(highAndLow(nums));


    }

}


// ("1 2 3 4 5") = (12345)
// make it an Integer or Array of Integers
// loop and check if the i > i+1 = assign to temp
//return lowest and highest as a string