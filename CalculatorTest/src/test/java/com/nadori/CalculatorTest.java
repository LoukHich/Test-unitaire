package com.nadori;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    private Instant startedAt;
    private Calculator calculatorUnderTest;


    @BeforeEach
    public void initCalculator() {
        System.out.println("Appel Avant chaque test: ");
        calculatorUnderTest = new Calculator();
    }


    public void undefCalculator() {
        System.out.println("Appel apres chaque test: ");
        calculatorUnderTest = null;
    }

    @BeforeAll
    public void initInstance() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
    }

    @AfterAll
    public void showTestDuration() {
        System.out.println("Appel Apres tous les tests");
        Instant endAt = Instant.now();
        long duration = Duration.between(startedAt, endAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms {1}", duration, "nadori"));
    }

    @Test
    void testAddtwoPositiveNumber() {
        //Arrange
        int a = 2;
        int b = 3;

        //Act
        int somme = calculatorUnderTest.add(a, b);

        //Assert
      //  assertEquals(somme, 5);
        assertThat(somme).isEqualTo(5);

    }

    @Test
    void testmultiplyPositiveNumber() { //red-green-refactor
        //Arrange

        int a = 2;
        int b = 3;

        //Act
        int res = calculatorUnderTest.multiply(a, b);
        //Assert
       // assertEquals(6, res);
        assertThat(res).isEqualTo(6);
    }

    //    @Test
//    @ValueSource(ints={1,100,200,14})
//    public void  multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg){
//            //Arrange --- Tout est pret
//
//           //Act
//      //  for(int i:arg){
//            int actualResult = calculatorUnderTest.multiply(arg,0);
//            //Assert
//            assertEquals(0,actualResult);
//        //}
//
//    }
    @ParameterizedTest(name = "{0} x 0 doit être égal à 0")
    @ValueSource(ints = {1, 2, 42, 1011, 5089})
    public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
        // Arrange -- Tout est prêt !

        // Act -- Multiplier par zéro
        int actualResult = calculatorUnderTest.multiply(arg, 0);

        // Assert -- ça vaut toujours zéro !
        assertEquals(0, actualResult);
    }

    @ParameterizedTest(name = "{0} + {1} should equal to {2}")
    @CsvSource({"1,1,2", "3,3,6", "5,5,10"})
    public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
        // Arrange -- Tout est prêt !

        // Act
        int actualResult = calculatorUnderTest.add(arg1, arg2);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    @Timeout(2)
    @Test
    public void longCalcul_shouldComputeInLessThan1Second() {
        // Arrange

        // Act
        calculatorUnderTest.longCalculation();

        // Assert
        // ...
    }

    @Test
    public void listDigits_shouldReturnsTheListOfDigits_ofPositiveInteger() {
        // GIVEN
        int number =557889;

        // WHEN
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
//        Set<Integer> excpectedDigits = Stream.of(0).collect(Collectors.toSet());
        // THEN
       // assertEquals(excpectedDigits,actualDigits);
        assertThat(actualDigits).containsExactlyInAnyOrder(5, 7, 8, 9);
    }

}