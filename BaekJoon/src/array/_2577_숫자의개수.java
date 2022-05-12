package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2577_숫자의개수 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int temp = A * B * C;
		String str = Integer.toString(temp);
		int arr[] = new int[10];
		
		for(int i=0; i<str.length();i++) {
			arr[str.charAt(i) - '0']++;
		}
		
		for(int i : arr) {
			System.out.println(i);
		}
	}

}

