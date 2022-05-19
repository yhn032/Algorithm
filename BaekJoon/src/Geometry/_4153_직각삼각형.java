package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _4153_Á÷°¢»ï°¢Çü {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int arr[] = new int[3];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			
			if(arr[0]==0) break;

			Arrays.sort(arr);
			
			if(Math.pow(arr[2], 2) == Math.pow(arr[1], 2) + Math.pow(arr[0], 2)) {
				sb.append("right").append('\n');
			}else {
				sb.append("wrong").append('\n');
			}
			
			
		}
		
		System.out.println(sb);
	}

}

