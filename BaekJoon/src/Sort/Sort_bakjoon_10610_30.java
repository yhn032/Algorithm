package Sort;

import java.util.Arrays;
import java.util.Scanner;
public class Sort_bakjoon_10610_30 {
    public static void main(String[] args) {
        //30�� ��� -> 3�� 10�� ����� -> 0�� ���� 3�� ����� ����� �ִ� �ִ� ���ϱ�. 0�� �������� ���̸� ��
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