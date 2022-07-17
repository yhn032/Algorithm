package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _16235_나무재테크 {
	static int dx[] = {-1, -1, 0, 1, 1,  1,  0, -1};
	static int dy[] = { 0,  1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	//상도의 땅(n*n)의 크기 인덱스는 1부터 시작한다!
		int m = Integer.parseInt(st.nextToken());	//상도가 심은 나무의 개수.
		int k = Integer.parseInt(st.nextToken());	//k년 후 살아있는 나무의 수를 구하기 위한 정보
		
		//매년 겨울 땅에 추가되는 양분의 양
		int A[][] = new int[n+1][n+1]; 
		//각 위치에 있는 양분을 기억할 배열 
		int TREE[][] = new int[n+1][n+1];
				
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(TREE[i], 5);
			for(int j=1; j<=n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//정렬한 내용으로 큐를 만든다. 하나 씩 꺼내서 검사하고 죽은 건 그대로 삭제, 나이가 늘어난 것은 늘리고 다시 맨 뒤로 삽입
		LinkedList<tree> q = new LinkedList<>();
		LinkedList<tree> deadTree = new LinkedList<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x   = Integer.parseInt(st.nextToken());
			int y   = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			q.add(new tree(x, y, age));
		}
		
		int year = 0;

		//각 위치에 나무의 여부, 나무의 나이, 나무의 양분을 저장해야 하는데,,,
		while(true) {
			if(year == k) break;
			
			Iterator<tree> iterator = q.iterator();
			//봄(먹을 수 있는 놈들은 다 먹고, 못 먹는 애들은 다 죽어)
			while(iterator.hasNext()) {
				
				tree t = iterator.next();
				int r = t.x;
				int c = t.y;
				int age = t.age;
				
				if(TREE[r][c] < age) {//자신의 나이만큼 양분을 먹을 수 없는 경우
					
					//큐에서 꺼내고 다시 안넣으면 삭제하는 것과 같은 효과
					deadTree.offer(t);
					
					//LinkedList에서 iterator를 통한 remove는 O(1)의 시간복잡도를 가진다!
					iterator.remove();
					
				}else {//양분을 충분히 먹을 수 있다면
					
					//먹은 양분 만큼 삭제하기
					TREE[r][c] -= age;
					
					//나이증가시키기
					t.age += 1;
				}
			}
			
			//여름(봄에 죽은 나무가 양분으로 변할 시기)
			while(!deadTree.isEmpty()) {
				tree t = deadTree.poll();
				
				TREE[t.x][t.y] += t.age/2;
			}
			
			//가을(나무의 나이가 5의 배수인 것만 번식을 한다.)
			LinkedList<tree> babyTrees = new LinkedList<>();
			for(tree tree : q){
				int r = tree.x;
				int c = tree.y;
				if(tree.age % 5 == 0) {
					//번식가능한 경우8방을 다 훑어본다.
					for(int j=0; j<8; j++) {
						int xx = r + dx[j];
						int yy = c + dy[j];
						
						if(xx < 1 || yy < 1 || xx > n || yy > n) continue;
						babyTrees.add(new tree(xx, yy, 1));
					}
					//정렬 순서에 맞도록 age가 가장 큰 기존 나무는 마지막에 넣는다. 
				}
				
				continue;
			}
			q.addAll(0, babyTrees);
			
			//겨울(양분 추가)
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					TREE[i][j] += A[i][j];
				}
			}
			
			year++;
		}
		
		System.out.println(q.size());
		
		/*
			1년 주기(입력으로 주어지는 나무의 초기 위치는 모두 다르지만 번식을 통해 같은 영역에 여러 그루의 나무 존재 가능)
			봄 	 : 자신의 나이만큼 양분을 먹고 나이가 1 증가. 자신의 영역 안에 있는 양분만 먹을 수 있음. 나이 어린 나무 먼저. 자신의 나이만큼 양분을 못먹으면 양분을 먹지 못하고 즉사
			여름 : 봄에 죽은 나무의 나이/2 만큼이 양분으로 추가된다.(소수점 버림)
			가을 : 나이가 5의 배수인 나무만 가을에 번식 가능하다. 
			겨울 : S2D2각 모든 땅을 돌아다니면서 땅에 양분을 추가한다. 추가하는 양분은 배열 A에 저장되어 있음.
		*/
	}

}

class tree {
	int x, y, age;

	public tree(int x, int y, int age) {
		super();
		this.x = x;
		this.y = y;
		this.age = age;
	}
}

