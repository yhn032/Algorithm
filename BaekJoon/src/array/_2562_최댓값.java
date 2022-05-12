package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2562_ÃÖ´ñ°ª {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int arr[] = new int[9];
		int arr2[] = new int[9];
		for(int i=0; i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			arr2[i] = arr[i];
		}
		
		Arrays.sort(arr);
		int max = arr[8];
		sb.append(max).append('\n');
		
		for(int i=0; i<9;i++) {
			if(arr2[i]==max) {
				sb.append(i+1);
				break;
			}
		}
				
		System.out.println(sb);
	}

}

