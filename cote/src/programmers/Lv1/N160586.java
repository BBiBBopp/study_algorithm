package programmers.Lv1;

public class N160586 {

	public static void main(String[] args) {
		solution(new String[]{"ABACD", "BCEFD"}, new String[] {"ABCD","AABB"});

	}
	
	// 대충 만든 자판
	public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        String c;
        int min;
        // 타겟 하나씩
        for(int num=0; num < targets.length; num++){
        	String target = targets[num];
        	
        	// 문자 하나씩
        	for(int i=0; i<target.length(); i++){
        		c = String.valueOf(target.charAt(i));
        		min = Integer.MAX_VALUE;
        		// keymap과 비교함
        		for(int j=0; j<keymap.length; j++){
        			// keymap의 문자에 c가 있고 index가 최소값인 경우
        			if(keymap[j].contains(c) && min > keymap[j].indexOf(c)) {
        				min = keymap[j].indexOf(c) + 1; // index는 0에서부터 시작하므로
        			} 
        			
        			/* 
        			 * 다른 풀이 
        			 * if(keymap[j].contains(c)) min = Math.min(keymap[j].indexOf(c)+1, min);
        			 */
        		}
        		
        		if(min != Integer.MAX_VALUE){
        			answer[num] += min;
        		} else {
        			answer[num] = -1;
        			break;
        		}
        	}
        	
        	System.out.println(answer[num]);
        }
        
        return answer;
    }
	
	// 단순 구현
	public static String[] solution2(String[] card, String[] word){
		
		
		return null;
	}
	
	/*
	 * 	단순 구현 
	 * 
	 	알파벳이 적힌 카드 24잔이 한 줄에 8장씩, 세 줄로 놓여 있습니다. 같은 알파벳이 적힌 카드가 여러 장 있을 수 있으나, 같은 알파벳이 적힌 카드는 반드시 같은 줄에 놓여 있습니다.
		예를 들어,
		의 형태로 놓여있습니다.
		우리는 어떤 단어들이 주어질 때, 각 단어를 주어진 카드로 만들 수 있는지 판별하려고 합니다. 단, 주어진 카드로 만들 때는 반드시 한 줄에 한 카드는 사용해야 합니다.
		예를 들어, 주어진 단어가 ["GPOM", "GPMZ", "EFU", "MMNA"]인 경우
		•"GPQM"라는 단어는
		['ABACDEFG, "NOPQRSTU", "HISKLKMM"]
		
		첫 번째 줄에서 'G', 두 번째 줄에서 'P'와 'Q, 세 번째 줄에서 'M'을 골라 만들 수 있습니다.
		•"GPMZ"라는 단어는
		['ABACDEFG, "NOPQRSTU", "HISKLKMM"]
		
		Z'가 적힌 카드가 없으므로 만들 수 없습니다.
		•"EFU"라는 단어는
		['ABACDEFG, "NOPQRSTU", "HISKLKMM"]
		
		첫 번째 줄에서 'E'와 'F; 두 번째 줄에서 'U'를 고르면 완성되지만, 세 번째 줄에서 카드를 사용하지 않았기 때문에 단어를 만들 수 없습니다.
		•"MMNA"라는 단어는
		['ABACDEFG, "NOPQRSTU", "HISKLKMM"]
		
		세 번째 줄에서 'M' 2개, 두 번째 줄에서 'N; 첫 번째 줄에서 'A'를 골라 만들 수 있습니다.
		알파벳이 적힌 카드 card와 만들어야 하는 단어들 word가 매개변수로 주어질 때, 만들 수 있는 단어들만 return 하는 solution 함수를 완성 해 주세요. 단, 만들 수 있는 단어들을 return 할 때는 매개변수 word의 순서대로 반환하면 됩니다. 위의 예시에서는 [CPQM", "MMNA"] 로 반환하면 됩니다. 또한, 어떤 단어도 만들지 못할 때는 1차원 배열에 "-1"을 넣어 반환해 주세요.
		제한사항
		• card는 길이가 3인 1차원 배열입니다.
		• card의 원소는 길이 8의 string형입니다. 이 문자열은 대문자로만 이루어져 있습니다.
		• word는 1차원 배열로 주어지며, 배열의 길이는 10 이하의 자연수입니다.
		• word의 각 원소는 string형이며, 각 원소의 길이는 24 이하의 자연수입니다
		
		입출력 예
		card ->  word ->   answer
		['ABACDEFG, "NOPQRSTU", "HISKLKMM"] -> ['GPQM", "GPMZ, "EFU", "MMNA] -> ['GPQM", MMNA]
		['AABBCCDD", "KKKKJJJJ", "МОМОМОМО"] -> ['AAAKKKKKMMMMM", ABCDKJ"] -> ['-1"]
		입출력 예 설명
		입출력 예 #1
		문제의 예시와 같습니다.
		입출력 예 #2
		어떠한 단어도 만들지 못하기 때문에 ["-1"]를 반환합니다.
	 */

}
