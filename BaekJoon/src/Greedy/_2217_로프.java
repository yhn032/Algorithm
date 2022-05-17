package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2217_로프 {

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
		
		//최대 중량 배열
		int max[] = new int[n];
		//최대 중량 배열의 최댓값
		int maxmax = 0;
		
		//밧줄 개수
		int lope = 0; 
		
		for(int i= n-1; i>=0;i--) {
			//무거운 무게부터 검사한다.
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


//100,000개의 밧줄을 10,000의 수를 정렬할 수 있어야 하는 시간 복잡도가 필요한데 고려 안해도 될듯
