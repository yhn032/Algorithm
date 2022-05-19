package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1085_직사각탈출 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		//가로 길이 : w
		//세로 길이 : h
		
		int []l = new int[4];
		l[0] = x; //왼변과의 거리
		l[1] = y; //아래변과의 거리
		l[2] = w-x; //오른변과의 거리
		l[3] = h-y; //위변과의 거리
		
		Arrays.sort(l);
		
		System.out.println(l[0]);
	}
}
