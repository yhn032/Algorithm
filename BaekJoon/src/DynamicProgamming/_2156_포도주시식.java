package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2156_포도주시식 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int wine[] = new int[n+1];
		int dp[]   = new int[n+1];
		
		
		for(int i=1; i<=n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		//바틈업 -> 초깃값 초기화하기
		dp[1] = wine[1];
		
		if(n > 1) { //n=1일때, dp[2]를 채우려고 하면 outof index에러발생
			dp[2] = wine[1] + wine[2];
		}
		
		for(int i=3; i<=n; i++) {
			//n-1번의 경우의수를 찾게 되면, 모든 경우의 수에 대해서 
			//-1의 경우의수를 구하면서 연속된 세수의 합을 구하기 때문에 최대 두번의 연속된 경우의 수를 구하기 위해서는
			//n-2와 n-3을 선택해야 한다.
			dp[i] = Math.max( dp[i-1] , Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1]+ wine[i]));
			
			//i번 와인을 먹는다고 하자 
			//바로 직전의 와인인 i-1번 와인을 먹는 경우와 아래 경우의 최댓값과 비교해서 최댓값을 찾는다.
			//i-2번 와인을 마시고 i-1을 건너뛰는 경우 vs i-3번 와인을 마시고, i-2번 와인을 마시고 i번 와인을 마신 경우 -> 최댓값
		}
			
		
		System.out.println(dp[n]);
	}

}

/*
	음의 정수는 없다. 
	연속된 세잔은 마실 수 없다. 
	n <= 2이라면 그냥 합을 더하면 된다.
	
	n >= 3이라면 
*/
