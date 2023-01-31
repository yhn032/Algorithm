import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] array) {
    // SOL 1 >
    // Map<Integer, Integer> map = new HashMap<>();
    // for(int i=0; i<array.length; i++){
    //     map.put(array[i], i);
    // }
    // Arrays.sort(array);
    // int [] answer = {array[array.length-1], map.get(array[array.length-1])};
    // return answer;
      
    //SOL 2 >
    List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
		int max = list.stream().max(Integer::compareTo).orElse(0);
		int idx = list.indexOf(max);
		return new int[] {max, idx};
    }
}
