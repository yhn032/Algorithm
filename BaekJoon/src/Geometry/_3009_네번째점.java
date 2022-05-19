package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _3009_네번째점 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Map<Integer, Integer> x = new HashMap<Integer, Integer>();
		Map<Integer, Integer> y = new HashMap<Integer, Integer>();
		
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			int xx = Integer.parseInt(st.nextToken());
			int yy = Integer.parseInt(st.nextToken());
			
			x.put(xx, x.getOrDefault(xx, 0)+1);
			y.put(yy, y.getOrDefault(yy, 0)+1);
		}
		
		for(int i : x.keySet()) {
			if(x.get(i) == 1) {
				sb.append(i).append(' ');
			}
		}
		
		for(int i : y.keySet()) {
			if(y.get(i) == 1) {
				sb.append(i);
			}
		}
		
		
		System.out.println(sb);
	}

}



