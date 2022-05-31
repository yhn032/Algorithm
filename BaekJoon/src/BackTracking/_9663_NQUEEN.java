package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663_NQUEEN {
	static int n;
	static int count;
	//static List<pos> list;
	static int [][]queen; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		queen = new int[n][n];
		//list = new ArrayList<pos>(n);
		
		//�� �ٿ��� �ݵ�� �ϳ��� ���� ������ �� �ֱ⶧����, ù °���� �������� ��� Ž���� �����Ѵ�. 
		//(ù �ٿ� ���� ��ġ��ų ��ġ�� ���� ����) 
		for(int i=0; i<n; i++) {
			//list.add(new pos(0, i));
			queen[0][i] = 1;//���� ��ġ�� 1�� ����
			dfs(1);
			
			//�ϳ��� ���������� Ž���� �����ٸ� �ڷᱸ�� �ʱ�ȭ
			//list.remove(0);
			queen[0][i]=0;
		}
		
		System.out.println(count);
		
	}
											//�������� ��
	private static void dfs(int depth) {
		// TODO Auto-generated method stub
		if(depth == n) {
			count++;
			return;
		}
		
		//�����ϰ��� �ϴ� ��ġ�� �������� �������� �˻��ϴ� �޼ҵ带 �����ϰ� ������ �����ϸ� ���� ��ġ�� �����ϵ��� ����. 
		for(int i=0; i<n; i++) {
			if(check(depth, i)) {
				
				//���� ��ġ�� ���� ��ġ ����
				//list.add(new pos(depth, i));
				queen[depth][i]=1;
				
				dfs(depth+1);
				//list.remove(depth);
				queen[depth][i]=0;
			}
			
		}
		
	}
	
	//������ üũ
	private static boolean check(int row, int col) {
		// TODO Auto-generated method stub
		
		
		for(int i=0; i<n; i++) {
			for(int k=0; k<n; k++) {
				
				//      ��  ��
				if(queen[i][k]==1) {
					
					//�밢�� �� �����ϴ��� 
					//�� ��ǥ�� ���� �� ���̿� ���� �� ���̰� �����ϴٸ� �밢�� �� �����Ѵ�. 
					//���� ��� ����� ������ �������鼭 Ŀ�����Ƿ� ������ �� �������� 
					//���� ������ �� ���ɼ��� �ֱ� ������ ������ ���ؾ� �Ѵ�.
					if((row-i) == Math.abs(col-k)) return false;
					
					
					
					//���� ���� �� �����ϴ��� �� �ϳ��� ������ ���� ���� �ִٸ� �� �ȴ�. 
					if(k == col) return false;
					//�¿� ���� �� �����ϴ���
					//���� �� �࿡ �ϳ����� ��ġ�ϵ��� �����Ǿ� �ֱ� ������ �¿쿡�� ������ ���� ���� �˻��� �ʿ䵵 ����
				}
				
			}
		}
		
		return true;
	}

}

class pos{
	int row;
	int col;
	
	public pos() {
		
	}
	
	public pos(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

/*
	�� �ٿ��� �ϳ��� ���� ������ �� �ִ�. + �밢���� ��ġ�� ���� ������ �� ����. 
	1���� �迭�� 
*/
	/*
	static int n;
	static boolean visit[][];
	static int answer;
	static int qcnt=0;//��ġ�� ���� ����
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				// ù��° ���� ���� ������
				// ���� �������� ��� �ش� ���������� ����ŷ ó���� �ذ��鼭 ��ĭ�� ä��� ���� ��ġ�� ��� ����Ǽ��� �Ѵ�.
				//System.out.println(k);
				qcnt++;
				queen(i, k);
				
				for(boolean a[] : visit) {
					Arrays.fill(a, false);
				}
				qcnt=0;
			}
		}
		
		System.out.println(answer);

	}

	private static void queen(int x, int y) {
		// TODO Auto-generated method stub
		if(qcnt==n) {
			answer++;
			return;
		}

		// ���� ��ġ�� �������� ���� �̵��� �� �ִ� ��ġ�� ����ŷ�Ѵ�.
		mask(x, y);



		// �ϳ��� Ž���� �����ϸ鼭 ����ŷ ���� ���� ���� ���ο� ���� ��ġ��Ų��.

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				//����ŷ �Ǿ� �ִ� ���� ��ġ�� �� �����Ƿ� skip
				if (visit[i][k])
					continue;
				
				qcnt++;
				queen(i, k);
			}
		}
		
	}

	private static void mask(int x, int y) {
		// TODO Auto-generated method stub

		// ���� ��ġ���� �¿츦 ����ŷ �̹� ����ŷ �Ǿ� �ִٸ� skip
		// ��
		for (int i = y; i < n; i++) {
			if (visit[x][i])
				continue;
			visit[x][i] = true;
		}

		// ��
		for (int i = y; i >= 0; i--) {
			if (visit[x][i])
				continue;
			visit[x][i] = true;
		}

		// ���� ��ġ���� ���ϸ� ����ŷ
		// ��
		for (int i = x; i < n; i++) {
			if (visit[i][y])
				continue;
			visit[i][y] = true;
		}

		// ��
		for (int i = y; i >= 0; i--) {
			if (visit[i][y])
				continue;
			visit[i][y] = true;
		}

		// ���� ��ġ�� �ٲ�� �ȵǴϱ� �ӽ� ��ǥ�� �����ؼ� ����ŷ�� �������� ���ڷ� ���� ��ġ�� �ʱ�ȭ �ؾ� �Ѵ�.
		// ������ġ���� ������ �� �밢�� ����ŷ
		// ���
		int curX = x;
		int curY = y;
		while (true) {

			int tempX = curX - 1;
			int tempY = curY + 1;

			// Ż������
			if (tempX < 0 || tempY >= n)
				break;

			if (tempX >= 0 && tempY < n) {// ������ ����� �ʴ� ���
				if (visit[tempX][tempY]) {
					curX = tempX;
					curY = tempY;
					continue;
				}
				visit[tempX][tempY] = true;
			}
			
			curX = tempX;
			curY = tempY;


		}

		// ����
		curX = x;
		curY = y;
		while (true) {
			int tempX = curX + 1;
			int tempY = curY - 1;

			// Ż������
			if (tempX >= n || tempY < 0)
				break;

			if (tempX >= 0 && tempY < n) {// ������ ����� �ʴ� ���
				if (visit[tempX][tempY]) {
					curX = tempX;
					curY = tempY;
					continue;
				}
				visit[tempX][tempY] = true;
			}
			
			curX = tempX;
			curY = tempY;


		}

		// ����
		curX = x;
		curY = y;
		while (true) {
			int tempX = curX + 1;
			int tempY = curY + 1;

			// Ż������
			if (tempX >= n || tempY >= n)
				break;

			if (tempX >= 0 && tempY < n) {// ������ ����� �ʴ� ���
				if (visit[tempX][tempY]) {
					curX = tempX;
					curY = tempY;
					continue;
				}
				visit[tempX][tempY] = true;
			}

			curX = tempX;
			curY = tempY;

		}

		// �»�
		curX = x;
		curY = y;
		while (true) {
			int tempX = curX - 1;
			int tempY = curY - 1;

			// Ż������
			if (tempX < 0 || tempY < 0)
				break;

			if (tempX >= 0 && tempY < n) {// ������ ����� �ʴ� ���
				if (visit[tempX][tempY]) {
					curX = tempX;
					curY = tempY;
					continue;
				}
				visit[tempX][tempY] = true;
			}

			curX = tempX;
			curY = tempY;

		}

	}
*/

