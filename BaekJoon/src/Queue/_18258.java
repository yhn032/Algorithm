package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// O(1)이려면,,, 탐색은 사용x, 하나의 입력값에 대해 1번의 연산만 수행해야한다.
		int N = Integer.parseInt(br.readLine());
		int q[] = new int[N];
		int size = 0;	//큐에 저장된 요소의 개수
		int front =0;	//큐에서 데이터가 나가는 부분
		int rear = 0;	//큐에 데이터가 들어오는 부분
		
		while(N --> 0) {
			st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
			case "push":
				q[rear] = Integer.parseInt(st.nextToken());
				rear++;
				size++;
				break;
			case "pop":
				if(size == 0) 
					sb.append(-1).append('\n');
				
				else {
					sb.append(q[front]).append('\n');
					size--;
					front++;
				}
				break;
			case "size":
				sb.append(size).append('\n');
				break;
			case "empty":
				if(size==0)
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
				break;
			case "front":
				if(size == 0) 
					sb.append(-1).append('\n');
				
				else {
					sb.append(q[front]).append('\n');
				}
				break;
			case "back":
				if(size == 0) 
					sb.append(-1).append('\n');
				
				else {
					sb.append(q[rear-1]).append('\n');
				}
				break;	
			}//end-switch
		}//end-while
		System.out.println(sb);
	}

}
