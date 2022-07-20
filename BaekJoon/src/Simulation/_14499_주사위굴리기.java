package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14499_주사위굴리기 {
	//					동 서 북 남
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());			//행
		int m = Integer.parseInt(st.nextToken());			//열
		int x = Integer.parseInt(st.nextToken());			//시작점 x
		int y = Integer.parseInt(st.nextToken());			//시작점 y
		int k = Integer.parseInt(st.nextToken());			//이동횟수
		
		int map[][] = new int[n][m];
		
		for(int i=0 ; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		//현재 위치
		int curX = x;
		int curY = y;
		
		//배열에 표시할 인덱스를 저장한다. 
		//					    tt ww nn ee ss bb
		dice curDice = new dice(0, 1, 2, 3, 4, 5);
		int Dice[] = new int[6];
		while(k-->0) {
			//방향변수 : 동서북남
			int direction = Integer.parseInt(st.nextToken());
			
			
			//이동할 좌표의 유망성 체크
			int nextX = curX + dx[direction-1];
			int nextY = curY + dy[direction-1];
			
			if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
			
			
			//이동이 가능하다면 주사위의 정보 초기화하기
			
			//이동 전 
			int tt = curDice.top;
			int ww = curDice.west;
			int nn = curDice.north;
			int ee = curDice.east;
			int ss = curDice.south;
			int bb = curDice.bottom;
			
			dice nextDice;
			
			switch(direction) {
			case 1://동(south, north고정)
				//int               tt, ww, nn, ee, ss, bb;
				nextDice = new dice(ww, bb, nn, tt, ss, ee);
				break;
			case 2://서
				nextDice = new dice(ee, tt, nn, bb, ss, ww);
				break;
			case 3://북
				nextDice = new dice(ss, ww, tt, ee, bb, nn);
				break;
			default://남
				nextDice = new dice(nn, ww, bb, ee, tt, ss);
				break;
			}
			
			curDice = nextDice;
			curX = nextX;
			curY = nextY;
			
			//칸에 있는 수가 0이면 		주사위 바닥면에 있는 수가 칸에 복사 
			//칸에 있는 수가 0이 아니면 칸에 쓰여있는 수가 바닥면에 복사되고 칸은 0이된다.
			if(map[nextX][nextY] == 0) {
				map[nextX][nextY] = Dice[curDice.bottom];
				sb.append(Dice[curDice.top]).append('\n');
			}else { // != 0
				Dice[curDice.bottom] = map[curX][curY];
				map[curX][curY] = 0;
				sb.append(Dice[curDice.top]).append('\n');
			}

		}//end - while
		System.out.println(sb.toString());
		
	}
}
class dice {
	int top, west, north, east, south, bottom;

	public dice(int top, int west, int north, int east, int south, int bottom) {
		this.top = top;
		this.west = west;
		this.north = north;
		this.east = east;
		this.south = south;
		this.bottom = bottom;
	}
}
