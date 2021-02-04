package done;

public class T424 {
	
	
	public int characterReplacement(String s, int k) {
		if(s.length() < 2) {
			return s.length();
		}
		
		int res = 0;
		
		int left = 0, right = 0;
		int tempCount = 0;
		int[] charCount = new int[26];
		while(right < s.length()) {
			charCount[s.charAt(right) - 'A']++;
			tempCount = Math.max(tempCount, charCount[s.charAt(right) - 'A']);
			right++;
			
			if(right - left > tempCount + k) {
				charCount[s.charAt(left) - 'A']--;
				left++;
			}
			
			res = Math.max(res, right - left);
		}
		
		return res;
    }
}