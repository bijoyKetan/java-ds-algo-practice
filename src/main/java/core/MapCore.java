package core;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MapCore {

    @Test
    public void mapTest() {
        Map<String, Integer> map = new HashMap();
        map.put("k1", 1);
        map.put("k2", 2); //Keys can't be duplicate or null. Values can be
        map.get("k1"); // => 1, value of key k1

        //Frequency counting
        map.put("k4", map.getOrDefault("k4", 0) + 1);

        map.putIfAbsent("k3", 1);
        map.remove("k2"); // => v2. Removed the key value pair
        Map.Entry<String, Integer> entry = new AbstractMap.SimpleEntry<>("k5", 5);
        map.entrySet(); // [k1=v1, k3=v3]. Set of the entries.
        map.keySet(); // [k1, k3]. Set of keys
        map.values();// [v1, v3]. Collection of all (including dupes) values.
        map.size();//size of map
        map.containsKey("k2"); //true
        if (map.get("k") == null) { //Same check as containsKey
            //do something;
        }
        map.containsValue("v4");//false
        map.isEmpty(); //false
        map.size(); //
        //map.putAll(map2); // void. add all key-values of map2 to map
        map.clear();// void. Removes all key-values of map.
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            //do something with keys and values
        }
        for (String s : map.keySet()) {
            //Do something with keys
        }
        for (Integer i : map.values()) {
            //Do something with values
        }
        //Iterate though key and value pairs
        map.forEach((k, v) -> {
            //do something
            //Note: can't return inside of foreach
        });

        //Sorting by values in descending order
        //Return a string of keys with each key appearing
        //as many times as it's value in original map
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (x,y) -> map.get(y) - map.get(x));
        StringBuilder sb = new StringBuilder();
        for (String s: keyList){
            int count = map.get(s);
            while (count > 0){
                sb.append(s);
                count--;
            }
        }
        //sb.toString -> result
    }

    public static void main(String[] args) {
        //Create map and add items to map
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("Continent", "North America");
        myMap.put("Population", 579000000);
        myMap.put("AreaMilesSq", 95400000);
        myMap.put("IncomePerCapitaUSD", 49000);
        myMap.put("RedundantInfo", "someRedundantInfo");

        //Put a key-val, only if this key doesn't exist
        myMap.putIfAbsent("IncomePerCapitaUSD", 50000);

        //Remove a key-value pair
        myMap.remove("RedundantInfo");

        List<String> listMapKeys = new ArrayList<>();
        List<Object> listMapValues = new ArrayList<>();

        //Method 1 - Iterate over the map and get the keys and values
        List<String> listMapKeys2 = new ArrayList<>();
        List<Object> listMapValues2 = new ArrayList<>();

        //For both keys and values
        for (Map.Entry<String, Object> e : myMap.entrySet()) {
            listMapKeys.add(e.getKey());
            listMapValues.add(e.getValue());
        }

        //For keys only
        for (String s : myMap.keySet()) {
            //Do something with keys
        }

        //For values only
        for (Object o : myMap.values()) {
            //Do something with values
        }

        //Method 2 - Java 8 style foreach followed by do something
        myMap.forEach((k, v) -> {
            //Do something, but cannot return anything
            listMapKeys.add(k);
            listMapValues.add(v);
        });

        //Method 3 - Iterate over the map and get the keys and values
        //Collection.Iterator()
        Iterator<Map.Entry<String, Object>> mapIterator = myMap.entrySet().iterator();
        List<String> listIteratorKeys = new ArrayList<>();
        List<Object> listIteratorValues = new ArrayList<>();
        while (mapIterator.hasNext()) {
            //note:iterator.next() progresses the iterator to next item. So, following is buggy
            //listIteratorKeys.add(mapIterator.next().getKey());
            //listIteratorValues.add(mapIterator.next().getValue().toString());
            Map.Entry<String, Object> e = mapIterator.next();
            listIteratorKeys.add(e.getKey());
            listIteratorValues.add(e.getValue().toString());
        }

        // map.keySet() -> returns set
        // map.values() -> returns collection
        Set<String> listMapKeys3 = myMap.keySet();
        List<Object> listMapValues4 = new ArrayList<>(myMap.values());

        //Create a countMap using getOrDefault(key, defaultValue)
        char[] charArray = {'a', 'e', 'o', 'a', 'e', 'z'};
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            countMap.put(charArray[i], countMap.getOrDefault(charArray[i], 0) + 1);
        }

        // If the following lists contain extra items (compared to myMap), remove them
        List<String> listKeysToCompare = new ArrayList<>(Arrays.asList("Continent", "Population", "Tada", "AreaMilesSq"));
        List<Object> listValuesToCompare = new ArrayList<>(Arrays.asList("North America", 95400000, 49000, 121212));
        for (int i = 0; i < listKeysToCompare.size(); i++) {
            if (!myMap.containsKey(listKeysToCompare.get(i))) listKeysToCompare.remove(i);
        }
        for (int i = 0; i < listValuesToCompare.size(); i++) {
            if (!myMap.containsValue(listValuesToCompare.get(i))) listValuesToCompare.remove(i);
        }

        //Are all items in a list distinct - method 1
        List<String> sampleList = Arrays.asList("Apple", "Banana", "Orange", "Peach", "Banana");
        Map<String, Integer> sampleCountMap = new HashMap<>();
        for (int i = 0; i < sampleList.size(); i++) {
            sampleCountMap.put(sampleList.get(i), sampleCountMap.getOrDefault(sampleList.get(i), 0) + 1);
        }
        boolean isDuplicateList1 = sampleCountMap.size() == sampleList.size();

        //Are all items in a list distinct - method 2
        Set<String> uniqueListItems = new HashSet<>(sampleList);
        boolean isDuplicateList2 = uniqueListItems.size() == sampleList.size();

        //For equality, order does not matter for set. set1.equals(set2) = true
        //List can't be compared with Set, incontrovertible type.
        //But the list can be cast to a set and compared
        Set<String> set1 = new HashSet<>(Arrays.asList("Dhaka", "NYC", "Tokyo", "Budapest"));
        Set<String> set2 = new HashSet<>(Arrays.asList("NYC", "Dhaka", "Tokyo", "Budapest"));
        boolean setContains = set1.contains("NYC");//true
        set1.add("NYC"); //-> This will leave the set unchanged as NYC is already in set
        set1.remove("New"); //-> Won't change anything as the set doesn't contain New
        set1.equals(set2); // -> true
        List<String> list3 = Arrays.asList("NYC", "Dhaka", "Tokyo", "Budapest");
        new HashSet<>(list3).equals(set1);// -> true

        //To use Set vs. Dictionary
        //Note that Set is good with distinct items, but
        //if the items need to be removed and a count is required, use dictionary

        ////////////////////////////////////////////////////////////////////

        //Print the results
        System.out.println("Original Map: " + myMap.toString() + "\n");
        System.out.println("listMapKeys: " + listMapKeys);
        System.out.println("listMapValues: " + listMapValues + "\n");

        System.out.println("listMapKeys2: " + listMapKeys2);
        System.out.println("listMapValues2: " + listMapValues2 + "\n");

        System.out.println("listIteratorKeys: " + listIteratorKeys);
        System.out.println("listIteratorValues: " + listIteratorValues + "\n");

        System.out.println("countMap: " + countMap + "\n");

        System.out.println("listKeysToCompare: " + listKeysToCompare);
        System.out.println("listValuesToCompare: " + listValuesToCompare + "\n");

        System.out.println("isDuplicateList1: " + isDuplicateList1);
        System.out.println("isDuplicateList2: " + isDuplicateList2 + "\n");

        System.out.println("Set 1: " + set1.toString());
        System.out.println("Set1 contains NYC: " + setContains);
        System.out.println("Equality Check S1 vs. S2: " + set1.equals(set2));
        System.out.println("Equality check with a list with same content: " + new HashSet<>(list3).equals(set1));
    }
}