package desavitsky.graphs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task207 {

    enum State {
        White, Black, Grey
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, State> allCoursesStates = IntStream.range(0, numCourses)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), _ -> State.White));
        Map<Integer, List<Integer>> allCoursesAdjList = new HashMap<>();

        for (var prereq : prerequisites) {
            allCoursesAdjList.compute(prereq[0], (_, adj) -> {
                var toAdd = new ArrayList<Integer>();
                toAdd.add(prereq[1]);
                if (adj == null) return toAdd;
                adj.addAll(toAdd);
                return adj;
            });
        }
        var visited = new HashSet<Integer>();
        return allCoursesAdjList.keySet().stream().allMatch(v -> {
            if (visited.contains(v)) return true;
            return dfs(v, allCoursesStates, allCoursesAdjList, visited);
        });
    }

    private boolean dfs(int vertex, Map<Integer, State> states, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        states.put(vertex, State.Grey);
        visited.add(vertex);

        var res = adjList
                .getOrDefault(vertex, List.of())
                .stream()
                .allMatch(v -> {
                            if (states.get(v) != State.Grey) return dfs(v, states, adjList, visited);
                            else return false;
                        }
                );

        states.put(vertex, State.Black);
        return res;

    }
}
