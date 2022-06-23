package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.FileReader;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {

  @Override
  public List<String> readLines(File file) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
      return reader.lines().collect(Collectors.toList());
    } catch (IOException e) {
      throw new RuntimeException("No such file found");
    }
  }

}
