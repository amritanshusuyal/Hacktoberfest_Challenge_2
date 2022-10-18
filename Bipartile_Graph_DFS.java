import java.util.*;
class Solution{
    boolean DFS(int node, ArrayList<ArrayList<Integer>> adj, int[] color)
    {
        if(color[node] == -1)
        {
            color[node] = 1;
        }
        for(Integer it : adj.get(node))
        {
            if(color[it] == -1)
            {
                color[it] = 1 - color[node];
                if(!DFS(it, adj, color))
                {
                    return false;
                }
            }
            else if(color[it] == color[node])
                return false;
        }
        return true;
    }
    boolean Bipartile(int N, ArrayList<ArrayList<Integer>> adj)
    {
        int[] color = new int[N];
        for(int i = 0; i<N; i++)
        {
            color[i] = -1;
        }
        for(int i = 0; i<N; i++)
        {
            if(color[i] == -1)
            {
                if(DFS(i, adj, color))
                    return true;
            }
        }
        return false;
    }
}