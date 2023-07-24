package edu.datadrivendocs.code.utils;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MarkdownFileReferences {

    public static void main(String[] args) throws IOException {
        // Specify the path to the directory containing the markdown files
        String path = "docs";

        // Get all distinct file names from nested markdown files
        Set<String> allMarkdownFiles = getAllMarkdownFiles(path);

        // Get all referenced file names from markdown files
        Set<String> referencedFiles = getReferencedFiles(path);

        // Find files that are not being referenced
        Set<String> unreferencedFiles = new HashSet<>(allMarkdownFiles);
        unreferencedFiles.removeAll(referencedFiles);

        // Display the results
        System.out.println("All distinct markdown files:" + allMarkdownFiles.size());


        System.out.println("\nReferenced markdown files:" + referencedFiles.size());


        System.out.println("\nUnreferenced markdown files:" + unreferencedFiles.size());
        for (String file : unreferencedFiles) {
            System.out.println(" - " + file);
        }
    }

    // Get all distinct markdown file names from nested files in a directory
    private static Set<String> getAllMarkdownFiles(String path) throws IOException {
        Set<String> markdownFiles = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path))) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry) && !entry.getFileName().toString().equals("common")) {
                    markdownFiles.addAll(getAllMarkdownFiles(entry.toString()));
                }
                if(entry.getFileName().toString().endsWith(".md"))
                    markdownFiles.add(entry.getFileName().toString());
            }
        }
        return markdownFiles;
    }

    // Get all referenced file names from markdown files in a directory
    private static Set<String> getReferencedFiles(String path) throws IOException {
        Set<String> referencedFiles = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path))) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    referencedFiles.addAll(getReferencedFiles(entry.toString()));
                }
                if(entry.getFileName().toString().endsWith(".md")) {
                    List<String> lines = Files.readAllLines(entry);
                    for (String line : lines) {
                        // Assuming that references to other markdown files follow the format "[filename]"
                        int start = line.indexOf('(');
                        int end = line.indexOf(')');
                        if (start != -1 && end != -1 && end > start) {
                            String referencedFile = line.substring(start + 1, end);
                            if(referencedFile.endsWith(".md"))
                                referencedFiles.add(getFileNameOnly(referencedFile));
                        }
                    }
                }
            }
        }
        return referencedFiles;
    }

    private static String getFileNameOnly(String path) {
        // Get the last index of the forward slash '/' in the path
        int lastSlashIndex = path.lastIndexOf('/');

        // Extract the file name by using substring from lastSlashIndex + 1
        return path.substring(lastSlashIndex + 1);
    }
}