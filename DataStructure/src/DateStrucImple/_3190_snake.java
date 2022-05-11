package DateStrucImple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class _3190_snake {
	static int N, K, X, L, d=0;
	static String C;
	static Map<Integer, String> move;
	static int map[][];
	//   				R  D   L   U
	static int dx[] = {1, 0, -1,  0};
	static int dy[] = {0, 1,  0, -1};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//입력받기 
		//보드의 크기
		N = Integer.parseInt(br.readLine());
		
		//사과의 개수
		K = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		move = new HashMap<Integer, String>();
		
		//사과의 위치 초기화 하기
		//시작위치를 문제에서는 1행 1열이라고 했지만, 나는 0,0에 넣을 것이기 때문에 
		//인덱스를 맞춰주기 위해서 입력받은 사과의 위치또한 -1하여 배열의 인덱스에 맞도록 설정한다.
		for(int i=0; i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			//사과는 1로 표시. 시작지점에는 사과가 존재할 수 없음
			map[a][b] = 1;
		}
		
		//방향전환정보의 개수
		L = Integer.parseInt(br.readLine());
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine()); 
			//시간 정보
			X = Integer.parseInt(st.nextToken());
			//방향 정보 D(right), L(left)
			C = st.nextToken();
			move.put(X, C);
		}
		
		Dummy();
	}

	private static void Dummy() {
		// TODO Auto-generated method stub
		Deque<Integer> dq = new LinkedList<Integer>(); 
		//데큐를 사용하면서 먹이가 있으면 새로운 위치를 큐의 넣으면서 길이 증가
		//먹이가 없으면 큐의 요소를 출력해서 길이 감소
		//큐의 길이 size가 뱀의 길이가 된다. front꼬리; rear머리;
		
		dq.add(0);//꼬리이자 머리
		int time = 0; 
		int snake_x = 0;
		int snake_y = 0;
		
		//종료조건에 부합할 때까지 무한 반복(탈출조건을 지정해야 한다.)
		while(true) {
			time++; //타임 증가
			int xx = snake_x + dx[d];
			int yy = snake_y + dy[d];
			
			
			//벽에 부딪힌 경우 종료
			if(xx > N-1 || yy > N-1 || xx < 0 || yy < 0) {
				break;
			}
			
			//자신의 몸통에 부딪힌 경우 종료 ny*n + nx
			if(dq.contains(yy*N + xx)) {
				break;
			}
			
			//위의 종료 조건을 만족하지 않는다면 뱀을 이동시키자.
			if(map[yy][xx] == 1) {//사과가 존재하는 경우 길이증가 -> 사과의 위치를 머리로 추가하기 
				map[yy][xx] = 0;//먹었으니 0으로 초기화
				//각 배열의 요소에 번호값을 붙여서 그 번호를 큐에 넣고 
				//큐에 존재하는 번호는 뱀의 길이가 존재하는 영역이다.
				dq.add(yy*N + xx);
			} else { //사과가 없는 경우 꼬리를 자르고 머리만 이동.
				dq.add(yy*N + xx);
				dq.poll();
			}
			
			//방향 이동의 경우의수
			//현재 시간이 방향 전환 경우의 수중 하나라면
			if(move.containsKey(time)){
				String data = move.get(time);
				if(data.equals("D")) {
					d += 1;
					if(d == 4) d = 0;
				}else {
					d -= 1;
					if(d ==-1) d = 3;
				}
				
			}
			
			//현재 위치를 다음 이동에 대한 초기위치로 지정
			snake_x = xx;
			snake_y = yy;
			
		}
		System.out.println(time);
		
	}

}
