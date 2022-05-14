package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2775_�γ�ȸ�� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//�׽�Ʈ ���̽�
		int t =Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<t;i++) {
			//�� ���� ����
			int k =Integer.parseInt(br.readLine());
			
			//ȣ���� ����
			int n =Integer.parseInt(br.readLine());
			
			sb.append(search(k, n)).append('\n');
			
		}
		
		System.out.println(sb);
	}
	
	private static int  search(int k, int n) {
		// TODO Auto-generated method stub
		
		int arr[][]  = new int[k+1][n+1];
		
		for(int i=0; i<n;i++) {
			arr[0][i] = i+1;
		}
		
		
		//�� ���� ����
		for(int i=1; i<=k;i++) {
			
			//�� ���� ȣ�� ����
			for(int j=0; j<n;j++ ) {
				int sum =0;
				
				//���ϰ��� �ϴ� ���� �ٷ� �Ʒ����� ���� ����
				for(int p=0; p<=j;p++) {
					sum += arr[i-1][p];
					
					arr[i][p] = sum;
				}
			}
		}
		
		
		/*
		 * for(int i =0; i<=k;i++) { System.out.print(i + "��° �� : ");
		 * 
		 * for(int j=0; j<n; j++) { System.out.print(arr[i][j] + " "); }
		 * System.out.println(); }
		 */
		int people = arr[k][n-1];
		
		
		
		
		return people;
		
	}

}
