package BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _1978_소수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());

		
		 
		
		
		int arr[] = new int[1001]; //1000이하의 소수 구하기
		//List<Integer> list = new ArrayList<>(1001);
		
		
		for(int i=2; i<arr.length;i++) {
			arr[i]=i;
		}
		
		for(int i=2; i<Math.sqrt(arr.length); i++) {
			if(arr[i] == 0) continue;
			
			for(int k= i+i ; k<arr.length; k+=i) {
				arr[k] = 0;
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		
		for(int k=0; k<N;k++) {
			int a = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==0) continue;
				
				if(a == arr[i]) {
					cnt++;
				}
			}
		}
		
		
		System.out.println(cnt);
		
		
		
		
	}

}
