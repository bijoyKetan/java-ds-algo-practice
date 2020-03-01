package ds_algo.map;

import java.util.HashMap;
import java.util.Map;

public class LC359LoggerRateLimiter {
    //Design a logger system that receive stream of messages along with its timestamps,
    // each message should be printed if and only if it is not printed in the last 10 seconds.


    public LC359LoggerRateLimiter() {
        Map<String, Integer> loggerMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

