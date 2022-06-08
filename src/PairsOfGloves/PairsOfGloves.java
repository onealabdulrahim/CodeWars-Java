package PairsOfGloves;

import java.util.HashMap;
import java.util.Map;

public class PairsOfGloves {

    public static int numberOfPairs(String[] gloves) {
        Map<String, Integer> glovesFreq = new HashMap<>();
        for (int i = 0; i < gloves.length; i++) {
            if (glovesFreq.containsKey(gloves[i])) {
                glovesFreq.put(gloves[i], glovesFreq.get(gloves[i]) + 1);
            } else {
                glovesFreq.put(gloves[i], 1);
            }
        }

        int result = 0;
        for (Map.Entry<String, Integer> entry : glovesFreq.entrySet()) {
                result = result + (entry.getValue() / 2);
        }
        return result;
    }

    public static void main(String[] args) {
        PairsOfGloves testPairsOfGloves = new PairsOfGloves();

        System.out.println(testPairsOfGloves.numberOfPairs(new String[] {}));
        System.out.println(testPairsOfGloves.numberOfPairs(new String[] {"red", "red"}));
        System.out.println(testPairsOfGloves.numberOfPairs(new String[] {"red", "green", "blue"}));
        System.out.println(testPairsOfGloves.numberOfPairs(new String[] {"gray", "black", "purple", "purple", "gray", "black"}));
        System.out.println(testPairsOfGloves.numberOfPairs(new String[] {"red", "green", "blue", "blue", "red", "green", "red", "red", "red"}));
    }
}
