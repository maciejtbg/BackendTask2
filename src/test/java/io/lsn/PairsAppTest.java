package io.lsn;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairsAppTest {

    List<Integer> inputList;
    List<int[]> expectedOutput;
    @Test
    public void ShouldFindNoneOfPairs() {
        inputList = new ArrayList<>(Arrays.asList(-13, 13));
        expectedOutput = new ArrayList<>(Collections.emptyList());
        extracted(inputList, expectedOutput);

        inputList = new ArrayList<>(Collections.singletonList(13));

        extracted(inputList, expectedOutput);

        inputList = new ArrayList<>(Arrays.asList(2, 5, -20));

        extracted(inputList, expectedOutput);
    }

    @Test
    public void ShouldFindTwoPairs() {
        inputList = new ArrayList<>(Arrays.asList(-13, 26, 0, 13));
        expectedOutput = new ArrayList<>(Arrays.asList(
                new int[]{-13, 26},
                new int[]{0, 13}
        ));
        extracted(inputList, expectedOutput);

        inputList = new ArrayList<>(Arrays.asList(13, 0, 13));
        expectedOutput = new ArrayList<>(Arrays.asList(
                new int[]{0, 13},
                new int[]{0, 13}
        ));
        extracted(inputList, expectedOutput);
    }

    @Test
    public void ShouldFindOnePair() {
        inputList = new ArrayList<>(Arrays.asList(16, -1, 14));
        expectedOutput = new ArrayList<>(Collections.singletonList(
                new int[]{-1, 14}
        ));
        extracted(inputList, expectedOutput);

        inputList = new ArrayList<>(Arrays.asList(-1, 14, -2, -3, -4, -5, -6, -7));
        expectedOutput = new ArrayList<>(Collections.singletonList(
                new int[]{-1, 14}
        ));
        extracted(inputList, expectedOutput);
    }

    @Test
    public void shouldFindFourPairs() {
        inputList = new ArrayList<>(Arrays.asList(1, 2, 10, 7, 5, 3, 6, 6, 13, 0));
        expectedOutput = new ArrayList<>(Arrays.asList(
                new int[]{0, 13},
                new int[]{3, 10},
                new int[]{6, 7},
                new int[]{6, 7}
        ));
        extracted(inputList, expectedOutput);

        inputList = new ArrayList<>(Arrays.asList(6, 7, 6, 7));
        expectedOutput = new ArrayList<>(Arrays.asList(
                new int[]{6, 7},
                new int[]{6, 7},
                new int[]{6, 7},
                new int[]{6, 7}
        ));
        extracted(inputList, expectedOutput);
    }

    @Test
    public void shouldFindThreePairs() {
        inputList = new ArrayList<>(Arrays.asList(1, 2, 10, 7, 5, 3, 6, 13, 0));
        expectedOutput = new ArrayList<>(Arrays.asList(
                new int[]{0, 13},
                new int[]{3, 10},
                new int[]{6, 7}
        ));
        extracted(inputList, expectedOutput);
    }

    private static void extracted(List<Integer> inputList, List<int[]> expectedOutput) {
        List<int[]> outputList = PairsApp.findPairs(inputList);
        assertEquals(expectedOutput.size(), outputList.size());
        for (int i = 0; i < expectedOutput.size(); i++) {
            int[] expectedPair = expectedOutput.get(i);
            int[] actualPair = outputList.get(i);
            assertArrayEquals(expectedPair, actualPair);
        }
    }

}