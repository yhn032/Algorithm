package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _10810 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] balls = new int[n+1];
        for(int i=0;i<m; i++){
            String[] s1 = br.readLine().split(" ");
            for(int j=Integer.parseInt(s1[0]); j<=Integer.parseInt(s1[1]); j++){
                balls[j] = Integer.parseInt(s1[2]);
            }
        }

        for(int i=1; i<=n; i++){
            System.out.println(balls[i] + " ");
        }
    }
}
