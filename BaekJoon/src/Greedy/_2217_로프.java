package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2217_���� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		
		for(int i=0; i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		//�ִ� �߷� �迭
		int max[] = new int[n];
		//�ִ� �߷� �迭�� �ִ�
		int maxmax = 0;
		
		//���� ����
		int lope = 0; 
		
		for(int i= n-1; i>=0;i--) {
			//���ſ� ���Ժ��� �˻��Ѵ�.
			max[i] = arr[i] * ++lope;
			maxmax = maxmax < max[i] ? max[i] : maxmax;
		}
		
		/*
		 * for(int i=0; i<n; i++) { System.out.print(arr[i]+ " "); }
		 * System.out.println(); for(int i=0; i<n; i++) { System.out.print(max[i]+ " ");
		 * }
		 * 
		 * System.out.println();
		 */
		System.out.println(maxmax);
		
		
	}

}


//100,000���� ������ 10,000�� ���� ������ �� �־�� �ϴ� �ð� ���⵵�� �ʿ��ѵ� ��� ���ص� �ɵ�
