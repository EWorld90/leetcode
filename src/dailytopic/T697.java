package dailytopic;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class T697 {
	
	@Test
	public void test() {
		int[] nums = {1,2,1,3,3,2};
		
		assertEquals(findShortestSubArray(nums), 2);
	}
	
	public int findShortestSubArray(int[] nums) {
		int res = Integer.MAX_VALUE;
		
		Map<Integer, int[]> numMap = new HashMap<>();
		int degree = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(!numMap.containsKey(nums[i])) {
				numMap.put(nums[i], new int[] {1, i, i});
			} else {
				numMap.get(nums[i])[0] ++;
				numMap.get(nums[i])[2] = i;
				degree = Math.max(numMap.get(nums[i])[0], degree);
			}
		}
		
		for (Map.Entry<Integer, int[]> entry : numMap.entrySet()) {
			int[] temp = entry.getValue();
			
			//检查度是否为最大
			if(temp[0] >= degree) {
				//检查首尾差是否为最小
				res = Math.min(res, temp[2] - temp[1] + 1);
			}
		}
		
		return res;
    }
}
