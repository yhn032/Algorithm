package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1010_다리놓기 {
	static int dp[][] = new int[30][30];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			
			//강 서쪽 사이트
			int n = Integer.parseInt(st.nextToken());
			//강 동쪽 사이트
			int m = Integer.parseInt(st.nextToken());
			
			sb.append(bridge(m, n)).append('\n'); 
			
		}
		
		System.out.println(sb);
	}
	

	private static int bridge(int n, int r) {
		// TODO Auto-generated method stub
		if(dp[n][r] > 0) return dp[n][r];
		
		//0! == 1
		if(n == r || r == 0) return dp[n][r] = 1;
		
		
		return dp[n][r] = bridge(n-1,r-1) + bridge(n-1,r);
	}

}


//재귀를 통해 방문 체크 하면 될 것 같은데 다이나믹을 써야하나?
//M의 최대 값은 30인데?
//조합의 수를 나열하면 되네 ;; 
// (왼, 오) -> 겹치면 안되기 때문에 증가하는 순서로 출력해야 한다.