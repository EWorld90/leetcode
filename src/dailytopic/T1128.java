package dailytopic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class T1128 {
	
	@Test
	public void test() {
		int[][] dominoes = {{1,2},{2,1},{1,2},{2,2},{2,2},{3,2}};
		
		assertEquals(numEquivDominoPairs(dominoes), 4);
	}
	
	public int numEquivDominoPairs(int[][] dominoes) {
		int count = 0;
		
		int[] dominoMap = new int[100];
		int dominoLoc = 0;
		for(int i = 0; i < dominoes.length; i++) {
			if(dominoes[i][0] <= dominoes[i][1]) {
				dominoLoc = dominoes[i][0] * 10 + dominoes[i][1];
			} else {
				dominoLoc = dominoes[i][1] * 10 + dominoes[i][0];
			}
			
			count += dominoMap[dominoLoc];
			dominoMap[dominoLoc] += 1;
			
		}
		
		return count;
    }
}
