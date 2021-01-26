package done;

import java.util.*;

public class T763 {
	//贪心算法
	public List<Integer> partitionLabels(String S) {
		int[] charNum = new int[26];
		//统计每个字母最后出现的位置
		for (int i = 0; i < S.length(); i++) {
			charNum[(int) S.charAt(i) - 'a'] = i;
		}
		
		List<Integer> result = new ArrayList<Integer>();
		int start = 0, end = 0;
		for (int i = 0; i < S.length(); i++) {
			end = Math.max(end, charNum[(int) S.charAt(i) - 'a']);
			
			//end值等于下标时，找到符合的片段，重置start,end的值
			if (end == i) {
				result.add(end - start + 1);
				start = end + 1;
			}
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
