package BasicMath;

import java.util.Scanner;

public class _2292_���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		/*
		 * int max = 1000000000;
		 * 
		 * int sum=1; int i=2; while(true) { if(sum >= max) { break; } sum += 6*(i-1);
		 * i++; } System.out.println(i);
		 */
		
		int arr[] = new int[18259];
		arr[1] = 1;
		for(int k=2; k<arr.length;k++) {
			arr[k] = arr[k-1] + 6*(k-1); 
		}//�� ���ҿ��� �ش� ���� ������ ��ȣ�� ����.
		
		int goal = 0;
		
		for(int i=1; i<arr.length;i++) {
			//System.out.println(i + ", " + arr[i]);
			if(n <= arr[i] && n >arr[i-1]) {
				goal = i;
				break;
			}
		}
		
		if(n==1) {
			System.out.println(1);
		}else {
			System.out.println(goal);
		}
		
	}

}

/*
	���� ũ�� ����
	
	1���� : 1			5*(1-1) + 1
	2���� : 6			5*(2-1) + 1
	3���� : 12			5*(3-1) + 2
	4���� : 18			5*(4-1) + 3
	
	
	���࿡ ���̾� 
	1
	2 ~ 7
	8 ~ 19
	20 ~ 37
	
	���� ���� 2���� ���� �迭�� �����.
	�� �迭�� 0������ ũ�⸦ ���ؼ� �������� ��� �濡 �ִ��� ã�´�. 
	���ε��� 0�������� ������������ ���� ���� + 1�ϸ� ����
*/
