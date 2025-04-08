package encora-prova;

import java.util.*;

public class SubsetsGenerator {

    /**
     * The function below will:
     * - Obtain the input set
     * - Convert the set into a list for indexed access
     * - Iterate over all binary combinations from 0 to 2^n - 1
     *   to determine which elements belong to each subset
     * - Build each subset using bitmasking and add it to the result set
     * - Print the result and return all subsets of the input set
     */

    public static Set<Set<Integer>> getSubSets(Set<Integer> input) {
        Set<Set<Integer>> allSubsets = new HashSet<>();
        List<Integer> elements = new ArrayList<>(input);
        int n = elements.size();
        int total = 1 << n; // 2^n subsets

        for (int i = 0; i < total; i++) {
            Set<Integer> subset = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(elements.get(j));
                }
            }
            allSubsets.add(subset);
        }

        return allSubsets;
    }

    public static void main(String[] args) {
        // Example input
        Set<Integer> input = new HashSet<>();
        input.add(1);
        input.add(2);
        input.add(3);

        // Call the function
        Set<Set<Integer>> result = getSubSets(input);

        // Print the subsets
        System.out.println("Subsets of " + input + ":");
        for (Set<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
