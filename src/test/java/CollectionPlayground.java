import org.junit.jupiter.api.Test;

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


    }
}
