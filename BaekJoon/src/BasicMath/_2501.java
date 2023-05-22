package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _2501 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i=1; i<= Math.sqrt(N); i++){
            if(N % i == 0){
                list.add(i);
                list.add(N / i);
            }
        }

        Collections.sort(list);

        if(K > list.size()) System.out.println(0);
        else System.out.println(list.get(K-1));
    }
}
