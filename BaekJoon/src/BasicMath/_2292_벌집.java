package BasicMath;

import java.util.Scanner;

public class _2292_벌집 {

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
		}//각 원소에는 해당 방의 마지막 번호가 들어간다.
		
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
	방의 크기 증가
	
	1번방 : 1			5*(1-1) + 1
	2번방 : 6			5*(2-1) + 1
	3번방 : 12			5*(3-1) + 2
	4번방 : 18			5*(4-1) + 3
	
	
	만약에 말이야 
	1
	2 ~ 7
	8 ~ 19
	20 ~ 37
	
	위와 같이 2차원 가변 배열을 만든다.
	각 배열의 0번지랑 크기를 비교해서 도착지가 몇번 방에 있는지 찾는다. 
	행인덱스 0번지부터 목적지까지의 방을 뺀다 + 1하면 정답
*/
