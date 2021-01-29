package util;

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
	
	public boolean connected(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
	
}
