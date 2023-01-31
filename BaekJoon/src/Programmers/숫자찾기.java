class Solution {
    public int solution(int num, int k) {
        //SOL 1 > 
        int answer = 0;
        String tmp[] = String.valueOf(num).split("");
        for(int i=0; i<tmp.length; i++){
            if(Integer.parseInt(tmp[i]) == k){
                answer = i+1; break;
            }
        }
        if(answer == 0) return -1;
        else return answer;
        
        //SOL 2 >
        return ("-" + num).indexOf(String.valueOf(k));
    }
}
