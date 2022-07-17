package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _16235_��������ũ {
	static int dx[] = {-1, -1, 0, 1, 1,  1,  0, -1};
	static int dy[] = { 0,  1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	//���� ��(n*n)�� ũ�� �ε����� 1���� �����Ѵ�!
		int m = Integer.parseInt(st.nextToken());	//�󵵰� ���� ������ ����.
		int k = Integer.parseInt(st.nextToken());	//k�� �� ����ִ� ������ ���� ���ϱ� ���� ����
		
		//�ų� �ܿ� ���� �߰��Ǵ� ����� ��
		int A[][] = new int[n+1][n+1]; 
		//�� ��ġ�� �ִ� ����� ����� �迭 
		int TREE[][] = new int[n+1][n+1];
				
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(TREE[i], 5);
			for(int j=1; j<=n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//������ �������� ť�� �����. �ϳ� �� ������ �˻��ϰ� ���� �� �״�� ����, ���̰� �þ ���� �ø��� �ٽ� �� �ڷ� ����
		LinkedList<tree> q = new LinkedList<>();
		LinkedList<tree> deadTree = new LinkedList<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x   = Integer.parseInt(st.nextToken());
			int y   = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			q.add(new tree(x, y, age));
		}
		
		int year = 0;

		//�� ��ġ�� ������ ����, ������ ����, ������ ����� �����ؾ� �ϴµ�,,,
		while(true) {
			if(year == k) break;
			
			Iterator<tree> iterator = q.iterator();
			//��(���� �� �ִ� ����� �� �԰�, �� �Դ� �ֵ��� �� �׾�)
			while(iterator.hasNext()) {
				
				tree t = iterator.next();
				int r = t.x;
				int c = t.y;
				int age = t.age;
				
				if(TREE[r][c] < age) {//�ڽ��� ���̸�ŭ ����� ���� �� ���� ���
					
					//ť���� ������ �ٽ� �ȳ����� �����ϴ� �Ͱ� ���� ȿ��
					deadTree.offer(t);
					
					//LinkedList���� iterator�� ���� remove�� O(1)�� �ð����⵵�� ������!
					iterator.remove();
					
				}else {//����� ����� ���� �� �ִٸ�
					
					//���� ��� ��ŭ �����ϱ�
					TREE[r][c] -= age;
					
					//����������Ű��
					t.age += 1;
				}
			}
			
			//����(���� ���� ������ ������� ���� �ñ�)
			while(!deadTree.isEmpty()) {
				tree t = deadTree.poll();
				
				TREE[t.x][t.y] += t.age/2;
			}
			
			//����(������ ���̰� 5�� ����� �͸� ������ �Ѵ�.)
			LinkedList<tree> babyTrees = new LinkedList<>();
			for(tree tree : q){
				int r = tree.x;
				int c = tree.y;
				if(tree.age % 5 == 0) {
					//���İ����� ���8���� �� �Ⱦ��.
					for(int j=0; j<8; j++) {
						int xx = r + dx[j];
						int yy = c + dy[j];
						
						if(xx < 1 || yy < 1 || xx > n || yy > n) continue;
						babyTrees.add(new tree(xx, yy, 1));
					}
					//���� ������ �µ��� age�� ���� ū ���� ������ �������� �ִ´�. 
				}
				
				continue;
			}
			q.addAll(0, babyTrees);
			
			//�ܿ�(��� �߰�)
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					TREE[i][j] += A[i][j];
				}
			}
			
			year++;
		}
		
		System.out.println(q.size());
		
		/*
			1�� �ֱ�(�Է����� �־����� ������ �ʱ� ��ġ�� ��� �ٸ����� ������ ���� ���� ������ ���� �׷��� ���� ���� ����)
			�� 	 : �ڽ��� ���̸�ŭ ����� �԰� ���̰� 1 ����. �ڽ��� ���� �ȿ� �ִ� ��и� ���� �� ����. ���� � ���� ����. �ڽ��� ���̸�ŭ ����� �������� ����� ���� ���ϰ� ���
			���� : ���� ���� ������ ����/2 ��ŭ�� ������� �߰��ȴ�.(�Ҽ��� ����)
			���� : ���̰� 5�� ����� ������ ������ ���� �����ϴ�. 
			�ܿ� : S2D2�� ��� ���� ���ƴٴϸ鼭 ���� ����� �߰��Ѵ�. �߰��ϴ� ����� �迭 A�� ����Ǿ� ����.
		*/
	}

}

class tree {
	int x, y, age;

	public tree(int x, int y, int age) {
		super();
		this.x = x;
		this.y = y;
		this.age = age;
	}
}

