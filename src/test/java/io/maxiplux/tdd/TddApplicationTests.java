package io.maxiplux.tdd;

import io.maxiplux.tdd.utility.UtilyClass;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;

//@SpringBootTest
@DisplayName("Test for UtilyClass")
@Slf4j
class TddApplicationTests {

    //@Test
    @DisplayName("Test sum with BigDecimal")
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @CsvSource( {"0.35,0.15,0.20", "0.30,0.15,0.15", "0.55,0.15,0.40"})
    @Tag("UtilyClass")
    void SumTest(String expected, String stringA, String stringB, TestInfo reporter) {
        //log.info("Test sum with BigDecimal {}", reporter.getDisplayName());

        BigDecimal a = new BigDecimal(stringA);
        BigDecimal b = new BigDecimal(stringB);


        Double a2 = new Double(stringA);
        Double b2 = new Double(stringB);


        Float a3 = new Float(stringA);
        Float b3 = new Float(stringB);



                Assert.assertEquals("Decimals",new BigDecimal(expected), UtilyClass.sum(a, b));
                Assert.assertThat("Double Failed",new Double(expected), Is.is(UtilyClass.sum(a2, b2)));
                Assert.assertThat("Float failed",new Float(expected), Is.is(UtilyClass.sum(a3, b3)));

    }


}
