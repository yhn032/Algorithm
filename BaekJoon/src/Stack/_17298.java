package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _17298 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//수열의 크기
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		int sequence[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//숫자가 입력되어 있다.
		for(int i=0; i<N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			//각 원소마다 비교를 해주고 
			//현재 원소가 스택 맨 위를 가리키는 원소보다 큰 경우 
			//현재 원소보다 큰 값이 없다는 뜻이므로, 
			//현재 스택에 있는 원소를 pop하면서 해당 인덱스의 값을 현재 원소로 바꿔준다. 
			while(!stack.empty() && sequence[stack.peek()] < sequence[i]) {
				//최상단에 있는 인덱스값을 삭제하고 가져와서 그 인덱스에 해당하는 값에 
				sequence[stack.pop()] = sequence[i];
			}
			stack.push(i);
		}
		//위에서 조치하고도 남은 인덱스는 자신보다 큰 것이 없는 숫자들로 모두 -1을 반환해준다. 
		while(!stack.empty()) {
			sequence[stack.pop()] = -1; //스택 최상단을 삭제하고 그 인덱스에 저장된 값에 -1을 넣는다
		}
		for(int i=0; i<N; i++) {
			sb.append(sequence[i]).append(' ');
		}
		System.out.println(sb);
	}

}
