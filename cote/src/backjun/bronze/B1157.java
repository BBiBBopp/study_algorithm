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
	 * ���忡�� ���� ���� ���Ǵ� �ܾ� ���, ���� ���� ���Ǵ� ���ĺ��� �������� ��� ? ���
	 * 
	 * Mississipi
	 */

	public static void main(String[] args) throws IOException {
		// �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ���
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
		
		bw.write(maxSpell); // ���ۿ� ���� ����
		bw.flush(); // ���� ���
		bw.close(); // ����
	}
}
