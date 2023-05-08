package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10811 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] balls = new int[n+1];
        for(int i=1; i<=n; i++){
            balls[i] = i;
        }
        int swap;

        for(int i=0;i<m; i++){
//            int[] s1 = Arrays.stream(br.readLine().split(" "))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            while(start < end){
                swap = balls[start];
                balls[start] = balls[end];
                balls[end] = swap;
                start++;
                end--;
            }

        }

        for(int i=1; i<=n; i++){
            System.out.print(balls[i] + " ");
        }
    }

}
