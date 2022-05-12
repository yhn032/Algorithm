package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16236_babyShark {
							//상   하   좌   우
	static int move_x[] =   {-1,  1,   0,  0};
	static int move_y[] =   { 0,   0, -1,  1};
	static int shark_x;
	static int shark_y;
	/*
	  	상어는 자신보다 작은 물고기만 먹을 수 있다. 
	  		먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다. 
	  		먹을 수 있는 물고기가 여러마리라면, 가까운 곳으로 간다. 
	  		같은 거리상에 먹을 수 있는 물고기가 여러마리라면 가장위 왼쪽을 우선적으로 간다. 
	  		자신의 크기수 만큼의 물고기를 먹으면 상어의 크기는 1증가한다.
	  	상어는 자신과 같은 크기의 물고기는 지나만 갈 수 있다.
	  	상어가 먹을 수 있는 물고기가 없으면 엄마를 부르고 끝낸다.
	  	
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[][] board = new int[N][N];
		
		//맵 초기화
		for(int i=0; i<N; i++) {
			for(int k=0; k<N; k++){
				board[i][k] = Integer.parseInt(st.nextToken());
				if(board[i][k] == 9) {//상어의 초기위치
					shark_x = i;
					shark_y = k;
					board[i][k] = 0; //상어는 먹이를 찾아 이동할 것이기 때문에 상어가 있던 자리는 0으로 둔다.
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
			//현재위치에서 상하좌우 탐색
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
