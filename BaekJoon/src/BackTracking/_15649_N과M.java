package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15649_N��M {
	static int n,m;
	static int arr[];
	static boolean check[];
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
		check = new boolean[n];
		
		dfs(0); //���� ���� 0
		
		
		System.out.println(sb);
		//depth������ �߰��Ͽ� �� ���� dfs�� ���� ���ǿ� �´� ���� ã������
		//+1�ؼ� Ž�� ���̿� ���ÿ� ������ �̷�� ���� ������ ���� ī��Ʈ ���ش�. 
		//�� 4���� ���� �����ؾ� �Ҷ� ���̰� 1�̸� 1���� ���ڸ� �� ���̰�, 
		//���̰� 4�̸� Ž���� ���� ��
		//Ž���� ��ġ�� ���̸� +1�ؾ� �Ѵ�.
		
	}
	private static void dfs(int i) {
		// TODO Auto-generated method stub
		//��͸� ����� ���� base������ recursion������ ����ؼ� ������ �־�� �Ѵ�. 
		//�̹� �������� ���̽��� ���� ���� �ʰ�, ������ ��� ���� ��� ����� �ϰ� �ٽ� ȣ���� �������� ���ư��� �ٸ� ���� �����غ� �� �ֵ��� 
		//����Լ� ���ο� �ݺ����� ������ ���̴� .
		
		
		//base
		if(i == m) {
			for(int k : arr) {
				if(k==0) continue;
				sb.append(k).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		//recursion 
		for(int k=0; k<n; k++) {//�ε����� ���� ���Ͻ� �߱� ������ 1~n���� �ݺ��� �����Ѵ�. 
			if (!check[k]) {//���� �湮���� �ʾҴٸ�
				check[k] = true;
				arr[i] = k+1;
				dfs(i+1);
				check[k] = false;
			}
			
		}
		
	}

}
