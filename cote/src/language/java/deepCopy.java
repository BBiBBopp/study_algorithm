package language.java;

import java.util.HashMap;
import java.util.Map.Entry;

public class deepCopy {
	public static void main(String[] args) {
		HashMap<String, String> origMap = new HashMap<String, String>();
		origMap.put("TITLE", "제목");
		
		System.out.println("원본 Map : " + origMap.toString());
		System.out.println("=============");
		
		
		// 얕은 복사 (Shallow copy) : 주소값 복사 (참조하고있는 실제 값은 동일함)
		HashMap<String, String> shallowCopy = origMap;
		origMap.put("CONTENT", "내용");
		System.out.println("원본 Map : " + origMap.toString());
		System.out.println("얕은 복사 Map : " + shallowCopy.toString());
		System.out.println("=============");
		
		// 깊은 복사(deep copy) : 실제 값을 새로운 메모리 공간에 복사
		// 1. 생성자를 이용한 복사
		HashMap<String, String> copyMap = new HashMap<String, String>(origMap);
		System.out.println("원본 Map : " + origMap.toString());
		System.out.println("생성자 복사 Map : " + copyMap.toString());
		System.out.println("=============");
		
		// 2. clone()을 이용한 복사
		HashMap<String, String> cloneMap = (HashMap<String, String>)origMap.clone();
		System.out.println("원본 Map : " + origMap.toString());
		System.out.println("clone 복사 : " + cloneMap.toString());
		System.out.println("=============");
		
		// 3. putAll()을 이용한 복사
		HashMap<String, String> putMap = new HashMap<String, String>();
		putMap.putAll(origMap);
		
		System.out.println("원본 Map : " + origMap.toString());
		System.out.println("putAll 복사 : " + putMap.toString());

		// Map.Entry 를 이용한 복사
		HashMap<String, String> entryMap = new HashMap<String, String>();
		
		for (Entry<String, String> entry : origMap.entrySet()) {
			entryMap.put(entry.getKey(), entry.getValue());
		}
		origMap.put("WRITER", "홍길동");
		System.out.println("원본 Map : " + origMap.toString());
		System.out.println("Map.Entry : " + entryMap.toString());
	}
}
