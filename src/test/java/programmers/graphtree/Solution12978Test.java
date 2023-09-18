package programmers.graphtree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
/*
N	road	K	result
5	{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}	3	4
6	{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}	4	4

 */
class Solution12978Test {

    @Test
    void solution() {
        Solution12978 solution = new Solution12978();
        assertThat(solution.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3)).isEqualTo(4);
    }
}