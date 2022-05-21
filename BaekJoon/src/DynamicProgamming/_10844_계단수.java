package DynamicProgamming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10844_��ܼ� {
	static int mod = 1000000000;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		long D[][] = new long[n+1][11];
		
		for(int i=1; i<=9; i++) {//�� �ڸ����� 0~9�� �� �� ������, ���� ù �ڸ����� 0�� �� �� ���ٰ� �ߴ�. ���� 1~9������ �ʱ�ȭ ����
			D[1][i] = 1;//���ڸ����� ����Ǽ��� ���� 1���̴�.
		}
		
		//N=2�� ������ ���ʴ�� �Է°� n���� ���ذ���. 
		//���� mod�� ������ �ָ鼭 ����. 
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
	D[N][H] = ���̰� N�̸鼭 ������ ���� H�� ������ ��� ���� ���� �� �ִ� ����� �� 
	
	D[N][H] = D[N-1][H+1]		//H=0�϶�
	D[N][H] = D[N-1][H-1]		//H=9�϶�
	D[N][H] = D[N-1][H+1] + D[N-1][H-1]		//H=1~8
*/
