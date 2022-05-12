package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1806_��������_�κ��� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//���� �ݺ��Ұ� -> �ΰ��� �����͸� ����ؼ� �ѹ��� �ݺ��� �ؾ���
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int start_idx = 0;
		int end_idx = 0;
		int sum = arr[0];
		
		int min = 100000000;
		
		//���� ������ ��Ȯ�ϰ� ����߾�� �ߴ�. 
		/*
			end_idx�� ���� �����ߴµ�, ���� �κ����� S���� �۴ٸ� ���̻��� ����� ���� ������ �׳� �����ϸ� ��
			end_idx�� ���� �����ߴµ�, ���� �κ����� S���� ũ�ų� ���ٸ� �ּ��� ���̸� ���Ҷ����� start_idx�� �÷����鼭 ���̸� �ּ�ȭ ��Ų��.
			�׷��ٰ� ��� �������� �ּұ��̸� ���ϸ� �� ���� start_idx������ sum�� S���� �۾����� Ÿ�̹��� ���ٵ�, ù�ٿ� ���Ѵ�� �����ϸ� �ȴ�. 
			
			
		*/
		while(start_idx <= N-1) {
			if(sum < S) {
				if(end_idx==N-1) {
					end_idx = N-1;
					break;
					/*
					 * int temp = end_idx - start_idx+1; min = temp < min ? temp : min; sum -=
					 * arr[start_idx]; start_idx++;
					 */
				} else {
					end_idx++;
					sum += arr[end_idx];
				}
			} else { //sum >= S
				//end_idx�� ��� �������Ѻ��� ������ ���������� ���̰� �þ�Ƿ�, �ּڰ��� ���Ϸ��� �������� �״� �ʿ�ġ ����
				//ó������ ������ �����ϴ� �ε������� ���̸� ���ϰ� �ּڰ��� ���Ѵ�.
				//�κ����� ���̸� ������ 
				int temp = end_idx - start_idx+1;
				min = temp < min ? temp : min;
				sum -= arr[start_idx];
				start_idx++;
			}
		}
		if(min == 100000000) {
			System.out.println(0);
		} else {
			System.out.println(min);
			
		}
		
		
		br.close();
	}

}
