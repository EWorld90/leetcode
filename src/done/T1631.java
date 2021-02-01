package done;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T1631 {
	public int minimumEffortPath(int[][] heights) {
		int res = 0;
		
		int m = heights.length;
        int n = heights[0].length;
        
        List<int[]> edges = new ArrayList<int[]>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int id = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        Collections.sort(edges, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });
        
        UnionFind uf = new UnionFind(m * n);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2];
            uf.merge(x, y);
            if (uf.isConnected(0, m * n - 1)) {
            	res = v;
                break;
            }
        }
        
		return res;
    }
}

class UnionFind {
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

