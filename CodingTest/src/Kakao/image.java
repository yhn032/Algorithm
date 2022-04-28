package Kakao;

class Solution5 {
	static int move_x[] = {-1, 1, 0, 0};
	static int move_y[] = {0, 0, -1, 1};
	
	static int count_area = 0;
	public int[] solution5(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean [][]flag = new boolean[m][n]; //�⺻�� false. �湮�� ���� true�� toggle
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        
        //�׸��� �迭 Ž�� ����
        for(int i=0; i<m; i++) {
        	for(int k=0; k<n; k++) {
        		//0�� �ƴϰų� ���� �湮���� ���� ���̶�� Ž���ض�
        		if(picture[i][k] != 0 && !flag[i][k]) {
        			numberOfArea++; //���ο� ���� �߰�
        			finding(i, k, picture, flag);
        		}
        		//�� ������ ���� Ž���� ������,, ���� ���� ������ ���ؼ� �������ְ� ���� ������ Ž���ϱ� ���� �ʱ�ȭ
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
		//Ž���ϴٰ� �̹� ���� ���̸� Ż��
		if(flag[i][k])
			return;
		
		//ù �湮�̶�� ������ �ٽ� ���� ��츦 ����ؼ� �湮 ��������� 
		flag[i][k] = true;
		count_area++;
		
		//���� ��ġ���� ���� �¿�� �� 4���� Ž���Ѵ�. 
		int x = i;
		int y = k;
		
		for(int t=0; t<4; t++) {
			int xx = x + move_x[t];
			int yy = y + move_y[t];
			
			//���� �迭�� ������ ����ٸ� �� ������ �ʿ� ���� ����. ������ �迭 ���̶� �湮ǥ���� �ʿ䵵 ����
			if(xx < 0 || xx >= picture.length || yy < 0 || yy >= picture[0].length) {
				continue;
			}
			
			//���� �̵��Ŀ� �̵� �� ��ǥ�� ���� ����, �̵��� ��ǥ�� ���� Ž������ ���� ���̶��,,, ���ο� ��ǥ�� �������� Ž������ 
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
		answer = s.solution5(m, n, picture);
		
		for(int i=0; i<answer.length;i++) {
			System.out.print(answer[i] + " ");
		}
	}

}