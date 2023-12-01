import java.util.Arrays;

class Solution_CalcString {
    public int solution(String my_string) {
        //SOL 1 >
        int answer = 0;
        String txt[] = my_string.split(" ");
        boolean plus = true;
        for(int i=0; i<txt.length; i++){
            if(i%2 == 0){
                int t = Integer.parseInt(txt[i]);
                if(plus) answer += t;
                else answer -= t;
            }else{
                if(txt[i].equals("-")) plus = false;
                else plus = true;
            }
            
        }
        return answer;
        
        //SOL 2 >
        //return Arrays.stream(my_string.replaceAll("- ", "-").replaceAll("\\+ ", "").trim().split(" ")).mapToInt(Integer::parseInt).sum();
    }
}
