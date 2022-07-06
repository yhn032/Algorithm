package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16139_������_�ΰ���ǻ�� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String question = br.readLine();
		
		
		//������ �迭�� ������
		//dp[n][a] -> 0~n������ �����߿��� Ư�� ���� a�� ������ �����Ѵ�. a���� Ư�� ������ �ƽ�Ű�ڵ尪���� 'a'�� ������ �����Ѵ�.
		//2~5������ ������ �־����ٸ� 
		//dp[5][a] - dp[1][a�̴�. 
		//��� ���ĺ��� ���� 26���̴�. a-z
		int dp[][] = new int[question.length()][26];
		
		
		//���ڿ��� ������ �ʱ� ������ 
		//�ش� ���ڿ����� Ư�� �������� Ư�� ���ڿ��� ��� �ִ����� ���� �����ϸ� �ȴ�.!
		//���ڿ��� �� ���� O(n)���� Ž���ϸ鼭 Ư�� ���ڿ��� ���������� �ش� ���ڿ��� �ƽ�Ű�ڵ尪�� �ش��ϴ� �������� ����������+1�� �����Ѵ�. 
		//Ư�����ڰ� ���ӵǸ� ���� 1,2,3 �̷������� �ǰ����� �����ϸ� 0�� �ݺ��� ���̴�. 
		//�޸� ���� �־�̱� �ϴµ� �̷��Զ� �ؾ���,,, 
		
		//�ʱ갪 �ʱ�ȭ. ��� ���ĺ� �ҹ��ڴ� 'a'���� ũ�ų� ������ �ε����� ������ �� ��������
		dp[0][question.charAt(0)-'a']++;
		
		//�ʱ갪�� ������ ���� ���ں��� ���� �����Ѵ�.
		for(int i=1; i<question.length(); i++) {
			int tmp = question.charAt(i)-'a';
			
			for(int j=0; j<26; j++) {
				dp[i][j] = dp[i-1][j]; //�ش� ���ڿ��� ���� �������� �����Ѵ�. 
			}
			
			dp[i][tmp]++; //Ư�� ���ڿ��� ���� Ƚ���� ������Ų��.
		}
		
		
		
		
		int t = Integer.parseInt(br.readLine());
		
		for(int k=0; k<t; k++) {
			st = new StringTokenizer(br.readLine());
			
			char find = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			
				
			
			if(start == 0) {
				sb.append(dp[end][find-'a']).append('\n');
			}else {
				sb.append(dp[end][find-'a'] - dp[start-1][find-'a']).append('\n');
			}
			
		}
		
		System.out.println(sb);
	}

}
