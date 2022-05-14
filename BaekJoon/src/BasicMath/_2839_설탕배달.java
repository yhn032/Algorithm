package BasicMath;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2839_������� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int min = 5000;
		
		//5kg ������ ����
		int five=0; 
		//3kg ������ ����
		int three=0;
		
		while(5*five <= n) {
			
			if(5*five==n) { //n�� 5�� ����� ���
				min = five;
			}
			
			//3kg ������ ����
			three = 0;
			
			int temp = n - (5*five);
			if(temp % 3 != 0) {//5�� 3���� ������ �� ���� ������ ���
				five++;
				continue;
			} else {
				three = (temp/3);
			}
			
			min = min  > (five+three) ? five+three : min;
			/*
			 * System.out.println(five + "ȸ° ����� ��"); System.out.println("5kg : " + five);
			 * System.out.println("3kg : " + three);
			 */
			
			
			five++;
		}
		System.out.println(min != 5000 ? min : -1);
	}

}
