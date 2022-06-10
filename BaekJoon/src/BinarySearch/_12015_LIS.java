package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12015_LIS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int []arr = new int[n];
		int []lis = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//�ʱⰪ�� �״�� �־��ְ�, ���� ���ϸ鼭 �߰��Ѵ�. 
		//�������� ���� ���� ū ������ ũ�ٸ� �߰� 
		//�������� ���� ���� ū ������ �۴ٸ� �������� ���� ���� ����� ���� ��ġ
		
		lis[0] = arr[0];
		int lengthLIS=1;
		
		for(int i=1; i<n; i++) {
			
			//�ʱ갪�� �״�� �־����� �� ���� ���� ���� 
			//key�� �������������� �������� �ϴ� ���̴�. 
			int key = arr[i];
			
			
			//lis�� ���� ��������. ���� �������� �ϴ� ���� �� ũ�ٸ� �߰�""
			if(lis[lengthLIS-1] < key) {
				lengthLIS++;
				lis[lengthLIS-1] = key;
			}else {
				//key���� ���̰� �ּҰ� �ǵ����ϴ� �� -> lower boundã�� 
				
				int min = 0;
				int max = lengthLIS;
				while(min < max) {
					int mid = (min+max)/2;
					
					if(lis[mid] < key) {
						min = mid+1;
					}else {
						max = mid;
					}
				}
				
				lis[min] = key; //�� ��ġ�ϱ�
			}
		}
		
		
		System.out.println(lengthLIS);
		
	}

}
//�߰��� �ƴ� ��ġ. 
//��ȣ ���� ���� ���̸� �ּ�ȭ ���Ѿ߸� �� �پ��� ���� �����ϰ� ���ͼ� �����ϴ� �κм����� ��Ҹ� �ø� �� �ִ�. -> ����