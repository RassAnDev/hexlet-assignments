package exercise;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String pathToFile1,
                                                       String pathToFile2,
                                                       String pathToResultFile) {

        Path normalizedPath1 = Paths.get(pathToFile1).toAbsolutePath().normalize();
        Path normalizedPath2 = Paths.get(pathToFile2).toAbsolutePath().normalize();
        Path normalizedResultPath = Paths.get(pathToResultFile).toAbsolutePath().normalize();

        CompletableFuture<String> dataFromFile1 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(normalizedPath1);
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> dataFromFile2 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(normalizedPath2);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return dataFromFile1.thenCombine(dataFromFile2, (data1, data2) -> {
            String resultData = data1 + data2;

            try {
                Files.writeString(normalizedResultPath, resultData, StandardOpenOption.CREATE);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return resultData;
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return null;
        });
    }

//    public static CompletableFuture<Long> getDirectorySize(String path) {
//        Path normalizedPath = Paths.get(path).toAbsolutePath().normalize();
//        return CompletableFuture.supplyAsync(() -> {
//            try {
//                return Files.walk(normalizedPath).count();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }).exceptionally(ex -> {
//            System.out.println(ex.getMessage());
//            return null;
//        });

    public static CompletableFuture<Long> getDirectorySize(String path) {

        return CompletableFuture.supplyAsync(() -> {
            Path normalizedPath = Paths.get(path).toAbsolutePath().normalize();
            Long size;
            try {
                size = Files.walk(normalizedPath, 1)
                        .filter(Files::isRegularFile)
                        .mapToLong(p -> {
                            try {
                                return Files.size(p);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .sum();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return size;

        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/result.txt");

        // END
    }
}

