package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2579_계단오르기TD {
	static int []step;
	static Integer []dp;
	static int n;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		step = new int[n+1];
		dp = new Integer[n+1];

		for(int i=1; i<=n; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		
		//첫 번째 계단의 값 초기화
		dp[0] = 0;//시작점은 값도 없고
		dp[1] = step[1];
		
		if(n>=2) {
			dp[2] = step[1] + step[2]; 
		}
		
		System.out.println(dfs(n));
	}
	private static int dfs(int depth) {
		// TODO Auto-generated method stub
		
		//연속된 세개의 계단을 밟을 수 없다. 
		//마지막 계단은 반드시 밟아야 하므로, 마지막 계단은 밟았다는 가정 하에 
		//마지막계단부터 top-down시작
		//직전 계단에서 올라온 경우 인지, 2계단 아래에서 올라온 것인지 중에서 최댓값을 구해야 한다 .
		//근데 이를 위해 depth-1과 depth-2로 재귀를 호출하면 모든 계단에 대해 메모이제이션을 하기 때문에 
		//연속된 세개의 계단을 모두 밟으면 안된다는 조건에 위배 된다. 
		//어떻게 호출 해야 한담 ... 
		
		
		
		if(dp[depth] == null) {
			dp[depth] = step[depth] + Math.max(dfs(depth-3)+step[depth-1],dfs(depth-2));
		}
		
		return dp[depth];
	}

}
