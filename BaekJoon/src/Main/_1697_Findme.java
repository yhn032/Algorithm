package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_Findme {
	static int[] time = new int[100001];
	static int N;
	static int K;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//수빈이의 위치
		N = Integer.parseInt(st.nextToken());
		//동생의 위치
		K = Integer.parseInt(st.nextToken());
		
		if(N==K) {
			System.out.println(0);
		}
		else {
			bfs(N);
		}
	}

	private static void bfs(int n) {
		// TODO Auto-generated method stub
		//너비우선탐색의 경우 탐색순서를 지정해줄 큐 생성
		Queue<Integer> q = new LinkedList<>();
		//시작위치(수빈이의 위치)를 큐에 넣는다.
		q.add(n);
		time[n] = 1; //시간이 1초 지날때마다 값을 1씩 증가시켜서 수빈이가 동생을 만났을때, 시간을 체크해준다.

		
		while(!q.isEmpty()) {
			//큐에 있는 내용을 하나씩 꺼내서 탐색을 시작할 거다.
			int temp = q.poll();
			
			for(int i=0; i<3; i++) {
				int next = 0;
				
				if(i==0) {//오른쪽으로 이동하는 경우일 때, 탐색이 필요한 인덱스
					next = temp + 1;
				} else if(i==1) {//왼쪽으로 이동하는 경우일 때, 탐색이 필요한 인덱스
					next = temp - 1;
				} else {//순간이동하는 경우일 때, 탐색이 필요한 인덱스
					next = temp * 2;
				}
				//찾았다면 출력하고 종료
				if(next==K) {
					System.out.println(time[temp]);
					return;
				}
				
				//배열안에 있는데 아직 탐색하지 않은 곳이라면 탐색 대상이므로 큐에 추가한다.
				//탐색한 위치에 경과된 시간을 현재 위치에서 경과되었던 시간에서 +1한다.
				if(next >= 0 && next < time.length && time[next] == 0) {
					q.add(next);
					//탐색위치 시간 = 이전 위치 시간 + 1 -> 1초가 경과해서 탐색한 곳에 흔적을 남겨주는 것
					time[next] = time[temp] + 1;
				}
			}
			
		}
	}

}
