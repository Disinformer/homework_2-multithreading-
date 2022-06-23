package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;
import ru.digitalhabbits.homework2.LetterCounter;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class LetterCounterImplTest {

  @Test
  void count_simple_input_1() {
    //Given
    LetterCounter letterCounter = new LetterCounterImpl();
    String input = "aaaaa";

    //When
    Map<Character, Long> characters = letterCounter.count(input);

    //Then
    assertThat(characters)
        .containsOnly(entry('a', 5L));
  }

  @Test
  void count_simple_input_2() {
    //Given
    LetterCounter letterCounter = new LetterCounterImpl();
    String input = "b";

    //When
    Map<Character, Long> characters = letterCounter.count(input);

    //Then
    assertThat(characters)
        .containsOnly(entry('b', 1L));
  }

  @Test
  void count_complex_input_2() {
    //Given
    LetterCounter letterCounter = new LetterCounterImpl();
    String input = "caabbaa";

    //When
    Map<Character, Long> characters = letterCounter.count(input);

    //Then
    assertThat(characters)
        .containsOnly(
            entry('a', 4L),
            entry('b', 2L),
            entry('c', 1L)
        );
  }

  @Test
  void count_complex_input_1() {
    //Given
    LetterCounter letterCounter = new LetterCounterImpl();
    String input = "cdccfdbfadba";

    //When
    Map<Character, Long> characters = letterCounter.count(input);

    //Then
    assertThat(characters)
        .containsOnly(
            entry('a', 2L),
            entry('b', 2L),
            entry('c', 3L),
            entry('d', 3L),
            entry('f', 2L)
        );
  }
}