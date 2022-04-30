package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11660_������2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//�������� ����ϴ� ����� ���� ���� ó�� ��ġ�� 1,1�̱� ������ �迭�� ��� ���� 1�� ������Ų��.
		//�׷��� 0��� 0���� ��� �ʱⰪ�� 0���� �ʱ�ȭ�Ǿ �� �迭�� ���ϴ� ������ �����ϸ� 0+A[1][1]�� �Ǿ� �ʱ갪�� ȿ�������� ���� �� �ִ�.
		
		//�����迭
		int A[][] = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//�����չ迭
		int D[][] = new int[N+1][N+1];
		for(int i=1; i<=N ; i++) {
			for(int j=1; j<=N ;j++) {
				D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			//���� �չ迭�� ���ǿ� ���ϱ�
			sb.append(D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1 - 1][y1 - 1]).append('\n');
		}
		/*
		 * for(int i=1;i<A.length;i++) { for(int j = 1; j<A[i].length; j++) {
		 * System.out.print(A[i][j] + " "); } System.out.println(); }
		 * 
		 * for(int i=1;i<A.length;i++) { for(int j = 1; j<A[i].length; j++) {
		 * System.out.print(D[i][j] + " "); } System.out.println(); }
		 */
		
		
		System.out.println(sb);
	}

}
