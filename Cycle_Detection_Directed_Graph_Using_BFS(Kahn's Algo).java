import java.util.*;
class Solution
{
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree = new int[N];
        for(int i = 0; i<N; i++)
        {
            for(Integer it : adj.get(i))
                indegree[it]++;
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0; i<N; i++)
        {
            if(indegree[i] == 0)
                qu.add(i);
        }
        int count = 0;
        while(qu.isEmpty())
        {
            int node = qu.poll();
            count++;
            for(Integer it : adj.get(node))
            {
                indegree[it]--;
                if(indegree[it] == 0)
                    qu.add(it);
            }
        }
        if(count == N)
            return false;
        return true;
    }
}