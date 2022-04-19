package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10828 {
		// TODO Auto-generated method stub
		public static int[] stack;
		public static int size = 0;
		
		
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			
			StringTokenizer st;
			
			//��ɾ� ���� �Է¹ޱ�
			int N = Integer.parseInt(br.readLine());
			
			//�Է¹��� ��ɾ� ������ ���� ������ ���� ���û���(��� ������Ʈ ��ü�� �������� ��)
			stack = new int[N];
			
			
			while(N > 0) {
				//������ �������� ���ڿ� �и�
				st = new StringTokenizer(br.readLine());

				switch(st.nextToken()) {
				case "push":
					push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					sb.append(pop()).append('\n');
					break;
				case "size":
					sb.append(size()).append('\n');
					break;
				case "empty":
					sb.append(empty()).append('\n');;
					break;
				case "top":
					sb.append(top()).append('\n');
					break;
				}
				N--;
			}//end-while
			System.out.println(sb);
		}

		private static int pop() {
			// TODO Auto-generated method stub
			if(size ==0) {
				return -1;
			}else {
				int res = stack[size-1];
				stack[size-1] = 0;
				size--;
				return res;
			}
			
		}

		private static int empty() {
			// TODO Auto-generated method stub
			if(size ==0) {
				return 1;
			}else {
				return 0;
			}
		}

		private static int size() {
			// TODO Auto-generated method stub
			return size;
		}

		private static int top() {
			// TODO Auto-generated method stub
			if(size ==0) {
				return -1;
			} else {
				return stack[size-1];
			}
			
		}

		private static void push(int k) {
			// TODO Auto-generated method stub
			stack[size] = k;
			size++;
		}
}
