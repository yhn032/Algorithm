package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11659_������1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//������ ���ϴ� ����
		//S[i] = S[i-1] + A[i]
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//���� ����
		int N = Integer.parseInt(st.nextToken());
		//���� ���ؾ� �ϴ� Ƚ��
		int M = Integer.parseInt(st.nextToken());
		
		//�־��� ��� : 100,000���� ���� 100,000�� ���ϱ� -> 1,000,000,000,000 int���� �Ѿ�⿡ long���� �ؾ���
		long[] S = new long[N+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i=1 ; i<=N; i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
			//System.out.print(S[i-1]+ " ");
		}
		
		for(int q=0; q<M;q++) {
			st=new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(S[j] - S[i-1]).append('\n');
		}
		
		System.out.println(sb);
	}

}
