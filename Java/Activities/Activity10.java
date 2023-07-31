package activities;
import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("Mango");
        hs.add("Banana");
        hs.add("Custard Apple");
        hs.add("Apple");
        hs.add("Mosambi");
        hs.add("Watermelon");

        System.out.println("Original HashSet: " + hs);
        System.out.println("Size of HashSet: " + hs.size());
        System.out.println("Removing Mosambi from HashSet: " + hs.remove("Mosambi"));

        if(hs.remove("Z")) {
            System.out.println("Fig removed from the Set");
        } else {
            System.out.println("Fig is not present in the Set");
        }

        System.out.println("Checking if Mango is present: " + hs.contains("Mango"));
        System.out.println("Updated HashSet: " + hs);
    }
}