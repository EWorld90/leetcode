package done;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class T1579 {
	@Test
	public void test() {
//		int n = 4;
//		int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};	//return 2
//		int[][] edges = {{3,2,3},{1,1,2},{2,3,4}};	//return -1
		int n = 2;
		int[][] edges = {{1,1,2},{2,1,2},{3,1,2}};	//return 2
		assertEquals(maxNumEdgesToRemove(n, edges), 2);
	}
	
	public int maxNumEdgesToRemove(int n, int[][] edges) {
		DisjointSet dsa = new DisjointSet(n);
		DisjointSet dsb = new DisjointSet(n);
		int count = 0;
		
		//处理原始数据，将原始数据从基1改为基0
		for(int[] edge: edges) {
			edge[1] -= 1;
			edge[2] -= 1;
		}
		
		//处理公共边
		for(int[] edge: edges) {
			if(edge[0] == 3) {
				if(!dsa.isConnected(edge[1], edge[2]) && !dsa.isConnected(edge[1], edge[2])) {
					dsa.merge(edge[1], edge[2]);
					dsb.merge(edge[1], edge[2]);
				} else {
					count += 1;
				}
			}
		}
		
		//处理独占边
		for(int[] edge: edges) {
			if(edge[0] == 1) {
				if(!dsa.isConnected(edge[1], edge[2])) {
					dsa.merge(edge[1], edge[2]);
				} else {
					count += 1;
				}
			} 
			if(edge[0] == 2) {
				if(!dsb.isConnected(edge[1], edge[2])) {
					dsb.merge(edge[1], edge[2]);
				} else {
					count += 1;
				}
			}
		}
		
		if(dsa.r == 1 && dsb.r == 1) {
			return count;
		}
		else {
			return -1;
		}
    }
}

class DisjointSet {
	int[] elem = {};
	int[] rank = {};
	int r = 0;
	
	public DisjointSet(int size) {
		elem = new int[size];
		rank = new int[size];
		r = size;
		init();
	}
	
	public void init() {
		for(int i = 0; i < elem.length; i++) {
			elem[i] = i;
			rank[i] = 1;
		}
	}
	
	public int find(int x) {
		if(x == elem[x])
		    return x;
		else{
		    elem[x] = find(elem[x]);  //父节点设为根节点
		    return elem[x];         //返回父节点
		}
	}
	
	public void merge(int i, int j) {
		int x = find(i), y = find(j);    //先找到两个根节点
		
	    if (rank[x] <= rank[y])
	    	elem[x] = y;
	    else
	    	elem[y] = x;
	    if (rank[x] == rank[y] && x != y)
	        rank[y]++; 
	    
	    r -= 1;
	}
	
	public boolean isConnected(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
	
}
