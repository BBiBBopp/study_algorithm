package programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class N250121 {

    // data [code, date, maximum, remain]
    // ext : 가공 조건 
    // val_ext : 가공 기준값 (보다 작은 값)
    // sort_by : 정렬 조건 (오름차순)
    
	public static void main(String[] args) {
		int[][] data = new int[][] {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
		String ext = "date";
		int val_ext = 20300501;
		String sort_by = "remain";
		
		solution(data, ext, val_ext, sort_by);
	}
	
	static int val_index;
	public static ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<String> val_data = new ArrayList<>(Arrays.asList("code", "date", "maximum", "remain"));
        val_index = val_data.indexOf(ext);
        
        ArrayList<int[]> dataList = new ArrayList<>();
        for(int i=0; i<data.length; i++){
        	if(data[i][val_index] < val_ext){
        		dataList.add(data[i]);
        	}
        }
        
        val_index = val_data.indexOf(sort_by);
        Collections.sort(dataList, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[val_index] - o2[val_index];
			}
        });
        
        return dataList;
    }

	
	
}

/*
 * Arrays.sort (배열), Collections.sort (리스트) 정렬 조건 직접 설정하기
  
   Collections.sort(sort_data, new Comparator<int[]>() {
  		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[val_index] - o2[val_index];
		}
   }
  
  -> return 값이 0이나 음수면 자리바꿈을 하지 않고, 양수면 자리바꿈을 수행함
     o1이 o2보다 크면 자리바꿈 > 오름차순 정렬
  
  -- 
  * 다중 배열이 아닌 경우 역순 정렬 : Collections.reverseOrder
 */