import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean visited[][];
	static int area[][];
	static int max = 0;
	static int cnt = 0;
	static int N = 0;
	
	//                 상  하   좌  우
	static int dx[] = {-1, 1,  0, 0};
	static int dy[] = { 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		area = new int[N][N];
		visited = new boolean[N][N];
		List<Integer> height = new ArrayList<Integer>();
		
		//영역과 높이 리스트 초기화
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				if(!height.contains(area[i][j])) height.add(area[i][j]);
			}
		}
		
		
		
		for(int i=0; i<height.size(); i++) {
			int tempHeight = height.get(i);
			visited = new boolean[N][N];
			cnt=0;
			for(int n=0; n<N; n++) {
				for(int m=0; m<N; m++) {
					safe s = new safe(n, m);
					if(area[n][m] <= tempHeight) continue;
					if(!visited[n][m]) BFS(s, tempHeight);
					max = max<cnt ? cnt : max;
				}
			}
		}
		
		max = max==0 ? 1 : max;
		System.out.println(max);
	}

	private static void BFS(safe s, int height) {
		// TODO Auto-generated method stub
		Queue<safe> q = new LinkedList<safe>();
		q.add(s);
		visited[s.x][s.y] = true; 
		
		while(!q.isEmpty()) {
			safe now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				if(area[nextX][nextY] <= height || visited[nextX][nextY]) continue;
				
				safe next = new safe(nextX, nextY);
				q.add(next);
				visited[next.x][next.y] = true; 
			}
			
			
		}
		
		cnt++;
	}
}

class safe {
	int x;
	int y;
	
	public safe(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
