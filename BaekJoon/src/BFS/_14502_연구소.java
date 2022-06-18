package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14502_연구소 {
	
	static int [][]map;			//원본 맵
	static int [][]copy;		//복사본
	static int [][]virus_map; 	//bfs용 맵
	static boolean [][]visit;
	static int n,m;
	static List<Virus> virus;
					  //상 하 좌 우
	static int dx[] = {-1, 1,  0, 0};
	static int dy[] = { 0, 0, -1, 1};
	static int max = 0; //안전지대 영역 수는 음수가 나올 수 없음
	
	static class Virus{
		int x, y;
		public Virus() {
			super();
		}
		public Virus(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st=  new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map  = new int[n][m];
		copy = new int[n][m]; //원본 상태를 유지하기 위해 복사본을 만들어서 이 배열에 벽을 세운다.
		virus = new ArrayList<Virus>(); //바이러스의 위치를 저장할 리스트
		
		
		//map과 복사본 초기화
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0; k<m;k++) {
				copy[i][k] = map[i][k] = Integer.parseInt(st.nextToken());
				if(map[i][k] == 2) {
					virus.add(new Virus(i, k));//바이러스의 위치를 모두 담아준다.
				}
			}
		}
		
		//재귀를 진행하면서 벽을 세워보자.
		for(int i=0; i<n; i++) {
			for(int k=0; k<m; k++) {
				if(map[i][k]==0) {//아직 벽이 없다면,,,
					copy[i][k] = 1;
					dfs(1);
					copy[i][k] = 0; //재귀가 끝나서 돌아오면 다른 경우의 수를 위해서 벽을 부숴준다.
					
				}
			}
		}
		
		System.out.println(max);
		
	}
	
	private static void dfs(int wall) {
		// TODO Auto-generated method stub
		if(wall == 3) {
			//3개의 벽을 모두 만든경우 bfs탐색을 시작해보자
			bfs();
			return;
		}
		
		//나머지 2개의 벽을 더 세운다. 순열을 구하는 알고리즘을 응용한다.
		for(int i=0; i<n; i++) {
			for(int k=0; k<m; k++) {
				if(copy[i][k]==0) {//아직 벽이 없다면,,,
					copy[i][k] = 1;
					dfs(wall+1);
					copy[i][k] = 0; //재귀가 끝나서 돌아오면 다른 경우의 수를 위해서 벽을 부숴준다.
					
				}
			}
		}
		
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		//방문배열을 초기화해줄 것 없이 bfs를 시작할때마다 새로 만들기
		visit = new boolean[n][m];
		Queue<Virus> q = new LinkedList<>();
		
		//이를 메인에서 정의하면 bfs를 돌때마다 새롭게 초기화를 해주어야 하므로 그냥 여기서 정의한다.
		virus_map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				virus_map[i][j] = copy[i][j];
			}
		}
		
		//값을 입력받을 때, 저장한 바이러스의 위치를 큐에 저장한다. 이건 토마토랑 같은 방식으로 탐색하면 될 듯
		for(int i=0; i<virus.size(); i++) {
			Virus v = virus.get(i);
			visit[v.x][v.y] = true;
			q.add(new Virus(v.x, v.y));
		}
		
		while(!q.isEmpty()) {
			Virus now = q.poll();
			
			for(int i=0; i<4; i++) {
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];
				
				if(xx < 0 || yy < 0 || xx >= n || yy >= m ) continue;
				if(visit[xx][yy]) continue;
				
				if(virus_map[xx][yy] == 0) {//벽이 아니라면
					visit[xx][yy] = true;
					virus_map[xx][yy] = 2;
					q.add(new Virus(xx, yy));
				}
			}
		}
		
		countSafeArea();
	}

	private static void countSafeArea() {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i=0; i<n;i++) {
			for(int j=0; j<m; j++) {
				if(virus_map[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		max = Math.max(max, cnt);
	}

}

/*
 	벽을 세울 위치 세군데를 탐색해야- 한다. 
 	안전지대의 최댓값 -> 바이러스가 최소로 퍼지게 막아야 한다.
 	벽을 세울 곳은 DFS로 순열을 구하는 경우의수로 세워보고 
 	그 때마다 바이러스가 퍼지는 탐색과정은 BFS로 하는 것이 좋을 듯
*/
