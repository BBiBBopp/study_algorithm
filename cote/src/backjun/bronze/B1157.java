package backjun.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class B1157 {
	
	/*
	 * 문장에서 가장 많이 사용되는 단어 출력, 가장 많이 사용되는 알파벳이 여러개일 경우 ? 출력
	 * 
	 * Mississipi
	 */

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		String[] spells = br.readLine().toUpperCase().split("");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<spells.length; i++){
			if(map.get(spells[i]) == null){
				map.put(spells[i], 1);
			} else {
				map.put(spells[i], map.get(spells[i]) + 1);
			}
		}
		
		int max = 0;
		String maxSpell = null;
		for(Entry<String, Integer> entrySet : map.entrySet()){
			if(max < entrySet.getValue()){
				max = entrySet.getValue();
				maxSpell = entrySet.getKey();
			} else if(max == entrySet.getValue()) {
				maxSpell = "?";
			}
		}
		
		bw.write(maxSpell); // 버퍼에 넣을 내용
		bw.flush(); // 내용 출력
		bw.close(); // 종료
	}
}
