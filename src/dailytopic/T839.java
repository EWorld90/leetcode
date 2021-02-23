package dailytopic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class T839 {
	
	@Test
	public void test() {
		String[] strs = {"kmrsb","kmbsr","kmsbr","kmsrb"};
		assertEquals(numSimilarGroups(strs), 1);
	}
	
	public int numSimilarGroups(String[] strs) {
		int groupSize = strs.length;
		int strSize = strs[0].length();
		
		UnionFind uf = new UnionFind(groupSize);
		int notSameCount;
		for(int i = 0; i < groupSize - 1; i++) {
			for(int j = i + 1; j < groupSize; j++) {
				notSameCount = 0;
				
				for(int k = 0; k < strSize; k++) {
					if(strs[i].charAt(k) != strs[j].charAt(k)) {
						notSameCount++;
					}
					
					if(notSameCount > 2)
						break;
				}
				
				if(notSameCount <= 2) {
					if( !uf.isConnected(i, j) ) {
						uf.merge(i, j);
//						System.out.println("mergeing:" + i + " " + j);
					} else {
//						System.out.println("has merged:" + i + " " + j);
					}
				} else {
//					System.out.println("deny:" + i + " " + j);
				}
			}
		}
		
		return uf.setCount;
    }
	
	/**
	 * 并查集模板
	 * @author EW
	 *
	 */
	public class UnionFind {
		int[] elem = {};	//父节点
		int[] rank = {};	//树的秩
		int setCount;		//连通分量数
		
		public UnionFind(int size) {
			elem = new int[size];
			rank = new int[size];
			setCount = size;
			init();
		}
		
		public void init() {
			for(int i = 0; i < elem.length; i++) {
				elem[i] = i;
				rank[i] = 1;
			}
		}
		
		public int find(int x) {
			return x == elem[x] ? x : (elem[x] = find(elem[x]));
		}
		
		public void merge(int i, int j) {
			int x = find(i), y = find(j);	//先找到两个根节点
			
		    if (rank[x] <= rank[y])
		    	elem[x] = y;
		    else
		    	elem[y] = x;
		    if (rank[x] == rank[y] && x != y)
		        rank[y]++; 					//如果深度相同且根节点不同，则新的根节点的深度+1
		    
		    setCount--;						//有两节点合并，连通分量数减1
		}
		
		public boolean isConnected(int x, int y) {
	        x = find(x);
	        y = find(y);
	        return x == y;
	    }
		
	}

}
