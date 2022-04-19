package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1874 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//������ �̷� ������ ����
		int n = Integer.parseInt(br.readLine());
		
		int [] stack = new int[n];
		int size = 0;//��Ұ���
		
		//���ÿ� ������������ push�ǵ��� ���� �������� push�� ���ڸ� ����ϵ��� �ϴ� ����
		int nextInput = 0;
		//�Էµ� ���ڿ��� ������ pop�ؾ��� �����̴�. 
		//������ push�Ǵ� ������ �ݵ�� ���������̾�� �Ѵ�.
		//pop�ؾ� �ϴ� ������ ������ �ֻ���� ���� �۴ٸ�, �ٽ� pop�ϰ����ϴ� ������ push�ϸ� ������, 
		//pop�ؾ� �ϴ� ������ ������ �ֻ���� ���� ũ�ٸ�, ������������ push�ؾ� �ϴ� ������ ����. �� ���� ������ �����̹Ƿ� NO�� ���
		
		
		while(n --> 0) {
			
			int value = Integer.parseInt(br.readLine());
			
			if(nextInput < value) {
				for(int i=nextInput+1 ; i<=value; i++) {
					stack[size]=i;
					size++;
					sb.append("+").append('\n');
				}
				nextInput = value;
			}
			else if (stack[size-1] != value){ //value���� ū ���
				System.out.println("NO");
				return;
			}
			size--;
			sb.append("-").append('\n');
		}
		System.out.println(sb);
	}
}

