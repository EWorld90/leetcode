package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T1002 {
	public static List<String> commonChars(String[] A) {
		int[] allFreq = new int[26];
		Arrays.fill(allFreq, Integer.MAX_VALUE);
		List<String> result = new ArrayList<String>();
		
		for(String letter : A) {
			int[] indFreq = new int[26];
			
			//遍历当前字符串
			for(int i=0; i<letter.length(); i++) {
				int temp = letter.charAt(i) - 'a';	//提取字母对应的数字
//				System.out.println("当前字母" + letter.charAt(i) + "，数字" + temp);	//test
				indFreq[temp]++;
			}
			
			//对比结果数组
			for(int i=0; i<26; i++) {
				allFreq[i] = Math.min(allFreq[i], indFreq[i]);
			}
		}
		
		//结果导入列表
		for(int i=0; i<26; i++) {
			for(int j=0; j<allFreq[i]; j++) {
				result.add(String.valueOf((char) (i + 'a')));
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		String[] str = {"apple", "above", "abbreviate"};
		
		List<String> test = commonChars(str);
		for(int i=0; i < test.size(); i++) {
			System.out.println(test.get(i));
		}
	}
}
