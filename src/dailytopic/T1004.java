package dailytopic;

public class T1004 {
	
	public int longestOnes(int[] A, int K) {
		int res = 0;
		
		int left = 0, right = 0;
		int tempZero = 0;
		
		while(right < A.length) {
			if(A[right] == 0)
				tempZero ++;
			
			while(tempZero > K) {
				if(A[left] == 0)
					tempZero --;
				left ++;
			}
			
			res = Math.max(res, right - left + 1);
			
			right ++;
		}
		
		return res;
    }
}
