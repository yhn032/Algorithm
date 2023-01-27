import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        List<Integer> set = new ArrayList<>();
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i == 0) {
                set.add(i);
                if(n/i != i) set.add(n/i);
                //약수의 제곱수가 처음에 주어진 수가 아닌지 파악하는 지점이다. 
                //맞다면 한 번만 넣고 아니라면 인수 두 개를 모두 포함
            }
            
        }
        
        answer = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}
