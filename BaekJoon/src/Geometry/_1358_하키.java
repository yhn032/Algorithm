package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1358_하키 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		//너비w, 높이h, x, y, 선수의 수p	반지름 r은 h의 절반
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int r = h/2;//h는 반드시 짝수이다.
		
		//하키 내부에 있는 선수를 카운트해줄 변수
		int count = 0;
		
		
		for(int i =0; i<p; i++) {
			
			//내부에 있으면 true, 외부에 있으면 false
			boolean isInner = false;
			
			st = new StringTokenizer(br.readLine());
			
			//선수의 좌표
			int pX = Integer.parseInt(st.nextToken());
			int pY = Integer.parseInt(st.nextToken());
			
			//1. 왼쪽 반원의 중심보다 왼쪽에 있을 때
			if(pX < x) {
				
				//왼쪽 반원의 중심과 선수 사이의 거리가 반지름 보다 작거나 같을때 -> 내부에 있거나 경계에 존재
				if(Math.pow(pX-x, 2) + Math.pow(pY-(y+r), 2) <= Math.pow(r, 2)) {
					isInner = true;
				}
			}
			
			//2. 가운데 직사각형의 영역에 있을 때
			else if(pX >= x && pX <= x+w && pY <= y+h && pY >= y) {
				
				isInner = true;
				
			}
			//3. 오른쪽 반원의 중심보다 오른쪽에 있을 때
			else if(pX > x+w) {
				
				if(Math.pow(pX-(x+w), 2) + Math.pow(pY-(y+r), 2) <= Math.pow(r, 2)) {
					isInner = true;
				}
				
			}
			
			if(isInner) {
				count++;
			}
			
			
		}
		
		System.out.println(count);
	}

}
