package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14503_로봇청소기 {
	static int n, m;
	static int cleanCnt = 0;
	static int[][] map;
	//				    북 동 남  서
	static int dx[] = {-1, 0, 1,  0};
	static int dy[] = { 0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());				// 0: 북, 1: 동, 2: 남, 3: 서
		
		//빈칸 0, 벽 1
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(startX, startY, dir);
		
		
		System.out.println(cleanCnt);
		
	}
	
	
	//너비우선 탐색을 해야 하는데, 방문할 시점에 방향까지 같이 큐에 저장해야 할듯... 내일 하자
	private static void clean(int x, int y, int direction) {
		// TODO Auto-generated method stub
		
		//1. 현재 위치를 청소한다. 
		if(map[x][y] == 0) {
			map[x][y] = 2;//청소한 지역은 2로 표시한다.
			cleanCnt++;
		}
		
		
		//2. 현재 위치에서 왼쪽 방향부터 탐색.
		int origin = direction; //초기 방향
		boolean flag = false;//사방위 중 하나라도 청소할 공간이 있으면 true로 바꾼다. 
		for(int i=0; i<4; i++) {//청소를 할 수 있던 없던을 따지기 전에 일단 현재 위치에서 사방을 모두 탐색해야 하므로 4회 반복
			int next_d = rotateRobot(direction);
			int next_x = x + dx[next_d];
			int next_y = y + dy[next_d];
			
			if(next_x > 0 && next_y > 0 && next_x < n && next_y < m) {
				if(map[next_x][next_y] == 0) {
					clean(next_x, next_y, next_d);
					flag = true;
					break;
				}
			}
			
			
			//방향 회전
			direction = rotateRobot(direction);
			
		}
		
		if(!flag) {
			//사방이 청소할 수 없는 경우 -> 방향을 유지한 채로 후진한다.
			int next_d = goBackRobot(origin);
			int next_x = x + dx[next_d];
			int next_y = y + dy[next_d];
			
			if(next_x > 0 && next_y > 0 && next_x < n && next_y < m) {
				
				if(map[next_x][next_y] != 1) {//뒤쪽에 벽이 아닌 경우에 후진, 아니면 종료
					clean(next_x, next_y, origin);
				}
			}
			
		}
		
			
	}

	private static int goBackRobot(int origin) {
		// TODO Auto-generated method stub
		int temp = origin + 2; 
		
		if(temp >= 4) temp -= 4;
		
		
		return temp;
	}


	private static int rotateRobot(int dir2) {
		// TODO Auto-generated method stub
		int tmp = 0;
		if(dir2 == 0) {
			tmp = 3;
		}else {
			tmp = dir2-1;
		}
		
		return tmp;
	}
}
/*
	이동 규칙
	1. 현재 위치를 청소한다. 
	2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 탐색을 진행한다. 
		a. 왼쪽 방향에 아직 청소하지 않은 공간이 있다면, 그 방향으로 회전한 후에 다음 한 칸으로 전진하고 1부터 진행
		b. 청소할 공간이 없다면 그 방향으로 회전만 하고 2번으로 돌아간다. 
		c. 현재 위치에서 네 방향 모두 청소가 이미 되어있거나 벽인 경우 방향은 유지한 채로 후진한다. 
		d. 네 방향 모두 청소가 되어 있거나 벽이면서, 뒤쪽 방향이 벽이라 후진 할 수 없는 경우에 청소 종료
*/
