package LC323ComponentCountUndirectedGraph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class SolutionBaseTest {

    private final Solution solution;

    public SolutionBaseTest(Solution solution) {
        this.solution = solution;
    }

    /*
        Graph One:
          1
         / \
        2   3
           / \
          4   5
     */
    @Test
    void graphOne() {
        assertThat(solution.countComponents(
                5,
                new int[][]{{1, 2}, {1, 3}, {3, 4}, {3, 5}}))
                .isEqualTo(1);
    }

    @Test
    void graphOneWithReversedEdges() {
        assertThat(solution.countComponents(
                5,
                new int[][]{{3, 5}, {3, 4}, {1, 3}, {1, 2}}))
                .isEqualTo(1);
    }

    @Test
    void graphOneWithReversedEdgeNodeOrder() {
        assertThat(solution.countComponents(
                5,
                new int[][]{{2, 1}, {3, 1}, {4, 3}, {5, 3}}))
                .isEqualTo(1);
    }

    /*
        Graph Two:
        Component 1:     Component 2:     Component 3:
          1---2---3         5---6---7         9---10
              |
              4
              |
              8
     */
    @Test
    void graphTwo() {
        assertThat(solution.countComponents(
                10,
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 8}, {5, 6}, {6, 7}, {9, 10}}))
                .isEqualTo(3);
    }

    @Test
    void graphTwoWithReversedOrder() {
        assertThat(solution.countComponents(
                10,
                new int[][]{{9, 10}, {6, 7}, {5, 6}, {4, 8}, {3, 4}, {2, 3}, {1, 2}}))
                .isEqualTo(3);
    }

    @Test
    void graphTwoWithReversedEdgeNodeOrder() {
        assertThat(solution.countComponents(
                10,
                new int[][]{{2, 1}, {3, 2}, {4, 3}, {8, 4}, {6, 5}, {7, 6}, {10, 9}}))
                .isEqualTo(3);
    }

    /*
        Graph Three:
        Component 1:        Component 2:        Component 3:
            2                   8                    11
          /                   /                       \
        1 __ 3 __ 6         7 __ 9                    10
             |                                       /
        4 __ 5                                     12
     */
    @Test
    void graphThreeRandomizedEdges() {
        assertThat(solution.countComponents(
                12,
                new int[][]{{10, 12}, {7, 8}, {2, 1}, {10, 11}, {9, 7}, {5, 4}, {3, 5}, {1, 3}, {3, 6}}))
                .isEqualTo(3);
    }
}
