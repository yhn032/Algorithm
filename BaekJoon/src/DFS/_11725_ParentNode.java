package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11725_ParentNode {
	static ArrayList<Integer> tree[];
	static boolean check[];
	static int answer[];
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		//���������� �迭�� ũ�⸦ +1�ؼ� 0������ �Ⱦ��� 1�������� ���ϴ�.
		check = new boolean[N+1];
		tree = new ArrayList[N+1]; //->��̸���Ʈ�� 2�����迭 �����
		answer = new int[N+1];
		
		//��������Ʈ ����
		for(int i=0; i<tree.length;i++) {
			tree[i] = new ArrayList<>();
		}
		
		//��������Ʈ �ʱ�ȭ(�ǵ����ʹ� 1����) 
		for(int i=1; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			//��������� ��� ���������� ǥ��
			tree[n1].add(n2);
			tree[n2].add(n1);
		}
		
		//1���� ��Ʈ��� ������ ���̿켱 Ž�� ����
		DFS(1);
		for(int i=2; i<=N;i++) {
			System.out.println(answer[i]);
		}
	}


	private static void DFS(int i) {
		// TODO Auto-generated method stub
		//�湮üũ
		check[i] = true;
		
		//����Ʈ�� 1���� �����, �� 1�� ���� ����� ��带 Ž���մϴ�. 
		for(int k : tree[i]) {
			if(!check[k]) {
				//6���� �ε����� ���� �����(�θ��� ��ȣ)�� �ֽ��ϴ�.
				answer[k] = i;
				//6����忡�� �ٽ� DFS
				DFS(k);
			}
		}
	}

}
