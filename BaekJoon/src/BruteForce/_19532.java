package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _19532 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i=-999; i<=999; i++){
            for(int j=-999; j<=999; j++){
                if(s[0]*i+s[1]*j == s[2] && s[3]*i+s[4]*j == s[5] ){
                    System.out.println(i + " " + j);
                    break;
                }
            }
        }
    }
}
