package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3034_¾Þ±×¸®Ã¢¿µ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		double diagonal = Math.pow(w, 2) + Math.pow(h, 2); 
		
		while(n --> 0) {
			int b = Integer.parseInt(br.readLine());
			
			if(Math.pow(b, 2) <= diagonal) {
				sb.append("DA").append('\n');
			}else {
				sb.append("NE").append('\n');
				
			}
		}
		System.out.println(sb);
	}

}

