package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class _9506 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> list = null;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == -1) break;

            list = new ArrayList<>();

            for (int i=1; i<= Math.sqrt(N); i++){
                if(N % i == 0){
                    list.add(i);
                    if(i == 1) continue;
                    if (i*i != N) list.add(N / i);
                }
            }

            int sum = list.stream().mapToInt(Integer::intValue).sum();

            if(sum == N) {
                Collections.sort(list);
                sb.append(N).append(" = ").append(list.get(0)).append(" ");
                for(int i=1; i<list.size(); i++){
                    sb.append("+ ").append(list.get(i));
                }
                sb.append("\n");
            }
            else sb.append(N).append(" is NOT perfect.").append("\n");
        }
    }

}
