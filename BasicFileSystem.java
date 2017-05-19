import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.io.IOException;

class BasicFileSystem {
  private static Path dir;

  public static void main (String [] args) {
    dir = Paths.get(args[0]);

    try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
      for (Path file: stream) {
        System.out.println(file.getFileName());
      }
    } catch (IOException | DirectoryIteratorException x) {
      // IOException can never be thrown by the iteration.
      // In this snippet, it can only be thrown by newDirectoryStream.
      System.err.println(x);
    }

  }
}
