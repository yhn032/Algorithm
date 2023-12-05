package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Sort_bakjoon_2693_N번째큰수 {

    public static void main(String[] args) throws Exception{

        /* 2693 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            List<Integer> collect = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().boxed().collect(Collectors.toList());
            sb.append(collect.get(7));
            if(T > 0) sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
