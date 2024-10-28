class Solution {
    /*
        PreRequisites : [ 1 - 0 ]
        inorder to complete course 1 you must first complete course 0 (0 -> 1)

        construct Directed Acyclic Graph - Reverse Toplogical Sorting ( b -> a )
    */

    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        // create Graph using AdjacancyList
        List<Integer>[] adjList = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++)
            adjList[i] = new ArrayList<>();

        // add Directed Edges
        for(int[] pre : prerequisites)
        {
            // prereq(1, 0) = ( 0 -> 1 )
            int u = pre[0];
            int v = pre[1];

            // reverse Edge must take C*0 before C*1           
            adjList[v].add(u);
        }

        // Indegree for each Vertices
        int[] inDegree = new int[numCourses];
        for(int u=0; u<numCourses; u++)
        {
            for(int v : adjList[u])
            {
                inDegree[v]++;
            }
        }

        // add to Queue -  indegree == 0 ( Khan's Algo )
        Deque<Integer> q = new ArrayDeque<>();
        for(int v=0; v<numCourses; v++)
        {
            if(inDegree[v] == 0)
                q.addLast(v);
        }

        // Topological Sorting Order
        List<Integer> topoSort = new ArrayList<>();

        while(!q.isEmpty())
        {
            // add to topoSort
            int u = q.removeFirst();
            topoSort.add(u);

            // remove curr Vertex from Graph
            for(int v : adjList[u])
            {
                // indegree == 0 add to Queue
                if(--inDegree[v] == 0)
                    q.addLast(v);
            }
        }

        // Cycle Exits can't take All Courses
        if(topoSort.size() != numCourses)
            return new int[0];

        // topoSorting contains all Courses - Schedule
        return topoSort.stream().mapToInt(Integer::intValue).toArray();
    }
}
