package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.LetterCountMerger;

import java.util.HashMap;
import java.util.Map;

public class LetterCountMergerImpl implements LetterCountMerger {
  @Override
  public Map<Character, Long> merge(Map<Character, Long> dest, Map<Character, Long> source) {
    Map<Character, Long> newMap = new HashMap<>(dest);
    for (Map.Entry<Character, Long> entry : source.entrySet()) {
      Character key = entry.getKey();
      Long value = entry.getValue();
      newMap.compute(key, (character, count) -> count == null ? value : count + value);
    }
    return newMap;
  }
}
