package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3273_두수의합 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//수열의 개수
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//합을 구해야 하는 수
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int start_idx = 0;
		int end_idx = n-1;
		int cnt = 0;
		
		while(start_idx < end_idx) {
			if(arr[start_idx] + arr[end_idx] == x) {
				cnt++;
				start_idx++;
				end_idx--;
			} else if(arr[start_idx] + arr[end_idx] > x) {
				//값을 감소시켜야 함
				end_idx--;
			} else {//합 < x   -> 값을 증가시켜야 함
				start_idx++;
			}
			
		}
		
		
		
		sb.append(cnt);
		System.out.println(sb);

	}

}
