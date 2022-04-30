package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11660_구간합2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//문제에서 사용하는 방식이 값의 가장 처음 위치가 1,1이기 때문에 배열의 행과 열을 1씩 증가시킨다.
		//그러면 0행과 0열은 모두 초기값인 0으로 초기화되어서 합 배열을 구하는 공식을 참고하면 0+A[1][1]가 되어 초깃값을 효과적으로 구할 수 있다.
		
		//원본배열
		int A[][] = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		//구간합배열
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
			
			//구간 합배열로 질의에 답하기
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
