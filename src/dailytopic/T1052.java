package dailytopic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class T1052 {
	
	@Test
	public void test() {
		int[] customers = {1,0,1,2,1,1,7,5};
		int[] grumpy = {0,1,0,1,0,1,0,1};
		int X = 3;
		
		assertEquals(maxSatisfied(customers, grumpy, X), 16);
	}
	
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int res = 0;
		
		int tempSum = 0;
		//遍历一次 将没有生气时的顾客数量加进tempSum里，然后原位置置为0
		for(int i = 0; i < customers.length; i++) {
			if(grumpy[i] == 0) {
				tempSum += customers[i];
				customers[i] = 0;
			}
		}
		
		//然后再遍历一次 并用滑动窗口筛选最大值
		for(int i = 0; i < X; i++) {
			tempSum += customers[i];
		}
		
		res = tempSum;
		int left = 1, right = X;
		
		while(right < customers.length) {
			tempSum = tempSum - customers[left - 1] + customers[right];
			res = Math.max(res, tempSum);
			
			left++;
			right++;
		}
		
		return res;
    }
	
	public int maxSatisfiedExample(int[] cs, int[] grumpy, int x) {
        int n = cs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                ans += cs[i];
                cs[i] = 0;
            }
        }
        int max = 0, cur = 0;
        for (int i = 0, j = 0; i < n; i++) {
            cur += cs[i];
            if (i - j + 1 > x) cur -= cs[j++];
            max = Math.max(max, cur);
        }
        return ans + max;
    }
}
