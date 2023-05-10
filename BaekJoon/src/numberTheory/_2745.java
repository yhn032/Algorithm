package numberTheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2745 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        long answer = 0;

        for(int i=N.length()-1; i>=0; i--){
            int temp = N.charAt(i);
            if(temp >= 65) temp -= 55;
            else temp -= 48;

            answer += Math.pow(B, N.length()-1-i) * temp;
        }

        System.out.println(answer);
    }
}
