package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10844_계단수 {
	static int mod = 1000000000;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		long D[][] = new long[n+1][11];
		
		for(int i=1; i<=9; i++) {//각 자리에는 0~9가 들어갈 수 있지만, 가장 첫 자리에는 0이 들어갈 수 없다고 했다. 따라서 1~9까지만 초기화 하자
			D[1][i] = 1;//한자리수는 경우의수가 각각 1뿐이다.
		}
		
		//N=2인 경우부터 차례대로 입력값 n까지 더해간다. 
		//값을 mod로 나누어 주면서 진행. 
		for(int i=2; i<=n; i++) {
			D[i][0] = D[i-1][1];		
			D[i][9] = D[i-1][8];
			for(int k=1; k<=8; k++) {
				D[i][k] = (D[i-1][k-1] + D[i-1][k+1]) % mod;
			}
		}
		
		long sum=0;
		for(int i=0; i<10; i++) {
			sum = (sum+D[n][i])%mod;
		}
		
		System.out.println(sum);
		
	}

}


/*
	D[N][H] = 길이가 N이면서 마지막 값이 H로 끝나는 계단 수를 만들 수 있는 경우의 수 
	
	D[N][H] = D[N-1][H+1]		//H=0일때
	D[N][H] = D[N-1][H-1]		//H=9일때
	D[N][H] = D[N-1][H+1] + D[N-1][H-1]		//H=1~8
*/
