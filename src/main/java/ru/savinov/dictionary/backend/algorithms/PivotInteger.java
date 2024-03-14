package ru.savinov.dictionary.backend.algorithms;

public class PivotInteger {
    public static void main(String[] args) {
        int pivot = findPivot(15);
        System.out.println(pivot);
    }

    private static int findPivot(int n) {
        int result = -1;
        int leftSum = 1;
        int rightSum = n;
        int nextNumLeft = 2;
        int nextNumRight = n - 1;
        if (n == leftSum) {
            return n;
        }
        while ((nextNumRight - nextNumLeft) > 0) {
            if (leftSum < rightSum) {
                leftSum = leftSum + nextNumLeft;
                nextNumLeft++;
            } else if (rightSum < leftSum) {
                rightSum = rightSum + nextNumRight;
                nextNumRight--;
            } else if (rightSum == leftSum) {
                leftSum = leftSum + nextNumLeft;
                nextNumLeft++;
                rightSum = rightSum + nextNumRight;
                nextNumRight--;
            }
        }
        if (leftSum == rightSum) {
            result = nextNumRight;
        }
        return result;
    }

}
