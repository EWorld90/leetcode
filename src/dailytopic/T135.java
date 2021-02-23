package dailytopic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class T135 {
	
	@Test
	public void test() {
		int[] ratings = {1,2,2};
		assertEquals(candy(ratings), 4);
	}
	
	public int candy(int[] ratings) {
		if(ratings.length == 0) {
			return 0;
		} else if(ratings.length == 1) {
			return 1;
		}
		
		int[] count = new int[ratings.length];
		for(int i=0; i < ratings.length; i++) {
			count[i] = 1;
		}
		
		//左到右遍历
		for(int i = 1; i < ratings.length; i++) {
			if(ratings[i] > ratings[i-1]) {
				count[i] = count[i-1] + 1;
			}
		}
		//右到左遍历
		for(int i = ratings.length - 1; i > 0; i--) {
			if(ratings[i-1] > ratings[i]) {
				count[i-1] = Math.max(count[i-1], count[i] + 1);
			}
		}
		
		int res = 0;
		for(int i=0; i < ratings.length; i++) {
			res = res + count[i];
		}
		return res;
    }
}
