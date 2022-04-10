package graph.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Collections;

/**
 * Class Solution.
 * Implements Breadth-first search.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 10.04.2022
 */
public class Solution {
    /**
     * Method computes the solution.
     *
     * @param map       Map.
     * @param root      String.
     * @param subString String.
     * @return boolean.
     */
    public final boolean contains(
            final Map<String, String[]> map,
            final String root,
            final String subString) {
        boolean result = false;
        String[] values = map.get(root);
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(values));

        List<String> searched = new LinkedList<>();

        while (!queue.isEmpty()) {
            String person = queue.poll();
            if (!searched.contains(person)) {
                if (person.contains(subString)) {
                    result = true;
                    break;
                } else {
                    searched.add(person);
                    String[] vals = map.get(person);
                    if (vals.length != 0) {
                        Collections.addAll(queue, vals);
                    }
                }
            }
        }
        return result;
    }
}
