package assignment.one;

public class Assessment {
    public static void main(String[] args) {
        var input = new String[]{
                "5",
                "1 4",
                "2 5",
                "3 898",
                "1 3",
                "2 12"
        };

        // Get the amount of test cases to parse
        Integer lineCount = Integer.parseInt(input[0]);

        // Loop through each case
        for (int i = 1; i <= lineCount; i++) {
            // Split case by space
            String[] inputSplit = input[i].split("\s+");

            // Get methodId and argument
            Integer methodId = Integer.parseInt(inputSplit[0]);
            Integer lambdaArgument = Integer.parseInt(inputSplit[1]);

            // Get   the lambda function and apply it to the lambda argument
            PerformOperation fn = retrieveOperation(methodId);
            OperationResult result = fn.apply(lambdaArgument);

            // Print the result
            System.out.println(result);
        }
    }

    /**
     * Takes in an ID of 1,2 or 3 and returns a lambda function based in the ID provided
     *
     * @param methodId The id of the lambda to return
     * @return A lambda that performs an operation
     */
    public static PerformOperation retrieveOperation(Integer methodId) {
        return switch (methodId) {
            case 1 -> isOdd();
            case 2 -> isPrime();
            case 3 -> isPalindrome();
            default -> throw new IllegalArgumentException("Invalid method id");
        };
    }

    public static PerformOperation isOdd() {
        return n -> (n % 2 == 0)
                ? OperationResult.EVEN
                : OperationResult.ODD;
    }

    public static PerformOperation isPrime() {
        return n -> {
            if (n <= 1) return OperationResult.COMPOSITE;

            for (int i = 2; i <= n / 2; ++i) {
                if (n % i == 0) return OperationResult.COMPOSITE;
            }

            return OperationResult.PRIME;
        };
    }

    public static PerformOperation isPalindrome() {
        return n -> {
            String numberString = n.toString();
            Integer pointer1 = 0;
            Integer pointer2 = numberString.length() - 1;

            while (!pointer1.equals(pointer2)) {
                Character char1 = numberString.charAt(pointer1);
                Character char2 = numberString.charAt(pointer2);

                if (char1 != char2)
                    return OperationResult.NOT_PALINDROME;

                pointer1++;
                pointer2--;
            }

            return OperationResult.PALINDROME;
        };
    }
}
