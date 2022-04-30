package Kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution6 {
	//��  ��  ��  ��
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
        
        boolean [][]flag = new boolean[m][n]; //�⺻�� false. �湮�� ���� true�� toggle
        
        
        //�׸��� �迭 Ž�� ����
        for(int i=0; i<m; i++) {
        	for(int k=0; k<n; k++) {
        		int count_area = 0;
        		//0�� �ƴϰų� ���� �湮���� ���� ���̶�� Ž���ض�
        		if(picture[i][k] != 0 && !flag[i][k]) {
        			q.add(new Pos(i, k));
        			flag[i][k] = true;
        			count_area++;
        			
        			while(!q.isEmpty()) {
        				Pos state = q.poll();
        				
        				for(int l=0; l<4; l++) {
        					int xx = state.x + move_x[l];
        					int yy = state.y + move_y[l];
        					//�迭�� ������ ����ų�, �̹� �湮 �߰ų�, ���� ���� ������ �ٸ� ��� skip
        					if(xx < 0 || yy < 0 || xx >= m || yy >= n || flag[xx][yy] || picture[state.x][state.y] != picture[xx][yy]) {
        						continue;
        					} else {
        						flag[xx][yy] = true;
        						q.add(new Pos(xx, yy));
        						count_area++;
        					}
        				}
        			}
        			
	        		//�� ������ ���� Ž���� ������,, ���� ���� ������ ���ؼ� �������ְ� ���� ������ Ž���ϱ� ���� �ʱ�ȭ
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
