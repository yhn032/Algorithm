package Sort;

import java.util.Arrays;
import java.util.Scanner;
public class Sort_bakjoon_10610_30 {
    public static void main(String[] args) {
        //30의 배수 -> 3과 10의 공배수 -> 0을 빼고 3의 배수로 만들수 있는 최댓값 구하기. 0은 마지막에 붙이면 됨
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        String N = sc.next();
        int sum = Arrays.stream(N.split("")).mapToInt(Integer::parseInt).sum();
        if(!N.contains("0") || sum % 3 != 0) System.out.println(-1);
        else {

            int[] ints = Arrays.stream(N.split("")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(ints);

            for(int i= ints.length-1; i>=0; i--){
                sb.append(ints[i]);
            }
            System.out.println(sb.toString());
        }

    }
}