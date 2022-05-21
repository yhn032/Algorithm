package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1002_원의교점 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t =Integer.parseInt(br.readLine());
		
		/*	1. 안 만나는 경우 			 0
		 	2. 외접하는 경우 			 1
		 	3. 두 점에서 만나는 경우 	 2
		 	4. 내접하는 경우			 1
		 	5. 포함되는 경우 			 0
		 	6. 일치하는 경우			-1
		*/
		while(t-->0) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			//두점 사이의 거리 
			//실수의 연산은 부동소수점 처리로 인해서 정확하지 않기 때문에
			//정수를 제곱한 값을 정수형으로 만들어서 처리 해야 합니다. 
			
			int d = (int)(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
			
			if(x1==x2 && y1 == y2 && r1==r2) {
				cnt = -1;
			}else if(d > Math.pow(r1+r2, 2) || d < Math.pow(r1-r2,2)) {
				cnt = 0;
			}else if(d == Math.pow(r1+r2,2) || d == Math.pow(r1-r2,2)) {
				cnt = 1;
			}else{
				cnt = 2;
			}
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}

}
