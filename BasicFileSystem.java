import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.io.IOException;

class BasicFileSystem {
  // On définit la variable pour le répertoire que l'on va lister
  private static Path dir;

  private static Boolean isDirectory (Path file) {
    return false;
  }

  private static void displayPath (Path file) {
    if (isDirectory(file)) {
    }

    System.out.println(file.getFileName());
   return;
  }

  public static void main (String [] args) {
    // On affecte le premier argumet passer dans la ligne de comande à la variable répertoire
    dir = Paths.get(args[0]);

    // On crée un flu pour la lecture du contenu du répertoire 
    //   - Files.newDirectoryStream(dir)
    // On l'afecte au flux `stream`
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
      for (Path file: stream) {
        displayPath(file);
      }
    } catch (IOException | DirectoryIteratorException x) {
      // IOException can never be thrown by the iteration.
      // In this snippet, it can only be thrown by newDirectoryStream.
      System.err.println(x);
    }

  }
}
