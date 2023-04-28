package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _9463_스티커_바텀업 {
	
	static int N;
	static int [][]sticker;
	static int [][]DP;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		//테스트 케이스만큼 반복
		while(T --> 0) {
			
			//열의 개수
			N = Integer.parseInt(br.readLine());
			sticker = new int[2][N];
			
			//스티커 점수 초기화
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			DP = new int[N+1][3];
			for(int i=0; i<N; i++) {
				DP[i+1][0] = Math.max(DP[i+1][0], Math.max(DP[i][0], Math.max(DP[i][1], DP[i][2])));
				DP[i+1][1] = Math.max(DP[i+1][1], Math.max(DP[i][0], DP[i][2]) + sticker[1][i]);
				DP[i+1][2] = Math.max(DP[i+1][2], Math.max(DP[i][0], DP[i][1]) + sticker[0][i]);
			}
			
			int max = Math.max(DP[N][0], Math.max(DP[N][1], DP[N][2]));
			sb.append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

}
