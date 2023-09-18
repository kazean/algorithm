package programmers.graphtree.greedy;

import org.junit.jupiter.api.Test;
import programmers.graphtree.greedy.Solution42861_99;

import static org.assertj.core.api.Assertions.*;

class Solution42861Test {

    @Test
    void solution() {
        Solution42861_99 solution = new Solution42861_99();
        assertThat(solution.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}})).isEqualTo(4);
    }
}