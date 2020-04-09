package mini_max_sum;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        BigInteger minSum=BigInteger.ZERO;
        BigInteger maxSum=BigInteger.ZERO;
        
        for(int i=0;i<arr.length;i++) {
            BigInteger sum=BigInteger.ZERO;
            for(int j=0;j<arr.length;j++) 
                if(i!=j) sum=sum.add(BigInteger.valueOf(arr[j]));
            if(sum.longValue() >maxSum.longValue()) maxSum=sum;
            if(sum.longValue() < minSum.longValue() || minSum==BigInteger.ZERO) minSum=sum;
        }
        System.out.println(minSum+" "+maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
