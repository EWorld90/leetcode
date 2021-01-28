package done;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class T724 {
	
	@Test
	public void test() {
//		int[] nums = {1, 7, 3, 6, 5, 6};	//return 3
//		int[] nums = {1};	//return 0
		int[] nums = {1, 2, 3};		//return -1
		assertEquals(pivotIndex(nums), -1);
	}
	
	public int pivotIndex(int[] nums) {
		int index = -1;
		
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		
		int leftSum = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] + 2 * leftSum == sum) {
				index = i;
				break;
			}
			leftSum += nums[i];
		}
		
		return index;
    }
	//优化思路 双指针一次遍历
}
