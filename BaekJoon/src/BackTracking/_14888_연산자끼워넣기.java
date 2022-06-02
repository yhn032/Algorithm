package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888_�����ڳ����ֱ� {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int n;
	static int arr[];
	static int op[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//������ ���� 
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		//���� �ʱ�ȭ
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		op = new int[4];
		
		//������ ���� �ʱ�ȭ 
		//op[0] = +, op[1] = -, op[2] = *, op[3] = /
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, arr[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int idx, int num) {
		// TODO Auto-generated method stub
		if(idx == n) {
			max = max < num ? num : max;
			min = min > num ? num : min;
			return;
		}
		
		
		for(int i=0; i<4; i++) {
			if(op[i] > 0) {
				//�����ڰ� �� �� �̻� �����Ѵٸ� 
				op[i]--;
				
				switch(i) {
				case 0: dfs(idx+1,num + arr[idx]); break;
				case 1: dfs(idx+1,num - arr[idx]); break;
				case 2: dfs(idx+1,num * arr[idx]); break;
				case 3: dfs(idx+1,num / arr[idx]); break;
				}
				
				//��Ʈ��ŷ�� �⺻ -> ��� ȣ���� ����Ǹ� ��� Ž���ߴ� ��ο� ���ؼ��� ������ �ؾ��Ѵ�.
				op[i]++;
			}
		}
	}

}

/*
	�־��� ������ ������ �ٲ� �� ����. 
	��ü ����� �� -> ��ü �������� ���� m �϶�, �����ڰ� �ߺ� �ȴٸ� 
	m!/(�ߺ��ȿ����ڰ���)!...
	����� ������ �տ��� ���� �����Ѵ�. 
	�������� ���� ���������� �� ���Ѵ�. 
	���� �������� -> ����� �������� ������ ������� ������ ���Ѵ�. 
	����� �ִ� ���� ����� �ִ��� �Ͱ� �ּ��� ���� ���϶�
*/


