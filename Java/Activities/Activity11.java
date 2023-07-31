package activities;
import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
        hash_map.put(1, "Red");
        hash_map.put(2, "Blue");
        hash_map.put(3, "Violet");
        hash_map.put(4, "Black");
        hash_map.put(5, "White");

        System.out.println("The Original map: " + hash_map);

        hash_map.remove(3);

        System.out.println("After removing Violet: " + hash_map);

        if(hash_map.containsValue("Black")) {
            System.out.println("Black exists in the Map");
        } else {
            System.out.println("Black does not exist in the Map");
        }

        System.out.println("Number of pairs in the Map is: " + hash_map.size());
    }
}