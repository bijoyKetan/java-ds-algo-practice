package ds_algo.dynamic_programming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Core_FindAllSubsequences {

    public List<String> findAllSubSequences(String s) {

        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            //Following is an issue since the list will keep growing
            /*
             for (String a: result){
                result.add(a + s.charAt(i));
            }
             */

            int resultLen = result.size(); //finding length here crucial to avoid infinite loop
            //result.add(s.charAt(i)); // Prob -> adding char to a list of Strings
            result.add(s.substring(i, i + 1));
            for (int j = 0; j < resultLen; j++) {
                result.add(result.get(j) + s.charAt(i));
            }
        }
        return result;
    }

    @Test
    public void testSubSequences() {
        assertThat(Arrays.asList("a", "b", "c", "ab", "ac", "bc", "abc")).containsAll(findAllSubSequences("abc"));
    }
}
