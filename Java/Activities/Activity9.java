package activities;
import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Bali");
        myList.add("Sikkim");
        myList.add("Vietnam");
        myList.add(2, "Leh");
        myList.add(1, "Thailand");

        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }

        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is Dubai is in list: " + myList.contains("Dubai"));
        System.out.println("Size of ArrayList: " + myList.size());

        myList.remove("Leh");
        myList.remove("Thailand");

        System.out.println("New Size of ArrayList: " + myList.size());
    }
}