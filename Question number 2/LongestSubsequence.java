package Question2;

import java.util.Arrays;

public class LongestSubsequence {
    public static int findLongestSubsequenceLength(int[] elements, int maxDifference) {
        int n = elements.length;

        // Create an array to store the longest subsequence length ending at each index
        int[] subseqLengths = new int[n];

        // Initialize the longest subsequence length for each index as 1
        Arrays.fill(subseqLengths, 1);

        int longestLength = 1;

        // Traverse the array from left to right
        for (int i = 1; i < n; i++) {
            // Compare the current element with the previous elements
            for (int j = 0; j < i; j++) {
                // Check if the current element is smaller than the previous element
                // and the difference between them is at most maxDifference
                if (elements[i] < elements[j] && elements[j] - elements[i] <= maxDifference) {
                    // Update the longest subsequence length ending at index i
                    subseqLengths[i] = Math.max(subseqLengths[i], subseqLengths[j] + 1);
                }
            }
            // Update the overall longest subsequence length
            longestLength = Math.max(longestLength, subseqLengths[i]);
        }

        return longestLength;
    }

    public static void main(String[] args) {
        // Example input: elements and maximum allowed difference
        int[] elements = {8, 5, 4, 2, 1, 4, 3, 4, 3, 1, 15};
        int maxDifference = 3;

        // Call the function to get the length of the longest subsequence
        int subseqLength = findLongestSubsequenceLength(elements, maxDifference);
        System.out.println("Length of the longest subsequence: " + subseqLength);
    }
}
