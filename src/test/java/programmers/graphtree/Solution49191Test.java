package programmers.graphtree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution49191Test {

    @Test
    void solution() {
        Solution49191 solution = new Solution49191();
        Assertions.assertThat(solution.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}})).isEqualTo(2);
    }
}