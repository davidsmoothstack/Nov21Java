package assignment.one.tests;

import org.junit.Assert;
import org.junit.Test;

import assignment.one.Assessment;
import assignment.one.OperationResult;
import assignment.one.PerformOperation;

public class AssessmentTests {
    @Test
    public void isOdd_returns_even_whenInputIsEven() {
        PerformOperation fn = Assessment.isOdd();

        Assert.assertEquals(OperationResult.EVEN, fn.apply(2));
    }

    @Test
    public void isOdd_returns_odd_whenInputIsOdd() {
        PerformOperation fn = Assessment.isOdd();

        Assert.assertEquals(OperationResult.ODD, fn.apply(3));
    }

    @Test
    public void isPrime_returns_prime_whenInputIsPrime() {
        PerformOperation fn = Assessment.isPrime();

        Assert.assertEquals(OperationResult.PRIME, fn.apply(3));
    }

    @Test
    public void isPrime_returns_composite_whenInputIsComposite() {
        PerformOperation fn = Assessment.isPrime();

        Assert.assertEquals(OperationResult.COMPOSITE, fn.apply(4));
    }

    @Test
    public void isPalindrome_returns_palindrome_whenInputIsPalindrome() {
        PerformOperation fn = Assessment.isPalindrome();

        Assert.assertEquals(OperationResult.PALINDROME, fn.apply(2));
    }

    @Test
    public void isPalindrome_returns_not_palindrome_whenInputIsNotAPalindrome() {
        PerformOperation fn = Assessment.isPalindrome();

        Assert.assertEquals(OperationResult.NOT_PALINDROME, fn.apply(12));
    }
}
