package done;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

public class T455 {

	@Test
    public void testFact() {
        int[] g = {1, 2, 3, 4};
        int[] s = {1, 2, 3, 1};
        
        assertEquals(findContentChildren(g, s), 3);;
	}

	public int findContentChildren(int[] g, int[] s) {
		int count = 0;
		
		Arrays.sort(g);
		Arrays.sort(s);
		
		int i = 0, j = 0;
		while(i < g.length && j < s.length) {
			if(g[i] <= s[j]) {
				count++;
				i++;
				j++;
			} else {
				j++;
			}
		}
		
		return count;
    }
	
}
