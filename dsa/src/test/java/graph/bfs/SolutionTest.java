package graph.bfs;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class SolutionTest.
 * Tests Solution class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 10.04.2022
 */
class SolutionTest {
    /**
     * Tests contains() method.
     */
    @Test
    void whenFoundThenTrue() {
        Solution solution = new Solution();
        HashMap<String, String[]> map = new HashMap<>();
        map.put("you", new String[]{"alice", "bob", "claire"});
        map.put("bob", new String[]{"anuj"});
        map.put("alice", new String[]{"peggy"});
        map.put("claire", new String[]{"thom", "jonny"});
        map.put("anuj", new String[]{});
        map.put("peggy", new String[]{});
        map.put("thom", new String[]{});
        map.put("jonny", new String[]{});

        assertTrue(solution.contains(map, "you", "nn"));
    }

    /**
     * Tests contains() method.
     */
    @Test
    void whenDoNotFoundThenFalse() {
        Solution solution = new Solution();
        HashMap<String, String[]> map = new HashMap<>();
        map.put("you", new String[]{"alice", "bob", "claire"});
        map.put("bob", new String[]{"anuj"});
        map.put("alice", new String[]{"peggy"});
        map.put("claire", new String[]{"thom", "jonny"});
        map.put("anuj", new String[]{});
        map.put("peggy", new String[]{});
        map.put("thom", new String[]{});
        map.put("jonny", new String[]{});

        assertFalse(solution.contains(map, "you", "nnQ"));
    }
}
