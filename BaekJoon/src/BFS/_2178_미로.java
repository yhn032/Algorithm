package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_미로 {
	static int N, M;
	static boolean visited[][];
	//				   하 우  상  좌
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	static int map[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int k=0; k<M; k++) {
				map[i][k] = str.charAt(k)-'0';
			}
		}
		
		/*
		 * for(int i=0; i<N; i++) { for(int k=0; k<M; k++) { System.out.print(map[i][k]
		 * + " "); } System.out.println(); }
		 */
		
		
		BFS(0,0);//원점부터 탐색 시작
		
		System.out.println(map[N-1][M-1]);
		
	}
	private static void BFS(int i, int j) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<>(); //방문하는 곳의 x,y인덱스 값을 저장한다.
		q.add(new int[] {i, j});
		
		//인접한 방문 가능한 인덱스를 추가하다가 큐가 빌때까지 반복 한번의 반복마다(깊이) 방문하는 곳에 값을 반복횟수로 초기화 해줄거다.
		//어차피 방문한 곳은 다시 방문하지 않으려고 방문 배열을 만들기 때문에 초기에 조건 검사할때만 1이면 됨 -> 결과적으로는 몇번째 방문에서 해당 노드를 탐색했는지 기록하고자 함이고 
		//시작점을 포함해서 카운트하라고 했는데, 본의아니게 이동할 수 있는 지점이 1로 세팅되어 있기 때문에 그냥 +1만 해주면 됨
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			visited[i][j] = true;
			for(int k=0; k<4;k++) {//상하좌우에서 이동할 수 있는 경로 탐색
				int x = cur[0] + dx[k];
				int y = cur[1] + dy[k];
				
				if(x >= 0 && y >= 0 && x < N && y < M) { //좌표를 벗어나지 않는다면, 
					if(map[x][y] == 1 && !visited[x][y]) {
						visited[x][y] = true;
						map[x][y] = map[cur[0]][cur[1]] + 1; //이동 횟수를 나타내기 위해 현재 위치의 값에서 +1 해준다.
						q.add(new int[] {x, y});
					}
					
				}
			}
		}
	}

}

