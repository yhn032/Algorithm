package Kakao;

import java.util.Arrays;

class Solution5 {
	static int move_x[] = {-1, 1, 0, 0};
	static int move_y[] = {0, 0, -1, 1};
	
	static int count_area = 0;
	public int[] solution5(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean [][]flag = new boolean[m][n]; //기본값 false. 방문한 곳은 true로 toggle
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        
        //그림판 배열 탐색 시작
        for(int i=0; i<m; i++) {
        	for(int k=0; k<n; k++) {
        		//0이 아니거나 아직 방문하지 않은 곳이라면 탐색해라
        		if(picture[i][k] != 0 && !flag[i][k]) {
        			numberOfArea++; //새로운 영역 발견
        			finding(i, k, picture, flag);
        		}
        		//한 영역에 대한 탐색이 끝나면,, 가장 넓은 영역과 비교해서 갱신해주고 다음 영역을 탐색하기 위해 초기화
        		if(count_area > maxSizeOfOneArea) {
        			maxSizeOfOneArea = count_area;
        			count_area = 0;
        		}
        	}
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        
        return answer;
    }

	public static void finding(int i, int k, int[][] picture, boolean[][] flag) {
		// TODO Auto-generated method stub
		//탐색하다가 이미 가본 곳이면 탈출
		if(flag[i][k])
			return;
		
		//첫 방문이라면 다음에 다시 왔을 경우를 대비해서 방문 흔적남기기 
		flag[i][k] = true;
		count_area++;
		
		//현재 위치에서 상하 좌우로 총 4번을 탐색한다. 
		int x = i;
		int y = k;
		
		for(int t=0; t<4; t++) {
			int xx = x + move_x[t];
			int yy = y + move_y[t];
			
			//만약 배열의 범위를 벗어났다면 더 진행할 필요 없이 무시. 어차피 배열 밖이라 방문표시할 필요도 없음
			if(xx < 0 || xx >= picture.length || yy < 0 || yy >= picture[0].length) {
				continue;
			}
			
			//만약 이동후와 이동 전 좌표의 색이 같고, 이동한 좌표가 아직 탐색하지 않은 곳이라면,,, 새로운 좌표를 기준으로 탐색시작 
			if(picture[x][y] == picture[xx][yy] && !flag[xx][yy]) {
				finding(xx, yy, picture, flag);
			}
		}
		
		
	}
}

public class image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 6;
		int n = 4;
		int [][] picture = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3},{0,0,0,3}};
		int answer[] = new int[2];
		
		Solution5 s = new Solution5();
		
		System.out.println(Arrays.toString(s.solution5(m, n, picture)));
	}

}
