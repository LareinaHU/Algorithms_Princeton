package week3;


import java.util.*;

public class CarFuel {

    static int computeMinRefills(int dist, int tank, int[] stops) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stops.length - 1; i++) {
            if (stops[i + 1] - stops[i] > tank || dist - stops[stops.length - 1] > tank || stops[0] > tank) {
                return -1;
            }
            map.put(stops[i], stops[i]);
            map.put(stops[stops.length - 1], stops[stops.length - 1]);
        }
        for (int i = 0; i <= dist; i++) {
            map.put(i, map.getOrDefault(i, 0));
        }
        int currentPos = 0;
        int numStops = 0;
        while (currentPos + tank < dist) {
            int lastRefill = currentPos;
            if (lastRefill + tank == map.get(lastRefill + tank)) {
                currentPos = lastRefill + tank;

            } else if (lastRefill + tank > map.get(lastRefill + tank)) {
                for (int i = lastRefill + tank; i >= lastRefill + 1; i--) {
                    if (map.get(i) != 0) {
                        lastRefill = map.get(i);
                        break;
                    }
                }

                currentPos = lastRefill;

            }
            numStops++;
        }
        return numStops;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
