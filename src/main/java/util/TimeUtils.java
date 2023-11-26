package util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeUtils {
    public static void sleep(long second){
        try {
            Thread.sleep(second);
        }catch (Exception e){
            log.error(e.toString());
        }
    }
}
