package done;

import java.util.*;

public class T763 {
	//̰���㷨
	public List<Integer> partitionLabels(String S) {
		int[] charNum = new int[26];
		//ͳ��ÿ����ĸ�����ֵ�λ��
		for (int i = 0; i < S.length(); i++) {
			charNum[(int) S.charAt(i) - 'a'] = i;
		}
		
		List<Integer> result = new ArrayList<Integer>();
		int start = 0, end = 0;
		for (int i = 0; i < S.length(); i++) {
			end = Math.max(end, charNum[(int) S.charAt(i) - 'a']);
			
			//endֵ�����±�ʱ���ҵ����ϵ�Ƭ�Σ�����start,end��ֵ
			if (end == i) {
				result.add(end - start + 1);
				start = end + 1;
			}
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
