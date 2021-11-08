package assignment.five;

import java.util.ArrayList;
import java.util.List;

public class Assessment {
    public static Boolean groupSumClump(
            Integer sum,
            List<Integer> integers,
            Integer target)
    {
        List<Integer> clumped = clumpCollection(integers);
        return solve(sum, clumped, target);
    }

    /**
     * Groups, then adds adjacent elements together in a List of Integers if they are the same value
     *
     * @param integers List of Integers to group
     * @return A grouped List of Integers
     */
    private static List<Integer> clumpCollection(List<Integer> integers) {
        ArrayList<Integer> returnList = new ArrayList<>();
        Integer pointer1 = 0, pointer2 = 0, index = 0;

        while (pointer2 < integers.size()) {
            Integer element1 = integers.get(pointer1);
            Integer element2 = integers.get(pointer2);

            if (element1 != element2) {
                // Multiply the element by the space between the pointers to get the number of occurrences
                returnList.add(element1 * (pointer2 - pointer1));
                pointer1 = pointer2;
            }

            pointer2++;
        }

        // Add the last element(s)
        returnList.add(integers.get(pointer1) * (pointer2 - pointer1));

        return returnList;
    }

    private static Boolean solve(Integer sum, List<Integer> integers, Integer target) {
        if (sum == target) return true;
        if (sum > target) return false;

        for (Integer value : integers) {
            int newSum = sum + value;

            // Create a new list without the used element
            ArrayList<Integer> newList = new ArrayList<>(integers);
            newList.remove(value);

            Boolean canSolve = solve(newSum, newList, target);

            if (canSolve) return true;
        }

        return false;
    }
}
