package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _11003_�ּڰ�ã�� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		Deque<Node4> dq = new LinkedList<>();
		for(int i=0; i< N; i++) {
			//���ο� ���� ���� ������, ������ �������� ũ�� �񱳸� �ϸ鼭 ���� ������ ū ���� ������ �����ϸ鼭 �ðǺ��⵵ ���̱� 
			
			int now = Integer.parseInt(st.nextToken());
			
			//���� ������� �ʰų� ���� ���� ��������(�ִ밪��) ���� �������� ������ ũ�ٸ� �������� �ִ� ���� ������ �����Ѵ�.
			//�ݺ����� ����ؼ� ��� �����ϴ� ������, ���� ������ ������ ���� ���� ����� ū���� ��� ����鼭 �������� ����ȿ���� ���� �����̴�.
			while(!dq.isEmpty()&& dq.getLast().value > now) {
				dq.removeLast();
			}
			
			dq.addLast(new Node4(now, i));
			
			//�������� ũ�⿡�� ��� �ε����� �����Ѵ�. 
			if(dq.getFirst().index <= i-L) {
				dq.removeFirst();
			}
			
			//���� ���� �� �κ��� �ּڰ��̴�.
			sb.append(dq.getFirst().value).append(' ');
		}
		
		System.out.println(sb);
		
	}

	static class Node4 {
		int value;
		int index;
		
		Node4(int value, int index){
			this.value = value;
			this.index = index;
		}
	}
}


