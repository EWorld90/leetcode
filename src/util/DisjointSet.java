package util;

public class DisjointSet {
	int[] elem = {};
	int[] rank = {};
	
	public DisjointSet(int size) {
		elem = new int[size];
		rank = new int[size];
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
		int x = find(i), y = find(j);    //先找到两个根节点
		
	    if (rank[x] <= rank[y])
	    	elem[x] = y;
	    else
	    	elem[y] = x;
	    if (rank[x] == rank[y] && x != y)
	        rank[y]++; 
	}
	
	public boolean connected(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
	
}
