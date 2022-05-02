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
		
		//최대값을 살펴보자. 입력의 최대가 10이므로  10 10 10 -> 10,000,000,000 (100억이다) 
		//int 자료형의 최대는 2,147,483,647이다. unsigned로 선언해서 두배로 쳐줘도 부족하다. 
		//즉, 실수데이터를 정수형으로 캐스팅하는 과정에서 정수형이 모든 데이터를 수용할 수 없기 때문에 오버플로우가 발생. 
		//잘못된 데이터가 출력. 따라서 최대값을 수용할 수 있는 long형의 정수형 자료형을 사용해야 함
		System.out.printf("%d",a*(long)Math.pow(r, n-1));
	}

}
