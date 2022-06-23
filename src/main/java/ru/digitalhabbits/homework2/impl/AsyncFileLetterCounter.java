package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.FileLetterCounter;
import ru.digitalhabbits.homework2.FileReader;
import ru.digitalhabbits.homework2.LetterCountMerger;
import ru.digitalhabbits.homework2.LetterCounter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

//todo Make your impl
public class AsyncFileLetterCounter implements FileLetterCounter {

  private final FileReader reader = new FileReaderImpl();
  private final LetterCounter counter = new LetterCounterImpl();
  private final LetterCountMerger merger = new LetterCountMergerImpl();
  private Map<Character, Long> result = new HashMap<>();


  @Override
  public Map<Character, Long> count(File input) {
    reader.readLines(input).stream()
        .map(line -> supplyAsync(() -> counter.count(line)).thenApplyAsync(map -> result = merger.merge(result, map)))
        .forEach(CompletableFuture::join);
    return result;
  }
}
