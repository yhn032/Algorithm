package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class _2447 {
	static char[][] arr;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//ũ�Ⱑ NxN�� ���簢���϶�, ����� N/2�� ��(������ 3�� �ŵ������̹Ƿ� ���� ������ Ȧ���̴�.)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		

		printStar(0,0,N,false);
	
		StringBuilder sb =new StringBuilder();
		
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
	private static void printStar(int x, int y, int n, boolean space) {
		// TODO Auto-generated method stub
		//������ ���(3x3�� �迭�� ��ȸ�� 5��° ����� ��)
		if(space) {
			for(int i=x; i< x+n;i++) {
				for(int k=y;k<y+n;k++) {
					arr[i][k] =' ';
				}
			}
			return;
		}
		
		//N==1 ���� ���� ����
		if(n==1) {
			arr[x][y] = '*';
			return;
		}  
		
		//���� ����ؾ� �ϴ� ��� ��� ������ ������ ������ ���
		//N�� ũ�Ⱑ Ŭ ��, ��Ģ�� �����Ƿ�, �ɰ� �� ���� ������ �ɰ��� ���� �������� ä������.
		//������������ �� ����� ũ�Ⱑ size�̴�. 
		//n=9���, 9���� ����� n=3�϶��� ����Ǽ��� ä���ȴ�.(��� ��������)
		//n=3���, 9���� ����� n=1�϶��� ����Ǽ��� ä��� �ȴ�.
		int size = n/3;
		int count = 0; 
		
		//n=3�̶�� ����� ������ 1�� �����ϱ� ������ ���ص��ٵ�, 
		//n=9��� ����� ũ�Ⱑ 3x3�̹Ƿ� �ε����� 3�� �����ؾ� ��
		for(int i = x; i< x+n; i +=size) {
			for(int k = y; k < y+n; k+= size) {
				count++;//5��° ����� ���� ���ϱ� ����. �ε����ε� �� �� ���� �Ű����� �ʹ� ���������� �׳� ���� ���� ����
				if(count==5) {//������ ����ؾ� �Ѵ�. 
					printStar(i, k, size, true);
				} else {
					printStar(i, k, size, false);
				}
			}
		}
		
	}
	


}
