package backjun.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.stream.Stream;

public class B2920 {
	static String asc = "ascending";
	static String desc = "descending";
	static String mix = "mixed";
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] numbers = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 검색해보기 
		int before = numbers[0];
		int after = 0;
		String answer = null;
		
		if(before == 1){
			answer = asc;
		} else if(before == 8){
			answer = desc;
		} else {
			answer = mix;
		}
		
		for(int i=1; i<numbers.length; i++){
			after = numbers[i];
			if(before < after && answer.equals(asc)){
				before = after;
			} else if(before > after && answer.equals(desc)) {
				before = after;
			} else {
				answer = mix;
			}
		}
		
		bw.write(answer);
		bw.flush(); 
		bw.close(); 
	}
	
	// 다른 풀이
	public void other() {
        Scanner sc = new Scanner(System.in);
        int[]arr = new int[7];
        String result = "";

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            // 인덱스 0번째는 1 == (인덱스 0번째 + 1) -1  = 1 2 3 4 5 6 7 8
            if (arr[i] == arr[i + 1] - 1){
                result = "ascending";
            }// 인덱스 0번째는 8 == (인덱스 0번째 + 1) + 1 = 8 7 6 5 4 3 2 1
            else if (arr[i] == arr[i + 1] + 1) {
                result = "descending";
            }else {
                result = "mixed";
                break;
            }

        }
        System.out.println(result);
    }
}
