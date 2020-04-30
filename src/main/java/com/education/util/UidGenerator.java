package com.education.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

/**
 * id生成器
 * @author lss
 * @since 2020/3/27
 */
public class UidGenerator {

    private static final Logger logger = LoggerFactory.getLogger(UidGenerator.class);

    /**
     * 系统id
     */
    private static final String SYS_ID = "8";

    /**
     * 设备id
     */
    private static final String DEVICE_ID = "0";

    /**
     * data值
     */
    private static final Long DATA = 1391383140000L;

    /**
     * mode
     */
    private static final Long MODE = 8999999999999L;

    /**
     * alpha
     */
    private static final Long ALPHA = 1000000000000L;

    private static UniqueTimer timer = new UniqueTimer();
    private static UniqueIncrement increment = new UniqueIncrement();

    public static Long getNextId() {
        Long uid;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SYS_ID);
            sb.append(DEVICE_ID);
            long t = timer.getCurrentTime();
            t = ALPHA + (t - DATA) % MODE;
            sb.append(t);
            long i = increment.getIncrement();
            sb.append(10 + i % 89);
            uid = Long.parseLong(sb.toString());
        } catch (Exception e) {
            logger.error("getNextId error! ", e);
            uid = timer.getIncrementTime();
        }
        return uid;
    }

    static class UniqueIncrement {
        private AtomicLong inc = new AtomicLong(0);

        long getIncrement() {

            return this.inc.incrementAndGet();
        }
    }

    static class UniqueTimer {

        private AtomicLong lastTime = new AtomicLong(System.currentTimeMillis());

        long getCurrentTime() {
            return System.currentTimeMillis();
        }

        long getIncrementTime() {
            return this.lastTime.incrementAndGet();
        }
    }
}
