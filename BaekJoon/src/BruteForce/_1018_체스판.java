package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018_체스판 {
	static int cnt;
	static char map[][];
	static int min=64;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
		}
		
		int temp_n = n-7;
		int temp_m = m-7;
		
		//모든 경우의 수 탐색 
		//현재 위치에서 상하 좌우가 다른 값이어야 한다. 
		//초기위치에 색칠되는 값에 따라 체스판이 다르다.
		//8x8단위로 끊어서 각 단위마다 탐색
		//각 단위 마다 수정의 횟수의 최솟값을 구해서 저장하고, 매 단위마다 산출된 최솟값과 비교하여 더 작은 값을 셋팅한다.
		for(int i=0; i<temp_n; i++) {
			for(int k=0; k<temp_m; k++) {
				find(i,k);//시작위치에서 탐색 시작
			}
		}
		
		 
		
		
		System.out.println(min);
		/*
		 * for(char[] cc : map) { for(char ccc : cc) { System.out.print(ccc + " "); }
		 * System.out.println(); }
		 */
	}

	private static void find(int x, int y) {
		// TODO Auto-generated method stub
		int end_x = x+8; //탐색할 체스판의 끝 인덱스 
		int end_y = y+8;
		//각 단위마다 카운트하기 위해 전역변수 0으로 초기화
		int cnt = 0;
		
		char C = map[x][y];// 시작값
		
		for(int i=x; i<end_x; i++) {
			for(int k=y; k<end_y; k++) {
				if(map[i][k] != C) {//값이 같지 않다면
					cnt++;
					
				}
				//현재 위치에서 다음위치는 값이 달라야 하기 때문에
				//C에 저장된 값을 바꾸어 주어야 한다.
				C = (C=='W') ? 'B' : 'W';
			}
			//각 행의 마지막 위치와 다음 행의 첫 위치는 값이 같아야 한다.
			//값을 바꾸면 안되는데, 위에서 값을 바꾸었기 때문에 다시 바꿔줘서 원상태로 해야 한다.
			C = (C=='W') ? 'B' : 'W';
			
		}
		
		//주어진 배열에서 시작값을 기준으로 색칠한 경우(cnt)와 시작값의 반대로 색칠한 경우(64-cnt) 둘 중의 최소값을 구한다.
		cnt = Math.min(cnt, 64-cnt);
		
		
		//현재 최솟값보다 작다면 갱신하기
		min = Math.min(cnt, min);
	}

}
