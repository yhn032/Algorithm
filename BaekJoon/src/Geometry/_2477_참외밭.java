package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2477_참외밭 {
	static int EAST = 1;
	static int WEST = 2;
	static int SOUTH= 3;
	static int NORTH= 4;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		//전체 사각형의 넓이 - 부분 사각형의 넓이
		int map[][] = new int[6][2];
		int k = Integer.parseInt(br.readLine());
		
		for(int i =0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			map[i][0] = a;
			map[i][1] = dist;
		}
		
		int max_W=0;
		int max_W_idx =0;
		
		int max_H=0;
		int max_H_idx =0;
		
		for(int i=0; i<6;i++) {
			if(map[i][0] == EAST || map[i][0] == WEST) {
				if(max_W < map[i][1]) {
					max_W =  map[i][1];
					max_W_idx=i;
				}
				
			} else {
				if(max_H < map[i][1]) {
					max_H =  map[i][1];
					max_H_idx=i;
				}
			}
		}
		
		int max_square = max_H * max_W;
		
		
		int sub_w;
		int sub_h;
		if(max_W_idx==0) sub_w = Math.abs(map[1][1]-map[5][1]);
		else if(max_W_idx==5) sub_w = Math.abs(map[4][1] - map[0][1]);
		else sub_w = Math.abs(map[max_W_idx+1][1]- map[max_W_idx-1][1]);
		
		if(max_H_idx==0) sub_h = Math.abs(map[1][1]-map[5][1]);
		else if(max_H_idx==5) sub_h = Math.abs(map[4][1] - map[0][1]);
		else sub_h = Math.abs(map[max_H_idx+1][1]- map[max_H_idx-1][1]);
		
		int sub_square = sub_w*sub_h;
		
		System.out.println((max_square-sub_square)*k);
		
	}

}
