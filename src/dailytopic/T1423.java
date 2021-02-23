package dailytopic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class T1423 {
	
	@Test
	public void test() {
		int[] cardPoints = {100,40,17,9,73,75};
		
		assertEquals(maxScore(cardPoints, 3), 248);
	}
	
	
	public int maxScore(int[] cardPoints, int k) {
		int res = 0;
		
		int sum = 0;
		for(int card : cardPoints) {
			sum += card;
		}
		
		int window = cardPoints.length - k;
		int left = 1, right = window;
		
		int tempSum = 0;
		for(int i = 0; i < right; i++) {
			tempSum += cardPoints[i];
		}
		res = tempSum;
		
//		System.out.println("start: left:" + cardPoints[0] + " right:" + cardPoints[window-1]);
//		System.out.println("tempSum:" + tempSum);
		while(right < cardPoints.length) {
//			System.out.println("now: left:" + cardPoints[left] + " right:" + cardPoints[right]);
			
			tempSum = tempSum - cardPoints[left - 1] + cardPoints[right];
//			System.out.println("tempSum:" + tempSum);
			
			res = Math.min(tempSum, res);
//			System.out.println("min:" + tempSum);
			
			left++;
			right++;
		}
		
		return sum - res;
    }
}
