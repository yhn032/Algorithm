package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class _5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//전체 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		
		OUT:
		while(T--> 0) {
			ArrayDeque<Integer> q = new ArrayDeque<Integer>();
			//true이면 front가 맨 오른쪽 pollLast, false이면 front가 맨 왼쪽 pollFirst
			boolean reverse = false;
			
			//수행할 함수
			String p = br.readLine();
			//배열의 요소 개수
			int n = Integer.parseInt(br.readLine()); 
			
			//배열에 들어갈 정수
			String temp = br.readLine();
			String temp2 = temp.substring(1, temp.length()-1);
			String data[] = temp2.split(",");

			for(int i=0; i<n; i++) {
				q.offer(Integer.parseInt(data[i]));
			}
			/*
			 * for(Integer i : q) { System.out.println(i); }
			 */
			


			//R 명령일때는 방향전환, D명령일때는 에러처리만 수행
			for(int i =0; i < p.length(); i++) {
				
				//데이터를 뒤집어야 하는 상황이 온다면
				if(p.charAt(i) == 'R') {
					//reverse를 false -> true로 toggle
					reverse = !reverse;
					continue;
				}
				
				//명령이 D일때, 삭제 하기 전 사전 작업(에러처리)
				//역방향
				if(reverse) {
					//여기서 일단 명령이 D라면 null검사를 하기위해 값을 뺀다. 그러니까 뒤에서 또 값을 빼면 D연산을 두번 하게 되는거임
					if(q.pollLast() == null) {//큐에 요소가 없으면..에러내라
						sb.append("error\n");
						continue OUT; //에러를 출력하고 해당 반복을 종료시켜버리기 -> 다음 테스트 케이스 진행하기
					} 
				//정방향
				}else {
					if(q.pollFirst() == null) {
						sb.append("error\n");
						continue OUT; //에러를 출력하고 해당 반복을 종료시켜버리기
					} 
				}
			}//end-for
			//위의 반복문에서 모든 명령을 탐색했다. R이 나올때마다 방향을 토글로 전환해주었기 때문에, 방향은 정해졌고, 이제 D명령만 수행하면 됩니다.
			//위의 조건을 모두 통과하면, 에러처리를 지나왔고, 배열 뒤집는 순서까지 진행되어 입출력 방향을 정했으니 출력만 하면 된다. 
			sb.append('[');
			if(q.size()>0) {
				//역방향
				if(reverse) {
					sb.append(q.pollLast());
					while(!q.isEmpty()) {
						sb.append(',').append(q.pollLast());
					}
				}else {//정방향
					sb.append(q.pollFirst());
					while(!q.isEmpty()) {
						sb.append(',').append(q.pollFirst());
					}
				}
			}
			sb.append(']').append('\n');
			
		}//end-while	
		
		System.out.println(sb);

		
	}
}


/*

*/
