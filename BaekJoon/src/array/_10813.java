package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10813 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int swap;

        int[] balls = new int[n+1];
        for(int i=1; i<=n; i++){
            balls[i] = i;
        }
        for(int i=0;i<m; i++){
            int[] s1 = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            swap = balls[s1[0]];
            balls[s1[0]] = balls[s1[1]];
            balls[s1[1]] = swap;
        }

        for(int i=1; i<=n; i++){
            System.out.print(balls[i] + " ");
        }
    }
}
