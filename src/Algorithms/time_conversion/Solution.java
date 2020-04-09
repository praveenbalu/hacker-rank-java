package time_conversion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String meridian=s.substring(8);
        int hour=Integer.parseInt(s.split(":")[0]);
        hour=meridian.equals("PM") && hour!=12 ?hour+12:hour;
        hour=meridian.equals("AM") && hour==12 ?hour-12:hour;
        
        return String.format("%02d%s",hour,s.substring(2, 8));
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
