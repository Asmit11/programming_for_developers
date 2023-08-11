package Question1;

public class MinimumCostClothing {
    public static int calculateMinimumCost(int numberOfSets, int[][] clothingPrices) {
        // Initialize variables to track the minimum cost for each person
        int minCostPerson1 = Integer.MAX_VALUE;
        int minCostPerson2 = Integer.MAX_VALUE;
        int minCostPerson3 = Integer.MAX_VALUE;

        // Iterate over each clothing set
        for (int i = 0; i < numberOfSets; i++) {
            for (int j = 0; j < 3; j++) {
                // Compare the price of the clothing set with the current minimum cost for each person
                if (j == 0) {
                    minCostPerson1 = Math.min(minCostPerson1, clothingPrices[i][j]);
                } else if (j == 1) {
                    minCostPerson2 = Math.min(minCostPerson2, clothingPrices[i][j]);
                } else {
                    minCostPerson3 = Math.min(minCostPerson3, clothingPrices[i][j]);
                }
            }
        }

        // Calculate and return the total minimum cost
        return minCostPerson1 + minCostPerson2 + minCostPerson3;
    }

    public static void main(String[] args) {
        // Example input: prices of clothing sets for each person
        int[][] clothingPrices = {{14, 4, 11}, {11, 14, 3}, {14, 2, 10}};
        int numberOfSets = 3;

        // Calculate the minimum cost using the function
        int minimumCost = calculateMinimumCost(numberOfSets, clothingPrices);
        
        // Display the minimum cost
        System.out.println("Minimum total cost for clothing: " + minimumCost);
    }
}
