package dailytopic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class T448 {
	
	@Test
	public void test() {
		int[] nums = {4,3,2,7,8,2,3,1};
		
		assertEquals((int)findDisappearedNumbers(nums).get(0), 5);		
	}
	
	/*
	 * 在原数组上修改 令出现的数对应的位置都加上len 
	 * 最后对应位置不大于len则没出现过
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		
		int len = nums.length;
		for(int i = 0; i < len; i++) {
			//防止数字出现过，将对应位置对 n 取模来还原出它本来的值
			int x = (nums[i] - 1) % len;
			nums[x] += len;
		}
		
		for(int i = 0; i < len; i++) {
			if(nums[i] <= len) {
				res.add(i + 1);
			}
		}
		
		return res;
    }
	
}
