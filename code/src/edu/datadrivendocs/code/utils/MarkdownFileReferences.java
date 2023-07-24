package edu.datadrivendocs.code.utils;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MarkdownFileReferences {

    public static void main(String[] args) throws IOException {
        // Specify the path to the directory containing the markdown files
        String path = "C:\\src\\data-driven-docs\\docs\\pages";

        // Get all distinct file names from nested markdown files
        Set<String> allMarkdownFiles = getAllMarkdownFiles(path);

        // Get all referenced file names from markdown files
        Set<String> referencedFiles = getReferencedFiles(path);

        // Find files that are not being referenced
        Set<String> unreferencedFiles = new HashSet<>(allMarkdownFiles);
        unreferencedFiles.removeAll(referencedFiles);

        // Display the results
        System.out.println("All distinct markdown files:");
        for (String file : allMarkdownFiles) {
            System.out.println(file);
        }

        System.out.println("\nReferenced markdown files:");
        for (String file : referencedFiles) {
            System.out.println(file);
        }

        System.out.println("\nUnreferenced markdown files:");
        for (String file : unreferencedFiles) {
            System.out.println(file);
        }
    }

    // Get all distinct markdown file names from nested files in a directory
    private static Set<String> getAllMarkdownFiles(String path) throws IOException {
        Set<String> markdownFiles = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path))) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    markdownFiles.addAll(getAllMarkdownFiles(entry.toString()));
                }
                if(entry.getFileName().toString().endsWith("md"))
                    markdownFiles.add(entry.getFileName().toString());
            }
        }
        return markdownFiles;
    }

    // Get all referenced file names from markdown files in a directory
    private static Set<String> getReferencedFiles(String path) throws IOException {
        Set<String> referencedFiles = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path), "*.md")) {
            for (Path entry : stream) {
                List<String> lines = Files.readAllLines(entry);
                for (String line : lines) {
                    // Assuming that references to other markdown files follow the format "[filename]"
                    int start = line.indexOf('[');
                    int end = line.indexOf(']');
                    if (start != -1 && end != -1 && end > start) {
                        String referencedFile = line.substring(start + 1, end);
                        referencedFiles.add(referencedFile);
                    }
                }
            }
        }
        return referencedFiles;
    }
}