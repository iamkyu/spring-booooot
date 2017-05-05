package io.iamkyu;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Kj Nam
 * @since 2017-05-04
 */
public class AssertJTest {
    @Test
    public void assertj_로_문자열_테스트() {
        assertThat("Hello, world! Nice to meet you.")
                .isNotEmpty()
                .startsWith("Hell")
                .contains("Nice")
                .doesNotContain("ZZZ")
                .endsWith("u.")
                .isEqualTo("Hello, world! Nice to meet you.");
    }

    @Test
    public void assertj_로_숫자_테스트() {
        assertThat(3)
                .isPositive()
                .isGreaterThan(2)
                .isLessThan(4);
    }
}
