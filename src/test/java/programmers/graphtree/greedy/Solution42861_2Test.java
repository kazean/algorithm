package programmers.graphtree.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Solution42861_2Test {

    @Test
    void solution() {
        Solution42861_2 solution = new Solution42861_2();
        assertThat(solution.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}})).isEqualTo(4);
    }

}