package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14499_�ֻ��������� {
	//					�� �� �� ��
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());			//��
		int m = Integer.parseInt(st.nextToken());			//��
		int x = Integer.parseInt(st.nextToken());			//������ x
		int y = Integer.parseInt(st.nextToken());			//������ y
		int k = Integer.parseInt(st.nextToken());			//�̵�Ƚ��
		
		int map[][] = new int[n][m];
		
		for(int i=0 ; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		//���� ��ġ
		int curX = x;
		int curY = y;
		
		//�迭�� ǥ���� �ε����� �����Ѵ�. 
		//					    tt ww nn ee ss bb
		dice curDice = new dice(0, 1, 2, 3, 4, 5);
		int Dice[] = new int[6];
		while(k-->0) {
			//���⺯�� : �����ϳ�
			int direction = Integer.parseInt(st.nextToken());
			
			
			//�̵��� ��ǥ�� ������ üũ
			int nextX = curX + dx[direction-1];
			int nextY = curY + dy[direction-1];
			
			if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
			
			
			//�̵��� �����ϴٸ� �ֻ����� ���� �ʱ�ȭ�ϱ�
			
			//�̵� �� 
			int tt = curDice.top;
			int ww = curDice.west;
			int nn = curDice.north;
			int ee = curDice.east;
			int ss = curDice.south;
			int bb = curDice.bottom;
			
			dice nextDice;
			
			switch(direction) {
			case 1://��(south, north����)
				//int               tt, ww, nn, ee, ss, bb;
				nextDice = new dice(ww, bb, nn, tt, ss, ee);
				break;
			case 2://��
				nextDice = new dice(ee, tt, nn, bb, ss, ww);
				break;
			case 3://��
				nextDice = new dice(ss, ww, tt, ee, bb, nn);
				break;
			default://��
				nextDice = new dice(nn, ww, bb, ee, tt, ss);
				break;
			}
			
			curDice = nextDice;
			curX = nextX;
			curY = nextY;
			
			//ĭ�� �ִ� ���� 0�̸� 		�ֻ��� �ٴڸ鿡 �ִ� ���� ĭ�� ���� 
			//ĭ�� �ִ� ���� 0�� �ƴϸ� ĭ�� �����ִ� ���� �ٴڸ鿡 ����ǰ� ĭ�� 0�̵ȴ�.
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
