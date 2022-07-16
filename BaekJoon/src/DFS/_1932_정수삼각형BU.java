package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932_정수삼각형BU {
	static int n;
	static int map[][];
	static int dp[][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		dp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k <= i; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		//가장 밑에서부터 값을 더하면서 올라와야 하기 때문에 dp테이블에 초깃값을 초기화 시킨다. 
		for(int i=0; i<n; i++) {
			dp[n-1][i] = map[n-1][i];
		}
		
		
		for(int i=n-2; i>=0; i--) {
			for(int k=0; k<n-1; k++) {
				dp[i][k] = Math.max(dp[i+1][k], dp[i+1][k+1]) + map[i][k];
			}
		}
		System.out.println(dp[0][0]);
		
	}


}
//삼각형의 크기가 크기때문에 메모이제이션 필수!
//탑다운 방식으로 진행한다. 
//현재 위치에서 두 자식 노드에 데이터가 있을때까지 재귀를 통해 깊이를 내려간다. 
//찾았다면 -> 메모이 제이션 된 값이 있다면 그 값을 가져온다.