package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11399 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// �������� Ǫ�� ����� �˷����. ó���ð��� ª�� ������� ������������ �����϶�..
		// ���ð��� �ּ�ȭ �ؾ� �Ѵ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int time_sum_min=0;
		int N = Integer.parseInt(br.readLine()); 
		
		int []wait = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N;i++) {
			wait[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(wait);
		
		
		for(int i=0; i<N;i++) {
			time_sum_min += wait[i]*(N-i);
		}
		System.out.println(time_sum_min);
	}

}