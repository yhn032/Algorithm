package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11725_ParentNode {
	static ArrayList<Integer> tree[];
	static boolean check[];
	static int answer[];
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		//보편적으로 배열의 크기를 +1해서 0번지는 안쓰고 1번지부터 씁니다.
		check = new boolean[N+1];
		tree = new ArrayList[N+1]; //->어레이리스트로 2차원배열 만들기
		answer = new int[N+1];
		
		//인접리스트 구성
		for(int i=0; i<tree.length;i++) {
			tree[i] = new ArrayList<>();
		}
		
		//인접리스트 초기화(실데이터는 1부터) 
		for(int i=1; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			//양방향으로 모두 에지연결을 표현
			tree[n1].add(n2);
			tree[n2].add(n1);
		}
		
		//1번이 루트라고 했으니 깊이우선 탐색 시작
		DFS(1);
		for(int i=2; i<=N;i++) {
			System.out.println(answer[i]);
		}
	}


	private static void DFS(int i) {
		// TODO Auto-generated method stub
		//방문체크
		check[i] = true;
		
		//리스트의 1번지 저장소, 즉 1번 노드와 연결된 노드를 탐색합니다. 
		for(int k : tree[i]) {
			if(!check[k]) {
				//6번지 인덱스에 현재 출발점(부모노드 번호)를 넣습니다.
				answer[k] = i;
				//6번노드에서 다시 DFS
				DFS(k);
			}
		}
	}

}
