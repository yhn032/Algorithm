package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16236_babyShark {
							//��   ��   ��   ��
	static int move_x[] =   {-1,  1,   0,  0};
	static int move_y[] =   { 0,   0, -1,  1};
	static int shark_x;
	static int shark_y;
	/*
	  	���� �ڽź��� ���� ����⸸ ���� �� �ִ�. 
	  		���� �� �ִ� ����Ⱑ 1�������, �� ����⸦ ������ ����. 
	  		���� �� �ִ� ����Ⱑ �����������, ����� ������ ����. 
	  		���� �Ÿ��� ���� �� �ִ� ����Ⱑ ����������� ������ ������ �켱������ ����. 
	  		�ڽ��� ũ��� ��ŭ�� ����⸦ ������ ����� ũ��� 1�����Ѵ�.
	  	���� �ڽŰ� ���� ũ���� ������ ������ �� �� �ִ�.
	  	�� ���� �� �ִ� ����Ⱑ ������ ������ �θ��� ������.
	  	
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[][] board = new int[N][N];
		
		//�� �ʱ�ȭ
		for(int i=0; i<N; i++) {
			for(int k=0; k<N; k++){
				board[i][k] = Integer.parseInt(st.nextToken());
				if(board[i][k] == 9) {//����� �ʱ���ġ
					shark_x = i;
					shark_y = k;
					board[i][k] = 0; //���� ���̸� ã�� �̵��� ���̱� ������ �� �ִ� �ڸ��� 0���� �д�.
				}
			}
		}
		
		while(true) {
			bfs(shark_x, shark_y);
		}
		
		
	}

	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<Pos> q = new LinkedList<>();
		
		int xx=0;
		int yy=0;
		
		while(!q.isEmpty()) {
			//������ġ���� �����¿� Ž��
			for(int i=0; i< 4; i++) {
				xx = x + move_x[i];
				yy = y + move_y[i];
			}
			if(xx < 0 && yy < 0) {
				continue;
			}
		}
	}
	
	public static class Pos {
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = x;
		}
	}
}
