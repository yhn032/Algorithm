package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14503_�κ�û�ұ� {
	static int n, m;
	static int cleanCnt = 0;
	static int[][] map;
	//				    �� �� ��  ��
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
		int dir = Integer.parseInt(st.nextToken());				// 0: ��, 1: ��, 2: ��, 3: ��
		
		//��ĭ 0, �� 1
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
	
	
	//�ʺ�켱 Ž���� �ؾ� �ϴµ�, �湮�� ������ ������� ���� ť�� �����ؾ� �ҵ�... ���� ����
	private static void clean(int x, int y, int direction) {
		// TODO Auto-generated method stub
		
		//1. ���� ��ġ�� û���Ѵ�. 
		if(map[x][y] == 0) {
			map[x][y] = 2;//û���� ������ 2�� ǥ���Ѵ�.
			cleanCnt++;
		}
		
		
		//2. ���� ��ġ���� ���� ������� Ž��.
		int origin = direction; //�ʱ� ����
		boolean flag = false;//����� �� �ϳ��� û���� ������ ������ true�� �ٲ۴�. 
		for(int i=0; i<4; i++) {//û�Ҹ� �� �� �ִ� ������ ������ ���� �ϴ� ���� ��ġ���� ����� ��� Ž���ؾ� �ϹǷ� 4ȸ �ݺ�
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
			
			
			//���� ȸ��
			direction = rotateRobot(direction);
			
		}
		
		if(!flag) {
			//����� û���� �� ���� ��� -> ������ ������ ä�� �����Ѵ�.
			int next_d = goBackRobot(origin);
			int next_x = x + dx[next_d];
			int next_y = y + dy[next_d];
			
			if(next_x > 0 && next_y > 0 && next_x < n && next_y < m) {
				
				if(map[next_x][next_y] != 1) {//���ʿ� ���� �ƴ� ��쿡 ����, �ƴϸ� ����
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
	�̵� ��Ģ
	1. ���� ��ġ�� û���Ѵ�. 
	2. ���� ��ġ���� ���� ������ �������� ���� ������� Ž���� �����Ѵ�. 
		a. ���� ���⿡ ���� û������ ���� ������ �ִٸ�, �� �������� ȸ���� �Ŀ� ���� �� ĭ���� �����ϰ� 1���� ����
		b. û���� ������ ���ٸ� �� �������� ȸ���� �ϰ� 2������ ���ư���. 
		c. ���� ��ġ���� �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ��� ������ ������ ä�� �����Ѵ�. 
		d. �� ���� ��� û�Ұ� �Ǿ� �ְų� ���̸鼭, ���� ������ ���̶� ���� �� �� ���� ��쿡 û�� ����
*/
