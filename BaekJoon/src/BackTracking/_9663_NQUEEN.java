package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663_NQUEEN {
	static int n;
	static int count;
	//static List<pos> list;
	static int [][]queen; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		queen = new int[n][n];
		//list = new ArrayList<pos>(n);
		
		//한 줄에는 반드시 하나의 퀸만 존재할 수 있기때문에, 첫 째줄을 기준으로 재귀 탐색을 진행한다. 
		//(첫 줄에 퀸을 위치시킬 위치의 열값 지정) 
		for(int i=0; i<n; i++) {
			//list.add(new pos(0, i));
			queen[0][i] = 1;//퀸의 위치만 1로 지정
			dfs(1);
			
			//하나의 기준점에서 탐색이 끝났다면 자료구조 초기화
			//list.remove(0);
			queen[0][i]=0;
		}
		
		System.out.println(count);
		
	}
											//깊이이자 행
	private static void dfs(int depth) {
		// TODO Auto-generated method stub
		if(depth == n) {
			count++;
			return;
		}
		
		//저장하고자 하는 위치를 기준으로 유망성을 검사하는 메소드를 생성하고 조건을 만족하면 퀸의 위치를 저장하도록 하자. 
		for(int i=0; i<n; i++) {
			if(check(depth, i)) {
				
				//새로 배치할 퀸의 위치 저장
				//list.add(new pos(depth, i));
				queen[depth][i]=1;
				
				dfs(depth+1);
				//list.remove(depth);
				queen[depth][i]=0;
			}
			
		}
		
	}
	
	//유망성 체크
	private static boolean check(int row, int col) {
		// TODO Auto-generated method stub
		
		
		for(int i=0; i<n; i++) {
			for(int k=0; k<n; k++) {
				
				//      행  열
				if(queen[i][k]==1) {
					
					//대각선 상에 존재하는지 
					//두 좌표의 열의 값 차이와 행의 값 차이가 동일하다면 대각선 상에 존재한다. 
					//행은 계속 깊숙한 곳으로 내려가면서 커져가므로 음수가 될 수없지만 
					//열은 음수가 될 가능성이 있기 때문에 절댓값을 취해야 한다.
					if((row-i) == Math.abs(col-k)) return false;
					
					
					
					//상하 직선 상에 존재하는지 단 하나의 퀸과도 같은 열에 있다면 안 된다. 
					if(k == col) return false;
					//좌우 직선 상에 존재하는지
					//퀸을 한 행에 하나씩만 배치하도록 구현되어 있기 때문에 좌우에는 존재할 수도 없고 검사할 필요도 없음
				}
				
			}
		}
		
		return true;
	}

}

class pos{
	int row;
	int col;
	
	public pos() {
		
	}
	
	public pos(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

/*
	각 줄에는 하나의 퀸만 존재할 수 있다. + 대각선의 위치에 퀸이 존재할 수 없다. 
	1차원 배열에 
*/
	/*
	static int n;
	static boolean visit[][];
	static int answer;
	static int qcnt=0;//배치한 퀸의 개수
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				// 첫번째 퀸을 놓는 시작점
				// 퀸의 시작점을 잡고 해당 시작점에서 마스킹 처리를 해가면서 빈칸을 채우는 퀸의 위치를 잡는 경우의수를 한다.
				//System.out.println(k);
				qcnt++;
				queen(i, k);
				
				for(boolean a[] : visit) {
					Arrays.fill(a, false);
				}
				qcnt=0;
			}
		}
		
		System.out.println(answer);

	}

	private static void queen(int x, int y) {
		// TODO Auto-generated method stub
		if(qcnt==n) {
			answer++;
			return;
		}

		// 퀸의 위치를 기준으로 퀸이 이동할 수 있는 위치를 마스킹한다.
		mask(x, y);



		// 하나씩 탐색을 진행하면서 마스킹 되지 않은 곳에 새로운 퀸을 위치시킨다.

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				//마스킹 되어 있는 곳은 위치할 수 없으므로 skip
				if (visit[i][k])
					continue;
				
				qcnt++;
				queen(i, k);
			}
		}
		
	}

	private static void mask(int x, int y) {
		// TODO Auto-generated method stub

		// 현재 위치에서 좌우를 마스킹 이미 마스킹 되어 있다면 skip
		// 우
		for (int i = y; i < n; i++) {
			if (visit[x][i])
				continue;
			visit[x][i] = true;
		}

		// 좌
		for (int i = y; i >= 0; i--) {
			if (visit[x][i])
				continue;
			visit[x][i] = true;
		}

		// 현재 위치에서 상하를 마스킹
		// 하
		for (int i = x; i < n; i++) {
			if (visit[i][y])
				continue;
			visit[i][y] = true;
		}

		// 상
		for (int i = y; i >= 0; i--) {
			if (visit[i][y])
				continue;
			visit[i][y] = true;
		}

		// 현재 위치가 바뀌면 안되니까 임시 좌표를 생성해서 마스킹의 시작점을 인자로 받은 위치로 초기화 해야 한다.
		// 현재위치에서 오른쪽 위 대각선 마스킹
		// 우상
		int curX = x;
		int curY = y;
		while (true) {

			int tempX = curX - 1;
			int tempY = curY + 1;

			// 탈출조건
			if (tempX < 0 || tempY >= n)
				break;

			if (tempX >= 0 && tempY < n) {// 범위를 벗어나지 않는 경우
				if (visit[tempX][tempY]) {
					curX = tempX;
					curY = tempY;
					continue;
				}
				visit[tempX][tempY] = true;
			}
			
			curX = tempX;
			curY = tempY;


		}

		// 좌하
		curX = x;
		curY = y;
		while (true) {
			int tempX = curX + 1;
			int tempY = curY - 1;

			// 탈출조건
			if (tempX >= n || tempY < 0)
				break;

			if (tempX >= 0 && tempY < n) {// 범위를 벗어나지 않는 경우
				if (visit[tempX][tempY]) {
					curX = tempX;
					curY = tempY;
					continue;
				}
				visit[tempX][tempY] = true;
			}
			
			curX = tempX;
			curY = tempY;


		}

		// 우하
		curX = x;
		curY = y;
		while (true) {
			int tempX = curX + 1;
			int tempY = curY + 1;

			// 탈출조건
			if (tempX >= n || tempY >= n)
				break;

			if (tempX >= 0 && tempY < n) {// 범위를 벗어나지 않는 경우
				if (visit[tempX][tempY]) {
					curX = tempX;
					curY = tempY;
					continue;
				}
				visit[tempX][tempY] = true;
			}

			curX = tempX;
			curY = tempY;

		}

		// 좌상
		curX = x;
		curY = y;
		while (true) {
			int tempX = curX - 1;
			int tempY = curY - 1;

			// 탈출조건
			if (tempX < 0 || tempY < 0)
				break;

			if (tempX >= 0 && tempY < n) {// 범위를 벗어나지 않는 경우
				if (visit[tempX][tempY]) {
					curX = tempX;
					curY = tempY;
					continue;
				}
				visit[tempX][tempY] = true;
			}

			curX = tempX;
			curY = tempY;

		}

	}
*/

