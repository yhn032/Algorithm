class Solution {
    Integer [][] combination;
    public int solution(int balls, int share) {
        int answer = 0;
        combination = new Integer[balls+1][share+1];
        combination[0][0] = 0;
        combination[0][1] = 0;
        combination[1][0] = 1;
        combination[1][1] = 1;
        combination[balls][share] = dfs(balls, share);
        
        return combination[balls][share];
    }
    
    public int dfs(int balls, int share){
        if(balls < 0 || share < 0) return 0;
		if(combination[balls][share] != null) return combination[balls][share];
		else return dfs(balls-1,share) + dfs(balls-1,share-1);
    }
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120840
