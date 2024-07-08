package programmers.Lv1;


public class N67256 {

	public static void main(String[] args) {

		System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
	}
	
	// 키패드 누르기
	public static String solution(int[] numbers, String hand) {
		mainHand = (hand.equals("left") ? "L" : "R"); 
		
        StringBuilder sb = new StringBuilder();
        String push;
        for(int number : numbers){
        	push = pushNumber(number);
        	sb.append(push);
        	
        	if(push.endsWith("R")){
        		leftIdx = numberPad[number];
        	} else {
        		rightIdx = numberPad[number];
        	}
        }
        
        return sb.toString();
        
        /* 내 풀이
         * 
        int[] leftIdx = {3, 0};
        int leftDiff;
        
        int[] rightIdx = {3, 2};
        int rightDiff;
        
        int[][] numberArr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {11, 0, 12}};
        StringBuilder sb = new StringBuilder();
        for(int number : numbers){
        	for(int i=0; i<numberArr.length; i++){
        		for(int j = 0; j<numberArr[i].length; j++){
        			if(number == numberArr[i][j]){
        				if(j == 0) {
        					leftIdx[0] = i;
        					leftIdx[1] = j;
        					sb.append("L");
        				} else if(j == 2){
        					rightIdx[0] = i;
        					rightIdx[1] = j;
        					sb.append("R");
        				} else {
        					leftDiff = Math.abs(i-leftIdx[0]) + Math.abs(j-leftIdx[1]);
        					rightDiff = Math.abs(i-rightIdx[0]) + Math.abs(j-rightIdx[1]);
        					
        					if(leftDiff < rightDiff) {
        						leftIdx[0] = i;
            					leftIdx[1] = j;
            					sb.append("L");
        					} else if(rightDiff < leftDiff){
        						rightIdx[0] = i;
            					rightIdx[1] = j;
            					sb.append("R");
        					} else {
        						if(hand.equals("left")){
        							leftIdx[0] = i;
                					leftIdx[1] = j;
                					sb.append("L");
        						} else {
        							rightIdx[0] = i;
                					rightIdx[1] = j;
                					sb.append("R");
        						}
        					}
        				}
        			}
        		}
        	}
        }
        
        return sb.toString();
        */
    }
	
	static int[][] numberPad = {
			// 인덱스 == 입력 숫자
    		{3, 1},	// 0
    		{0, 0}, // 1
    		{0, 1}, // 2
    		{0, 2}, // 3
    		{1, 0}, // 4
    		{1, 1}, // 5
    		{1, 2}, // 6
    		{2, 0}, // 7
    		{2, 1}, // 8
    		{2, 2}  // 9
    };
	
	// 다른 풀이 Start
	static int[] leftIdx = {3, 0};
	static int[] rightIdx = {3, 2};
	
	static String mainHand;
	
	public static String pushNumber(int num){
		if(num==1 || num==4 || num==7) return "L";
		if(num==3 || num==6 || num==9) return "R";
		
		
		if(getDist(leftIdx, num) > getDist(rightIdx, num)) return "R";
		if(getDist(leftIdx, num) < getDist(rightIdx, num)) return "L";
		
		return mainHand;
	}
	
	/**
	 * @param pos : 현재 손가락 위치
	 * @param num : 입력 숫자
	 * @return 	  : 현재 손가락 위치와 입력 숫자 사이의 거리
	 */
	public static int getDist(int[] pos, int num){
		return Math.abs(pos[0]-numberPad[num][0]) + Math.abs(pos[1] - numberPad[num][1]);
	}
	// 다른 풀이 End

}
