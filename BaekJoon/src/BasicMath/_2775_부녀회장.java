package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2775_부녀회장 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//테스트 케이스
		int t =Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<t;i++) {
			//각 층의 정보
			int k =Integer.parseInt(br.readLine());
			
			//호수의 정보
			int n =Integer.parseInt(br.readLine());
			
			sb.append(search(k, n)).append('\n');
			
		}
		
		System.out.println(sb);
	}
	
	private static int  search(int k, int n) {
		// TODO Auto-generated method stub
		
		int arr[][]  = new int[k+1][n+1];
		
		for(int i=0; i<n;i++) {
			arr[0][i] = i+1;
		}
		
		
		//각 층의 정보
		for(int i=1; i<=k;i++) {
			
			//각 층의 호수 정보
			for(int j=0; j<n;j++ ) {
				int sum =0;
				
				//구하고자 하는 방의 바로 아래층에 대한 정보
				for(int p=0; p<=j;p++) {
					sum += arr[i-1][p];
					
					arr[i][p] = sum;
				}
			}
		}
		
		
		/*
		 * for(int i =0; i<=k;i++) { System.out.print(i + "번째 행 : ");
		 * 
		 * for(int j=0; j<n; j++) { System.out.print(arr[i][j] + " "); }
		 * System.out.println(); }
		 */
		int people = arr[k][n-1];
		
		
		
		
		return people;
		
	}

}
