package springhw;

import springhw.beans.Characters;

import java.util.HashMap;
import java.util.Map;

public class Counter {
    public static void count(Characters[] data) {
        Map<String, Integer> numbers = new HashMap<>();
        for (int i = 0; i < data.length; i++){
            try {
                String char_type = data[i].getRole();
                if (!numbers.containsKey(char_type)) {
                    numbers.put(char_type, 1);
                } else {
                    numbers.put(char_type, numbers.get(char_type) + 1);
                }
            }catch (NullPointerException e) {
                if (!numbers.containsKey("undefined")) {
                    numbers.put("undefined", 1);
                } else {
                    numbers.put("undefined", numbers.get("undefined") + 1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : numbers.entrySet()) {
            System.out.println("Characters " + entry.getKey() + " type: " + entry.getValue());
        }
        System.out.println();
    }
}

