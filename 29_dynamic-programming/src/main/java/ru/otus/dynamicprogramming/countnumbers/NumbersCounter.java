package ru.otus.dynamicprogramming.countnumbers;

/**
 * @link https://www.robotsharp.info/index.php?page=TaskInfo&taskId=3706
 */
public class NumbersCounter {

    /**
     * Time complexity - O(N) (whereas brute force algorithm is O(2^N))
     * @param numberOfDigits
     * @return
     */
    public int countNumbers(int numberOfDigits) {
        int dp55before = 0;
        int dp58before = 1;
        int dp85before = 1;
        int dp88before = 0;

        int dp55 = dp55before;
        int dp58 = dp58before;
        int dp85 = dp85before;
        int dp88 = dp88before;

        for (int i = 1; i < numberOfDigits; i++) {
            dp55 = dp85before;
            dp58 = dp55before + dp85before;
            dp85 = dp58before + dp88before;
            dp88 = dp58before;

            dp55before = dp55;
            dp58before = dp58;
            dp85before = dp85;
            dp88before = dp88;
        }

        return dp55 + dp58 + dp85 + dp88;
    }
}
