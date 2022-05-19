package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650_N��M2 {
	static int n,m;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		//�Է°� �迭 �ʱ�ȭ
		arr   = new int[m];//����� ����� ���� �迭
		
		dfs(0,1); //���� ���� 0
		
		
		System.out.println(sb);
		//depth������ �߰��Ͽ� �� ���� dfs�� ���� ���ǿ� �´� ���� ã������
		//+1�ؼ� Ž�� ���̿� ���ÿ� ������ �̷�� ���� ������ ���� ī��Ʈ ���ش�. 
		//�� 4���� ���� �����ؾ� �Ҷ� ���̰� 1�̸� 1���� ���ڸ� �� ���̰�, 
		//���̰� 4�̸� Ž���� ���� ��
		//Ž���� ��ġ�� ���̸� +1�ؾ� �Ѵ�.
		
	}
	private static void dfs(int depth, int pos) {
		// TODO Auto-generated method stub
		//��͸� ����� ���� base������ recursion������ ����ؼ� ������ �־�� �Ѵ�. 
		//�̹� �������� ���̽��� ���� ���� �ʰ�, ������ ��� ���� ��� ����� �ϰ� �ٽ� ȣ���� �������� ���ư��� �ٸ� ���� �����غ� �� �ֵ��� 
		//����Լ� ���ο� �ݺ����� ������ ���̴� .
		
		
		//base
		if(depth == m) {
			for(int k : arr) {
				sb.append(k).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		//recursion 
		for(int k=pos; k<=n; k++) { 
			arr[depth] = k;
			dfs(depth+1, k+1);
			
			
		}
		
	}

}
