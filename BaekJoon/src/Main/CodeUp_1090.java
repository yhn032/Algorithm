package Main;

import java.util.Scanner;

public class CodeUp_1090 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
			
		String input[] = sc.nextLine().split(" ");
		
		int a = Integer.parseInt(input[0]);	
		int r = Integer.parseInt(input[1]);
		int n = Integer.parseInt(input[2]);
		
		//�ִ밪�� ���캸��. �Է��� �ִ밡 10�̹Ƿ�  10 10 10 -> 10,000,000,000 (100���̴�) 
		//int �ڷ����� �ִ�� 2,147,483,647�̴�. unsigned�� �����ؼ� �ι�� ���൵ �����ϴ�. 
		//��, �Ǽ������͸� ���������� ĳ�����ϴ� �������� �������� ��� �����͸� ������ �� ���� ������ �����÷ο찡 �߻�. 
		//�߸��� �����Ͱ� ���. ���� �ִ밪�� ������ �� �ִ� long���� ������ �ڷ����� ����ؾ� ��
		System.out.printf("%d",a*(long)Math.pow(r, n-1));
	}

}
