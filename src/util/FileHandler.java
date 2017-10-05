package util;
import java.nio.file.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

    public class FileHandler {
        private String directory;
        private String fileName;
        private Path path;
        private List<String> myContacts;

        public FileHandler(String directory, String fileName) throws IOException {
            this.directory = directory;
            this.fileName = fileName;
            this.createFile();
            this.myContacts = new ArrayList<>();
        }

        private void createFile() throws IOException {
            this.path = Paths.get(this.directory, this.fileName); // files
            if (!Files.exists(path.getParent())) {
                Files.createDirectory(path.getParent());
            }
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        }

        public List<String> readAllContents() throws IOException {
            return Files.readAllLines(this.path);
        }

        public void writeToFile(List<String> contents) throws IOException {
            Files.write(this.path, contents, StandardOpenOption.APPEND);  // write several lines to a file
        }
    }
