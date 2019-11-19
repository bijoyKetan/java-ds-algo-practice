package core;

import java.util.*;

public class MapCore {

    public static void main(String[] args) {

        //Create a DS and and items to it
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("Continent", "North America");
        myMap.put("Population", 579000000);
        myMap.put("AreaMilesSq", 95400000);
        myMap.put("IncomePerCapitaUSD", 49000);

        //Print the map
        System.out.println(myMap.getClass().getSimpleName());

        //Remove items from the list
        myMap.remove("Population");
        System.out.println("Map after removal of key: -> " + myMap);

        //Get all the keys
        List<Object> keyList = new ArrayList<Object>(myMap.keySet());
        System.out.println("Data type of keylist is: -> " + keyList.getClass().getSimpleName());
        System.out.println("The keys of myMap -> " + keyList);

        //Get all the values
        System.out.println("The value of myMap -> " + myMap.values());

        //Create an iterator form the map and iterate over it
        Iterator myIterator = myMap.entrySet().iterator();
        int count = 1;
        while (myIterator.hasNext()) {
            System.out.println("Entry: " + count + " " + myIterator.next());
            count++;
        }


    }

}
