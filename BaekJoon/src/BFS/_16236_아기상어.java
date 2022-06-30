package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16236_아기상어 {
	static int n;							//map의 크기
	static int eatCnt = 0;					//아기상어가 먹은 물고기 수
	static int minX, minY, minDist;			//현재 위치에서 이동할 수 있는 최소거리, 그때의 x,y좌표
	static int map[][];						//탐색을 진행할 map
	static int dist[][];					//방문 체크 겸 최단 거리 저장 배열
	static int dx[] = {-1, 1,  0, 0};		//상하좌우 이동(x)
	static int dy[] = { 0, 0, -1, 1};		//상하좌우 이동(y)
	static int count=0;						//아기 상어의 전체 이동 시간
	static int size = 2;					//초기 아기 상어의 크기
	static int INF = Integer.MAX_VALUE;	//최솟값을 찾기 위한 초깃값
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int sharkX = 0;
		int sharkY = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {//아기 상어의 위치
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}
			}
		}
		
		int time = eatFish(sharkX, sharkY);
		
		System.out.println(time);
		
	}
	private static int eatFish(int sharkX, int sharkY) {
		// TODO Auto-generated method stub
		while(true) {
			//방문체크겸 거리배열
			dist = new int[n][n];
			minX = INF;
			minY = INF;
			minDist = INF;
			
			//탐색하면서 거리배열 최신화
			bfs(sharkX, sharkY);
			
			if(minX != INF && minY != INF) {//값이 갱신되었다면 -> 먹을 수 있는 물고기를 찾았다면
				eatCnt++;
				map[minX][minY] = 0;
				sharkX = minX;
				sharkY = minY;
				count += minDist;
				
				if(eatCnt == size) {
					size++;
					eatCnt = 0;
				}
			}else {//값이 갱신되지 않았다면 -> 먹을 수 있는 물고기를 찾지 못했다면
				return count;
			}
		}
	}
	
	private static void bfs(int sharkX, int sharkY) {
		// TODO Auto-generated method stub
		Queue<position> q = new LinkedList<position>();
		q.add(new position(sharkX, sharkY));
		
		while(!q.isEmpty()) {
			position now = q.poll();
			
			for(int i=0; i<4; i++) {
				int xx = now.x + dx[i];
				int yy = now.y + dy[i];
				
				
				//배열 범위 밖이면 skip, 물고기가 상어보다 크거나, 이미 최단거리가 표시되어 있으면 skip
				if(xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
				if(map[xx][yy] > size || dist[xx][yy] != 0) continue; 
				
				dist[xx][yy] = dist[now.x][now.y] + 1;
				
				if(map[xx][yy] != 0 && map[xx][yy] < size) {//먹을 수 있는 물고기라면
					
					if(minDist > dist[xx][yy]) {//가장 가까운 거리라면(현재의 최단거리 보다 작다면)
						minDist = dist[xx][yy];
						minX = xx;
						minY = yy;
						
					}else if(minDist == dist[xx][yy]) {//현재 최단거리와 거리가 동일하다면 -> 거리가 가까운 물고기가 여러마리라면,
						if(minX == xx) {//가장 위에 있는 물고기가 우선순위가 높은데 이 것도 여러마리라면 가장 왼쪽에 있는 물고기가 우선. -> 값이 더 작을수록 왼쪽에 있다.
							if(minY > yy) {
								minX = xx;
								minY = yy;
							}
						}else if(minX > xx) {//가장 위에 있는 물고기가 우선 순위가 높다.
							minX = xx;
							minY = yy;
						}
					}
					
				}
				q.add(new position(xx, yy));
			}
		}
	}
}

class position{
	int x, y;
	public position(int x, int y) {
		this.x = x; 
		this.y = y;
	}
}
/*
	더 작은 크기의 물고기만 먹을 수 있다. 
	같은 크기의 물고기는 지날 수 만 있다. 
	더 큰 크기의 물고기는 지날 수 없다. 
	자신의 크기만큼의 물고리를 먹어야 크기가 증가한다. 3인 경우 3마리를 먹어야 크기 업
	엄마에게 도움없이 얼마의 시간동안 움직일 수 있는가? 
*/
