/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0,
and to take course 0 you should also have finished course 1. So it is impossible.
*/
public class _207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, i, visited, onStack))
                return false;
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int v, boolean[] visited, boolean[] onStack) {
        List<Integer> adj = graph.get(v);
        visited[v] = true;
        onStack[v] = true;
        for (Integer i : adj) {
            if ((visited[i] && onStack[i]) || (!visited[i] && hasCycle(graph, i, visited, onStack)))
                return true;
        }
        onStack[v] = false;
        return false;
    }
}