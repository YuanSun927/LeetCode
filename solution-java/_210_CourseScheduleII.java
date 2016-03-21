/*
210. Course Schedule II My Submissions Question
Total Accepted: 22731 Total Submissions: 109212 Difficulty: Medium
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs,
return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them.
If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0.
So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3].
Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
*/
public class _210_CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        return toplogicalSort(graph, numCourses);
    }

    private int[] toplogicalSort(List<Integer>[] graph, int numCourses) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i] && hasOrder(graph, i, isVisited, onStack, stack))
                return new int[] {};
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    private boolean hasOrder(List<Integer>[] graph, int v, boolean[] isVisited, boolean[] onStack, Stack<Integer> stack) {
        isVisited[v] = true;
        onStack[v] = true;
        for (Integer w : graph[v]) {
            if ((!isVisited[w] && hasOrder(graph, w, isVisited, onStack, stack)) || (isVisited[w] && onStack[w]))
                return true;
        }
        onStack[v] = false;
        stack.push(v);
        return false;
    }

}