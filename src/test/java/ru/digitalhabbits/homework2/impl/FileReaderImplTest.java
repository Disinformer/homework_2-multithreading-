package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;
import ru.digitalhabbits.homework2.FileReader;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class FileReaderImplTest {

  @Test
  void readLines() {
    //Given
    FileReader reader = new FileReaderImpl();
    URL resource = getClass().getClassLoader().getResource("test.txt");
    File testFile = new File(Objects.requireNonNull(resource).getPath());

    //When
    List<String> lines = reader.readLines(testFile);

    //Then
    assertThat(lines)
        .hasSize(1000)
        .contains("cdccfdbfeadebaee");

  }
}