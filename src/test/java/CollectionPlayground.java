import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionPlayground {

    @Test
    void testList() {
        List<String> listA = Arrays.asList("Tommy", "Ben", "Ronda", "Camille", "Ava");
        //Alphabetical sorting
        Collections.sort(listA);
        System.out.println(listA.toString()); // [Ava, Ben, Camille, Ronda, Tommy]

        //Sorting by size
        Collections.sort(listA, (a, b) -> a.length() - b.length());
        System.out.println(listA.toString());

        //Updating an item in list
        List<Integer> sampleList = new ArrayList<>(Arrays.asList(1, 2, 2, 4, 5));
        //sampleList.set(2, 3);
        sampleList.set(sampleList.lastIndexOf(2), 3);
        System.out.println(sampleList.toString());


    }
}
