package Kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution6 {
	//상  하  좌  우
	static int move_x[] = {-1, 1, 0, 0};
	static int move_y[] = {0, 0, -1, 1};
	
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Queue<Pos> q = new LinkedList<Pos>();
	
	
	public int[] solution6(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean [][]flag = new boolean[m][n]; //기본값 false. 방문한 곳은 true로 toggle
        
        
        //그림판 배열 탐색 시작
        for(int i=0; i<m; i++) {
        	for(int k=0; k<n; k++) {
        		int count_area = 0;
        		//0이 아니거나 아직 방문하지 않은 곳이라면 탐색해라
        		if(picture[i][k] != 0 && !flag[i][k]) {
        			q.add(new Pos(i, k));
        			flag[i][k] = true;
        			count_area++;
        			
        			while(!q.isEmpty()) {
        				Pos state = q.poll();
        				
        				for(int l=0; l<4; l++) {
        					int xx = state.x + move_x[l];
        					int yy = state.y + move_y[l];
        					//배열의 범위를 벗어나거나, 이미 방문 했거나, 이전 값과 색상이 다른 경우 skip
        					if(xx < 0 || yy < 0 || xx >= m || yy >= n || flag[xx][yy] || picture[state.x][state.y] != picture[xx][yy]) {
        						continue;
        					} else {
        						flag[xx][yy] = true;
        						q.add(new Pos(xx, yy));
        						count_area++;
        					}
        				}
        			}
        			
	        		//한 영역에 대한 탐색이 끝나면,, 가장 넓은 영역과 비교해서 갱신해주고 다음 영역을 탐색하기 위해 초기화
	        		numberOfArea++;
	        		maxSizeOfOneArea = maxSizeOfOneArea < count_area ? count_area : maxSizeOfOneArea;
        		}
        	}
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }

}

public class image2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 6;
		int n = 4;
		int [][] picture = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3},{0,0,0,3}};
		int answer[] = new int[2];
		
		Solution6 s = new Solution6();
		
		System.out.println(Arrays.toString(s.solution6(m, n, picture)));
	}

}
