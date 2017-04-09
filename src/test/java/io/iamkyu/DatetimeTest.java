package io.iamkyu;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author Kj Nam
 * @since 2017-04-09
 */
public class DatetimeTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void 현재_시간을_얻는다() {
        log.debug(String.valueOf(OffsetDateTime.now()));
        log.debug(String.valueOf(new Timestamp(1000 * OffsetDateTime.now().toEpochSecond())));
        log.debug(String.valueOf(Timestamp.valueOf(OffsetDateTime.now().atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime())));
        log.debug(String.valueOf(Timestamp.valueOf(LocalDateTime.ofInstant(OffsetDateTime.now().toInstant(), ZoneOffset.UTC))));
    }
}
