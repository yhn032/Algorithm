package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2667_단지번호 {
	//					   상 하  좌  우
	static int moveX[] = {-1, 1,  0,  0};
	static int moveY[] = { 0, 0, -1,  1};
	static boolean [][]visit;
	static int [][]danji;
	static int n;
	static int danjiNum=0;
	static int count=0;
	//같은 단지에 포함될 아파트의 개수를 저장할 배열 
	static int apart[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		danji = new int[n][n];
		
		visit = new boolean[n][n];
		apart = new int[n*n];
		
		//맵 초기화
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				danji[i][j] = str.charAt(j)-'0';
				if(danji[i][j] == 0) {
					visit[i][j] = true; //집이 없다면 미리 방문처리를 해둠으로써 이후에 방문 체크를 할때 연산식을 간편화 시킨다.
				}
			}
		}
		
		/*
		 * for(int i[] : danji) { for(int a : i) { System.out.print(a + " "); }
		 * System.out.println(); }
		 */
		
		//탐색 시작 
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visit[i][j]) {
					danjiNum++;
					count=0;
					bfs(i,j);
				}
			}
		}
		
		Arrays.sort(apart);
		sb.append(danjiNum).append('\n');
		
		for(int i : apart) {
			if(i==0) continue;
			sb.append(i).append('\n');
		}
		
		System.out.println(sb);
	}
	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		//여기서 부터 문제 이어서 풀어라!
		Queue<pos> q = new LinkedList<pos>();
		
		
		visit[x][y] = true;
		q.add(new pos(x, y));
		apart[danjiNum]++;//단지번호가 같은 아파트의 수를 세어준다. 
		
		while(!q.isEmpty()) {
			pos cur = q.poll();
			int curX = cur.x;
			int curY = cur.y;
			
			for(int i=0; i<4; i++) {//현재 위치에서 상하좌우로 움직여본다.
				int nextX = curX + moveX[i];
				int nextY = curY + moveY[i];
				
				//아직 방문하지 않았고, 인덱스가 벗어나지 않는 경우
				if( nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visit[nextX][nextY]) {
					visit[nextX][nextY] = true;
					q.add(new pos(nextX, nextY));
					apart[danjiNum]++;
				}
			}
			
		}
	}

}
class pos{
	int x;
	int y;
	
	
	public pos() {
		super();
	}


	public pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}

/*
	map -> 탐색 대상이 존재하는 전체 맵 
	visit -> 중복 방문 방지용 방문배열(boolean) 
	
	BFS(R){ -> R은 출발 노드 혹은 출발 지점
	
		Queue -> 방문할 노드를 저장할 큐를 생성. Enqueue하는 순간이 실제 방문이 아니라, 방문 해야할 노드의 리스트를 FIFO구조에 저장하는 것이다.
		visit[R] = true -> 시작 노드에 대해 방문 처리를 해준다. 기본적으로 방문 처리를 먼저 하고 큐에 enqueue한다. 
		Queue.add(R)    => 큐에 시작 노드를 인큐 한다. 
		
		
		while(!Queue.isEmpty()){ 큐에 더 이상 방문해야할 노드가 없을 때까지 아래의 과정을 반복한다.
			int a = q.poll()    -> 큐에서 가장 앞에 있는 노드를 꺼낸다. 이 시점이 실제로 노드를 방문하는 시점이라고 본다.
			
			조건  -> 문제에 따른 조건으로 한 번 필터링을 해준다. 
			
			if(!visit[a]){ 
				//아직 방문하지 않았다면 방문 처리를 해주고 인큐해주는 과정을 반복한다. 
				visit[a] = true;
				Queue.add(a);
			}
		}
	}
	
	
*/
