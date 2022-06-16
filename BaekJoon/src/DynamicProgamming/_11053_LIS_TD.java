package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11053_LIS_TD {
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
		
		//모든 범위에 대해서 탐색을 진행해야 각각의 원소에 대한 증가하는 부분수열을 구할 수 있다.
		for(int i=0; i<n; i++) {
			LIS(i);
		}
		
		int max = 0;
		//최대 길이 찾기 
		for(int i : dp) {
			max = Math.max(max, i);
		}
		System.out.println(max);
	}

	private static int LIS(int n) {
		// TODO Auto-generated method stub
		//아직 탐색하지 않은 인덱스 위치라면
		if(dp[n] == 0) {
			dp[n] = 1; //1로 초기화 (조건을 만족하는 수열이 없다면 나 자신 하나만 부분 수열이 된다. ex 20, 30, 10 이렇게 있었다면 dp[0]=1, dp[1] = 2, dp[2]= 1)
			
			//n보다 작은 index를 탐색한다. 
			for(int i = n-1; i >=0; i--){
				if(arr[i] < arr[n]) {
					dp[n] = Math.max(dp[n], LIS(i) + 1);
				}
			}
		}
		
		return dp[n];
	}

}
