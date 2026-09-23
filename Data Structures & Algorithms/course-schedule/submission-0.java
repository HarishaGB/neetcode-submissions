class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
          // Build graph
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // [a, b] means b -> a
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];

            graph[prereq].add(course);
        }

        // 0 = unvisited
        // 1 = visiting
        // 2 = finished
        int[] state = new int[numCourses];

        // Check every course
        for (int course = 0; course < numCourses; course++) {

            if (!dfs(course, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(
            int course,
            List<Integer>[] graph,
            int[] state) {

        // Course is currently in our DFS path
        if (state[course] == 1) {
            return false;
        }

        // Already completely checked
        if (state[course] == 2) {
            return true;
        }

        // Mark as currently visiting
        state[course] = 1;

        // Visit all dependent courses
        for (int next : graph[course]) {

            if (!dfs(next, graph, state)) {
                return false;
            }
        }

        // Finished checking this course
        state[course] = 2;

        return true;
    }
}
