package DynamicProgamming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9184_�ų�������Լ� {
	static int w[][][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		//�������� �Է������� 50������ �ϳ��� 21�� �Ѿ�� ������ w(20, 20, 20)�� ��ȯ�ϱ� ������ ����� �ʿ䰡 ����.
		w = new int[21][21][21];
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==-1 && b== -1 && c ==-1) break;
			
			//ã���� �ϴ� ���� ���� �ȿ� �ְ�, DP���̺� �ִٸ� �������� ���ٸ� ��͸� ���� ���� �����Ѵ�.
			sb.append(String.format("w(%d, %d, %d) = %d", a, b, c, w(a,b,c))).append('\n');
		}
		
		System.out.println(sb);
		
	}

	private static int w(int a, int b, int c) {
		// TODO Auto-generated method stub
		
		//���� �ȿ� �ְ�, 
		if(isInner(a,b,c) && w[a][b][c] != 0 )
			return w[a][b][c];
		
		if(a <= 0 || b <=0 || c<=0 ) {
			return 1;
		}
		
		if(a>20 || b>20 || c>20) {
			w[20][20][20] = w(20, 20, 20);
			return w[20][20][20];
		}
		
		if(a < b && b < c) {
			w[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a, b-1, c);
			return w[a][b][c];
		}
		
		w[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
		return w[a][b][c];
	}

	private static boolean isInner(int a, int b, int c) {
		// TODO Auto-generated method stub
		
		if(a >= 0 && a <= 20 && b >=0 && b <= 20 && c>=0 && c<=20) {
			return true;
		}else {
			return false;
		}
	}

}

/*
	������ ���õ� ����Լ��� ���� 
	1. �� �� �ϳ� �̻���  0���� -> return 1
	2. �� �� �ϳ� �̻��� 20�ʰ� -> return w(20,20,20) ���� 20 �̻��� ���� ������ �ʿ� ���� �ٷ� w(20, 20,20)���� �´�. 
	3. �� ���� ��������
	
	//���� ��ȹ���� Top Down ������� Ǯ���ϴ� ���
	 * �޸������̼Ǹ��� ����Ͽ� �����ϸ� �ȴ�.
*/
