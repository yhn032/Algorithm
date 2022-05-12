package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3052_³ª¸ÓÁö {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int arr[] = new int[42]; // 0 ~ 41
		
		for(int i=0; i<10; i++) {
			int a = Integer.parseInt(br.readLine());
			arr[a%42]++;
		}
		
		int cnt=0; 
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}

