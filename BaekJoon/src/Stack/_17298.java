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
		
		//������ ũ��
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		int sequence[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//���ڰ� �ԷµǾ� �ִ�.
		for(int i=0; i<N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			//�� ���Ҹ��� �񱳸� ���ְ� 
			//���� ���Ұ� ���� �� ���� ����Ű�� ���Һ��� ū ��� 
			//���� ���Һ��� ū ���� ���ٴ� ���̹Ƿ�, 
			//���� ���ÿ� �ִ� ���Ҹ� pop�ϸ鼭 �ش� �ε����� ���� ���� ���ҷ� �ٲ��ش�. 
			while(!stack.empty() && sequence[stack.peek()] < sequence[i]) {
				//�ֻ�ܿ� �ִ� �ε������� �����ϰ� �����ͼ� �� �ε����� �ش��ϴ� ���� 
				sequence[stack.pop()] = sequence[i];
			}
			stack.push(i);
		}
		//������ ��ġ�ϰ� ���� �ε����� �ڽź��� ū ���� ���� ���ڵ�� ��� -1�� ��ȯ���ش�. 
		while(!stack.empty()) {
			sequence[stack.pop()] = -1; //���� �ֻ���� �����ϰ� �� �ε����� ����� ���� -1�� �ִ´�
		}
		for(int i=0; i<N; i++) {
			sb.append(sequence[i]).append(' ');
		}
		System.out.println(sb);
	}

}
