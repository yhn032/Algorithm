package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _11729 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//ž�� ����
		int N = Integer.parseInt(br.readLine());
		
		
		sb.append((long)(Math.pow(2, N)-1)).append('\n');
		
		hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}
	private static void hanoi(int n, int from, int mid, int to) {
		// TODO Auto-generated method stub
		if(n==1) {
			sb.append(from + " " + to + "\n");
			return;
		}
		
		//n-1���� ������ from���� mid�� �̵� 
		hanoi(n-1, from, to, mid);
		
		//1���� from���� to�� �̵�
		sb.append(from + " " + to + "\n");
		
		//n-1���� ������ mid���� to�� �̵�
		hanoi(n-1, mid, from, to);
	}

}
