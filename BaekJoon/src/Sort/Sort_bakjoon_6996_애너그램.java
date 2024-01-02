package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Sort_bakjoon_6996_애너그램 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0){
            String[] temp = br.readLine().split(" ");
            String first = temp[0];
            String second = temp[1];

            String afterSortingFirst = Arrays.stream(first.split("")).sorted().collect(Collectors.joining());
            String afterSortingSecond = Arrays.stream(second.split("")).sorted().collect(Collectors.joining());

            if(afterSortingFirst.equals(afterSortingSecond)){
                sb.append(first).append(" & ").append(second).append(" are anagrams.");
            }else {
                sb.append(first).append(" & ").append(second).append(" are NOT anagrams.");
            }
            if(T > 0) sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
