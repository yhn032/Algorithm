package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2566 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int [][]map = new int[9][9];

		int max = 0;
		int row = 0;
		int col = 0;
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j]) {
					max = map[i][j];
					row = i;
					col = j;
				}
			}
		}
		
		
		System.out.println(max);
		System.out.println((row+1) + " " + (col+1));
		


	}


}
