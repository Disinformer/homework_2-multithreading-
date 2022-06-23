package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;
import ru.digitalhabbits.homework2.LetterCountMerger;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class LetterCountMergerImplTest {

  private final LetterCountMerger merger = new LetterCountMergerImpl();

  @Test
  void merge_all_different_elements_1() {
    //Given
    Map<Character, Long> first = Collections.singletonMap('a', 4L);
    Map<Character, Long> second = Collections.singletonMap('b', 4L);

    //When
    Map<Character, Long> actual = merger.merge(first, second);

    //Then
    assertThat(actual)
        .containsOnly(entry('a', 4L), entry('b', 4L));
  }

  @Test
  void merge_all_different_elements_2() {
    //Given
    Map<Character, Long> first = Map.of('a', 2L, 'b', 4L);
    Map<Character, Long> second = Map.of('a', 3L, 'b', 1L, 'c', 7L, 'x', 0L);

    //When
    Map<Character, Long> actual = merger.merge(first, second);

    //Then
    assertThat(actual)
        .containsOnly(entry('a', 5L), entry('b', 5L), entry('c', 7L), entry('x', 0L));
  }


  @Test
  void merge_all_different_elements_3() {
    //Given
    Map<Character, Long> first = Map.of('a', 3L, 'b', 1L, 'c', 7L, 'x', 0L);
    Map<Character, Long> second = Map.of('a', 2L, 'b', 4L);

    //When
    Map<Character, Long> actual = merger.merge(first, second);

    //Then
    assertThat(actual)
        .containsOnly(entry('a', 5L), entry('b', 5L), entry('c', 7L), entry('x', 0L));
  }

  @Test
  void merge_different_and_the_same_elements() {
    //Given
    Map<Character, Long> first = Collections.singletonMap('a', 1L);
    Map<Character, Long> second = Collections.singletonMap('a', 2L);

    //When
    Map<Character, Long> actual = merger.merge(first, second);

    //Then
    assertThat(actual)
        .containsOnly(entry('a', 3L));
  }
}