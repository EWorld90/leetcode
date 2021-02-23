package dailytopic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class T643 {
	
	@Test
	public void test() {
		int[] nums = {1,12,-5,-6,50,3};
		
		System.out.println(findMaxAverage(nums, 4));
		assertEquals(findMaxAverage(nums, 4), 12.75, 0.001);	//junit比较double值需要第三个参数指定允许误差
	}
	
	public double findMaxAverage(int[] nums, int k) {
		int res = 0;
		
		int left = 0, right = k - 1;
		int tempSum = 0;
		
		//初始化滑动窗口
		for(int i = 0; i < k; i++) {
			tempSum += nums[i];
		}
		left++;
		right++;
		res = tempSum;
		
		while(right < nums.length) {
			tempSum = tempSum - nums[left - 1] + nums[right];
			res = Math.max(tempSum, res);
			left++;
			right++;
		}
		
		return (1.0 * res) / k;
    }
}
