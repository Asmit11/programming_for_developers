package Question2;

import java.util.*;

public class WhitelistedRandomPort {
    private Set<Integer> allowedPorts;
    private Random randomGenerator;

    public WhitelistedRandomPort(int totalPorts, int[] blockedPorts) {
        allowedPorts = new HashSet<>();
        randomGenerator = new Random();

        // Add all ports from 0 to totalPorts-1 to the allowedPorts set
        for (int i = 0; i < totalPorts; i++) {
            allowedPorts.add(i);
        }

        // Remove blocked ports from the allowedPorts set
        for (int blockedPort : blockedPorts) {
            allowedPorts.remove(blockedPort);
        }
    }

    public int getRandomPort() {
        // Generate a random index within the size of the allowedPorts set
        int index = randomGenerator.nextInt(allowedPorts.size());

        // Iterate through the allowedPorts set to find the element at the generated index
        Iterator<Integer> iterator = allowedPorts.iterator();
        for (int i = 0; i < index; i++) {
            iterator.next();
        }

        return iterator.next();
    }

    public static void main(String[] args) {
        // Example input
        int totalPorts = 7;
        int[] blockedPorts = {2, 3, 5};

        // Create an instance of WhitelistedRandomPort
        WhitelistedRandomPort portSelector = new WhitelistedRandomPort(totalPorts, blockedPorts);

        // Call the getRandomPort() function to get random allowed ports
        System.out.println(portSelector.getRandomPort()); // Returns a random allowed port
        System.out.println(portSelector.getRandomPort()); // Returns another random allowed port
    }
}
