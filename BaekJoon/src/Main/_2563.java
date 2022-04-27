package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _2563 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//전체 면적
		int sumArea=0;
		
		//전체 색종이의 수
		int N = Integer.parseInt(br.readLine());
		int cp_pos [][] = new int[100][100];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			//왼변과의 거리 (열의 시작점)
			int x = Integer.parseInt(st.nextToken());
			//밑변과의 거리 (행의 시작점)
			int y = Integer.parseInt(st.nextToken());
			
			for(int k=y; k<y+10; k++) {
				for(int j = x; j<x+10;j++){
					cp_pos[k][j] = 1;
				}
			}
						
		}
		//색종이에 면적에 해당하는 행/열위치에 1을 삽입. 나중에 1을 다 더해서 면적을 구하면 됨. 겹치는 면적은 1로 계속 덮어씌워짐
		//ex> 10x10 배열에 모두 1을 넣고 다 더하면 색종이의 면적 100이 나온다.
		for(int i = 0; i < cp_pos.length; i++) {
			for(int k=0; k < cp_pos[i].length; k++) {
				if(cp_pos[i][k] == 1)
					sumArea += cp_pos[i][k];
			}
			
		}
		System.out.println(sumArea);
		
	}

}
