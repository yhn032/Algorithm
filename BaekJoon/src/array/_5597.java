package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _5597 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[31];
		for(int i=1; i<31; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<28; i++) {
			int idx = Integer.parseInt(br.readLine());
			arr[idx] = 0;
		}
		
		for(int i : arr) {
			if(i != 0) System.out.println(i);
		}
	}
}
