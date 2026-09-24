class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         // 1. Build graph
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. Calculate indegree
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int prereq = prerequisite[1];

            // prereq -> course
            graph[prereq].add(course);

            indegree[course]++;
        }

        // 3. Put courses with indegree 0 into queue
        Queue<Integer> queue = new LinkedList<>();

        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        // 4. Topological sort
        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {

            int course = queue.poll();

            result[index++] = course;

            // Process courses depending on this course
            for (int next : graph[course]) {

                indegree[next]--;

                // No more prerequisites
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 5. If we couldn't process all courses,
        // there is a cycle
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}
