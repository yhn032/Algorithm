package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1004_어린왕자 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			int ans=0;
			
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			
			//행성의 개수
			int n = Integer.parseInt(br.readLine());
			
			for(int i=0; i<n;i++) {
				st = new StringTokenizer(br.readLine());
				
				int Cx = Integer.parseInt(st.nextToken());
				int Cy = Integer.parseInt(st.nextToken());
				int Cr = Integer.parseInt(st.nextToken());
				
				//시작점이 행성 외부(true)에 있는지 내부(false)에 있는지 확인해줄 상태변수
				boolean check_start = false;
				boolean check_end   = false;
				
				
				//시작점과 원의 중심 사이의 거리가 반지름 보다 크다면 외부에 있는거다.
				if(Math.pow(startX-Cx, 2) + Math.pow(startY-Cy, 2) > Math.pow(Cr, 2)) check_start = true;
				if(Math.pow(endX-Cx, 2) + Math.pow(endY-Cy, 2) > Math.pow(Cr, 2)) check_end = true;
				
				//시작점과 도착점 중에서 둘 중에 하나만 원의 내부에 있을 때, 진입/이탈 경우의수 +1
				if(check_end==true && check_start==false) ans++;
				else if(check_end==false && check_start==true) ans++;
				
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
		
	}
}
