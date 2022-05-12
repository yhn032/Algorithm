package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _8958_OX {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String str;
		
		for(int i=0; i<N; i++) {
			int sum =0;
			int count=0;
			str = br.readLine();
			
			for(int k=0; k<str.length();k++) {
				if(str.charAt(k) == 'O') {
					count++;
				} else if(str.charAt(k) == 'X') {
					count=0;
				}
				sum += count;
			}
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
	}

}
