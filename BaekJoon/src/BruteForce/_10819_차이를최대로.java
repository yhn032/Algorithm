package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _10819_���̸��ִ�� {

	static int nums[];
	static boolean[] visited;
	static int n;
	static int result = Integer.MIN_VALUE;
	static List<Integer> list;

	public static void main(String[] args) throws Exception { // TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		nums = new int[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList<Integer>();
		dfs(0);
		System.out.println(result);
	}

	private static void dfs(int depth) { 
		// TODO Auto-generated method stub //���� depth��n�϶� n+1���� ��Ҹ� ���� �ִ´�.
  
		//base case 
		if(depth == n) { //���� ���� ������ ���鼭 ��ƿ� ���ڵ��� �������� ���ؼ� �ִ� ���� 
			int sum = 0; 
			for(int i=1; i<n; i++) { 
				sum += Math.abs(list.get(i-1)-list.get(i)); }
				result = Math.max(sum, result); 
				return; 
			}

		// recursive case 
		for(int i=0; i<n; i++) { 
			if(!visited[i]) {//�湮���� �ʾҴٸ�,,,
			visited[i]=true;// �湮 ó�� ���ְ� 
			list.add(nums[i]); 
			dfs(depth+1);//�迭 �ϳ��� list���־��ش�.
			list.remove(list.size()-1);// basecase�� �� ����� ������ �ٸ� ����� ���� �־�� ���� ���������� �����Ѵ�.
			visited[i]=false;// �ٸ� ����� ������ �湮�� �� �ֵ��� �湮ǥ�ø� �����. } }

			}
		}
	}
}


/*
 * ������ �μ��� ũ���� ���̰� �ִ밡 �ǵ��� ������ �ٲ�� �迭�� ������ ������ �ִٴ� �Ϳ� ����. ��� ����� ���� �� �˻��ص� 8!�̹Ƿ�
 * �ð��ʰ������� ���ڴ�. 8�� ��ø ���� �ƴϸ� ��͸� ����. �� ��Ҹ� �迭�� ������ �޵�, ��͸� ���̰� n�϶����� �ݺ��ϰ� �迭��
 * �ε����� �������� �湮 �迭�� ������. ������ ���� ����������, ������ ���� ���ؼ� �ִ��� ���Ť��ϴ�.
 */