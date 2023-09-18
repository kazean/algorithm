package programmers.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class Solution172927Test {

    @Test
    void solution() {
        Solution172927 solution = new Solution172927();
        /*
        assertThat(solution.solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}))
                .isEqualTo(12);
         */
        assertThat(solution.solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}))
                .isEqualTo(50);

    }
}