package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11053_LIS_BU {
	static int dp[];
	static int arr[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n];
		
		//dp배열에는 인덱스까지의 최장 증가 부분수열의 "길이"를 저장
		dp[0] = 1;
		
		
		for(int i=0; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i] && dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		
		int max = 0;
		//최대 길이 찾기 
		for(int i : dp) {
			max = Math.max(max, i);
		}
		System.out.println(max);
	}

}
