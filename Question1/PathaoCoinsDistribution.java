package Question1;

import java.util.Arrays;

public class PathaoCoinsDistribution {
    public static int calculateMinimumCoins(int[] riderRatings) {
        int n = riderRatings.length;

        // Create an array to store the number of coins for each rider
        int[] coinsPerRider = new int[n];

        // Initialize the number of coins for each rider as 1
        Arrays.fill(coinsPerRider, 1);

        // Traverse from left to right and update the number of coins based on the ratings
        for (int i = 1; i < n; i++) {
            if (riderRatings[i] > riderRatings[i - 1]) {
                // If the current rider has a higher rating than the previous rider, assign one more coin
                coinsPerRider[i] = coinsPerRider[i - 1] + 1;
            }
        }

        // Traverse from right to left and update the number of coins based on the ratings
        for (int i = n - 2; i >= 0; i--) {
            if (riderRatings[i] > riderRatings[i + 1]) {
                // If the current rider has a higher rating than the next rider, assign more coins if needed
                coinsPerRider[i] = Math.max(coinsPerRider[i], coinsPerRider[i + 1] + 1);
            }
        }

        // Calculate the total number of coins required
        int totalCoinsRequired = 0;
        for (int coins : coinsPerRider) {
            totalCoinsRequired += coins;
        }

        return totalCoinsRequired;
    }

    public static void main(String[] args) {
        // Example input: ratings of riders
        int[] riderRatings = {1, 0, 2};

        // Calculate the minimum number of coins required using the function
        int minimumCoinsRequired = calculateMinimumCoins(riderRatings);
        
        // Display the minimum number of coins required
        System.out.println("Minimum number of coins required: " + minimumCoinsRequired);
    }
}
