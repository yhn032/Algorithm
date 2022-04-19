package Kakao;

class Solution {
    public static int calcDist(int location, int value){
        //값이 0이거나 현재 위치가 0이면 키보드 인덱스 값 11을 넣어준다. 
        if(value == 0){
            value = 11;
        }
        if(location == 0){
            location = 11;
        }
        //왼손, 오른손 좌표 구하기 
        //location-1을 해줘서 인덱스를 0base로 해줘야 자신으로부터 거리가 1부터시작이 아닌 0부터 시작한다.
        int locationX = (location-1)/3;
        int locationY = (location-1)%3;
        
        int valueX = (value-1)/3;
        int valueY = (value-1)%3;
        
        int result = Math.abs(locationX - valueX) + Math.abs(locationY-valueY);
        return result;
    }
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int LHandPos=10;
        int RHandPos=12;
        for(int i=0; i<numbers.length; i++){
            //왼손이 움직이는 경우
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                LHandPos = numbers[i]; 
            }
            //오른손이 움직이는 경우
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                RHandPos = numbers[i]; 
            }else {
                //거리 계산이 필요한 경우(키패드의 중간열인 경우)
                int leftDist  = calcDist(LHandPos, numbers[i]);
                int rightDist = calcDist(RHandPos, numbers[i]);
                //왼손이 더 멈. 오른손으로 눌러야 하는 경우
                if(leftDist > rightDist){
                    answer += "R";
                    RHandPos = numbers[i];                   
                }
                //오른손이 더 멈. 왼손으로 눌러야 하는 경우
                else if(leftDist < rightDist){
                    answer += "L";
                    LHandPos = numbers[i];
                }
                //양 손에서부터 거리가 같은 경우
                else{
                    if(hand.equals("right")){
                        answer += "R";
                    	RHandPos = numbers[i];
                    }else{
                        answer += "L";
                    	LHandPos = numbers[i];
                    }
                }
            }
        }
        return answer;
    }
}
public class EnterKeyPad {
	public static void main(String[] args) {
		Solution s = new Solution();
		int numbers[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		System.out.println(s.solution(numbers, hand));
	}
}
