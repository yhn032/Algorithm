package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3053_택시기하학 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		double r = Integer.parseInt(br.readLine());
		
		double uclid = Math.PI * r * r;
		double taxi  = 2 * r * r;
		
		sb.append(uclid).append('\n');
		sb.append(String.format("%.6f", taxi)).append('\n');
		
		System.out.println(sb);
	}

}
