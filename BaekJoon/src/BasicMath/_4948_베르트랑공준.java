package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4948_베르트랑공준 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n;
		
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			int cnt = 0;
			int arr[] = new int[2*n+1];
			for(int i=2; i<=(2*n); i++) {
				arr[i] = i;
			}
			for(int i=2; i<=Math.sqrt(2*n); i++) {
				if(arr[i] == 0) continue;//삭제되었거나 1인 경우 skip
				
				for(int k=i+i; k<arr.length; k+=i) {
					arr[k] = 0;
				}
			}
			
			for(int i : arr) {
				//System.out.print(i + " ");
				if( i > n && i<=2*n) {
					//System.out.print(i + " ");
					cnt++;
				}
			}
			sb.append(cnt).append('\n');
			
		}
		
		if(n==1) {
			System.out.println(1);
		}else {
			System.out.println(sb);
		}
	}

}
