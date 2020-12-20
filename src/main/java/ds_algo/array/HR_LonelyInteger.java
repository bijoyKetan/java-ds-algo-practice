package ds_algo.array;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class HR_LonelyInteger {

    static int lonelyinteger(int[] a) {
        Set<Integer> set = new HashSet<>();

        for (int i: a){
            if (set.contains(i)) set.remove(i);
            else set.add(i);
        }
        return set.iterator().next();
    }

    @Test
    public void testOnlyInteger(){
        assertThat(lonelyinteger(new int[]{0,0,1,2,1})).isEqualTo(2);
        assertThat(lonelyinteger(new int[]{1})).isEqualTo(1);
    }

}
