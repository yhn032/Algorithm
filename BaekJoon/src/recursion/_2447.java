package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class _2447 {
	static char[][] arr;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//크기가 NxN의 정사각형일때, 가운데는 N/2의 몫값(어차피 3의 거듭제곱이므로 값은 무조건 홀수이다.)
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
		//공백일 경우(3x3의 배열을 순회중 5번째 경우의 수)
		if(space) {
			for(int i=x; i< x+n;i++) {
				for(int k=y;k<y+n;k++) {
					arr[i][k] =' ';
				}
			}
			return;
		}
		
		//N==1 가장 작은 단위
		if(n==1) {
			arr[x][y] = '*';
			return;
		}  
		
		//별을 출력해야 하는 경우 가운데 공백을 제외한 나머지 모두
		//N의 크기가 클 때, 규칙은 같으므로, 쪼갤 수 있을 때까지 쪼개서 같은 조건으로 채워야함.
		//분할했을때의 한 블록의 크기가 size이다. 
		//n=9라면, 9개의 블록을 n=3일때의 경우의수로 채우면된다.(가운데 공백제외)
		//n=3라면, 9개의 블록을 n=1일때의 경우의수로 채우면 된다.
		int size = n/3;
		int count = 0; 
		
		//n=3이라면 블록을 나누면 1씩 증가하기 때문에 이해될텐데, 
		//n=9라면 블록의 크기가 3x3이므로 인덱스가 3씩 증가해야 함
		for(int i = x; i< x+n; i +=size) {
			for(int k = y; k < y+n; k+= size) {
				count++;//5번째 경우의 수를 구하기 위함. 인덱스로도 할 수 있을 거같은데 너무 복잡해져서 그냥 변수 새로 만듬
				if(count==5) {//공백을 출력해야 한다. 
					printStar(i, k, size, true);
				} else {
					printStar(i, k, size, false);
				}
			}
		}
		
	}
	


}
