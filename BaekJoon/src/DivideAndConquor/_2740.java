package DivideAndConquor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2740 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		int [][] arr1 = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		int m2 = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [][] arr2 = new int[m2][k];
		for(int i=0; i<m2; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<k; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int [][]res = new int[n][k];
		for(int i=0; i<n; i++) {
			for(int j=0; j<k; j++) {
				
				for(int t=0; t<m ; t++) {
					res[i][j] += arr1[i][t] * arr2[t][j];
				}
			}
		}
		
		for(int i[] : res) {
			for(int ii : i) {
				System.out.print(ii + " ");
			}
			System.out.println();
		}
		
		
	}
}
