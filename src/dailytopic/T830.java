package dailytopic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class T830 {
	
	@Test
    public void testSum1() {
		List<List<Integer>> resList = largeGroupPositions("aaa");
		System.out.println("res length£º" + resList.size());
		int test = resList.get(0).get(0);
		Assert.assertEquals((int) resList.get(0).get(0), 0);
		Assert.assertEquals((int) resList.get(0).get(1), 2);
    }
	
	public List<List<Integer>> largeGroupPositions(String s) {
		List<List<Integer>> res = new ArrayList<>();
		int left = 0;
		
		while (left < s.length()) {
            int count = 0;
            
            while (left + count < s.length() && s.charAt(left) == s.charAt(left + count))
                count++;
            
            if (count >= 3)
                res.add(Arrays.asList(left, left + count - 1));
            
            left = left + count;
        }

    	return res;
    	
    }

}