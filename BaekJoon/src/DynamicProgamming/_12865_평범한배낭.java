package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12865_평범한배낭 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int W[] = new int[n+1];
		int V[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[][] = new int[n+1][k+1];
		
		for(int i=1; i<=n; i++) {
			
			for(int j=1; j<= k; j++) {// j-> 현재 round에서 수용가능한 최대 무게 
				
				//i번째 무게를 더 담을 수 없는 경우
				//이전 메모이제이션 값을 가져온다.
				if(W[i] > j) {
					dp[i][j] = dp[i-1][j];
				}
				
				//i번째 무게를 더 담을 수 있는 경우 -> W[i] <= j
				//최대 가치를 비교
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
				}
			}
		}
		
		
		System.out.println(dp[n][k]);
	}
}
