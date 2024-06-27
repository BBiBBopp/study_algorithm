package programmers.Lv1;

public class N131128 {

	public static void main(String[] args) {
		System.out.println(solution("100", "100"));

	}
	
	// ¼ýÀÚ Â¦²á
	public static String solution(String X, String Y) {
        int[] Xarr = stringToArr(X);
        int[] Yarr = stringToArr(Y);

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--){
        	for(int j=0; j<Math.min(Xarr[i], Yarr[i]); j++){
        		sb.append(i);
        	}
        }
        
        return (sb.length() > 0) ? (sb.toString().indexOf("0") == 0 ? "0" : sb.toString()) : "-1";
    }
	
	public static int[] stringToArr(String str){
		int[] numbers = new int[10];
		
		int n;
		for(int i=0; i<str.length(); i++){
			n = Integer.parseInt(str.substring(i, i+1));
			numbers[n] += 1;
		}
		
		return numbers;
	}
}
