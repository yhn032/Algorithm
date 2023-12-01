/*
  1. 폰켓몬 번호를 Set에 담아서 중복을 제거한다.
  2. 배열의 크기의 반을 max값에 담아두고, set에 담긴 사이즈와 비교한다. 
  3. 반이 더 크다면 사이즈 값을, 더 작다면 반의 값을 넣는다.
*/
import java.util.*;
class Solution_Poket {
    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length/2;
        
        Set<Integer> ss = new HashSet();
        for(int i=0; i<nums.length; i++){
            ss.add(nums[i]);
        }
        answer = ss.size() > max ? max : ss.size();
        return answer;
    }
}
