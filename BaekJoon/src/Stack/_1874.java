package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1874 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//수열을 이룰 숫자의 개수
		int n = Integer.parseInt(br.readLine());
		
		int [] stack = new int[n];
		int size = 0;//요소개수
		
		//스택에 오름차순으로 push되도록 가장 마지막에 push된 숫자를 기억하도록 하는 변수
		int nextInput = 0;
		//입력된 문자열의 순서는 pop해야할 순서이다. 
		//스택의 push되는 순서는 반드시 오름차순이어야 한다.
		//pop해야 하는 수보다 스택의 최상단의 수가 작다면, 다시 pop하고자하는 수까지 push하면 되지만, 
		//pop해야 하는 수보다 스택의 최상단의 수가 크다면, 오름차순으로 push해야 하는 순서가 오류. 즉 만들 수없는 수열이므로 NO를 출력
		
		
		while(n --> 0) {
			
			int value = Integer.parseInt(br.readLine());
			
			if(nextInput < value) {
				for(int i=nextInput+1 ; i<=value; i++) {
					stack[size]=i;
					size++;
					sb.append("+").append('\n');
				}
				nextInput = value;
			}
			else if (stack[size-1] != value){ //value보다 큰 경우
				System.out.println("NO");
				return;
			}
			size--;
			sb.append("-").append('\n');
		}
		System.out.println(sb);
	}
}

