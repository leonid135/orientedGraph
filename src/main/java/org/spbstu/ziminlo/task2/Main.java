package org.spbstu.ziminlo.task2;

import org.apache.commons.cli.*;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    private static final String console = null;

    public static void main(String[] args)  {
        Options options = new Options();
        options.addOption("r", false,
                "выравнивание по правой границе, иначе по левой");
        options.addOption("t", false,
                "если слово не влезает в выделенное место (по флагу \"а\") - обрезать с конца");
        options.addOption("a", true,
                "установленный размер слова");
        options.addOption("o", true,
                "имя выходного файла, иначе выводить в консоль");

        CommandLineParser parser = new DefaultParser();
        CommandLine lines = null;
        int num = 0;
        try {
            lines = parser.parse(options, args);
            num = lines.hasOption("a") ? Integer.parseInt(lines.getOptionValue("a")) : 0;
        } catch (ParseException e) {
            System.exit(-1);
        } catch (NumberFormatException e) {
            System.exit(-2);
        }

        String inputFilePath = !lines.getArgList().isEmpty() ? lines.getArgList().get(0) : console;
        String outputFilePath = lines.hasOption("o") ? lines.getOptionValue("o") : console;


        ArrayList<String> input = Objects.equals(inputFilePath, console) ? readFromConsole() : readFromFile(inputFilePath);

        Transpose transpose = new Transpose(input,
                lines.hasOption("a"), num, lines.hasOption("t"), lines.hasOption("r"));
        transpose.transpose();

        ArrayList<String> output = transpose.getTranspose();

        //вывод в файл, иначе в консоль
        if (Objects.equals(outputFilePath, console)) {
            writeToConsole(output);
        } else {
            writeToFile(outputFilePath, output);
        }
        System.exit(0);
    }

    private static ArrayList<String> readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        String str;
        while (!(str = scanner.nextLine()).isEmpty()) {
            lines.add(str);
        }
        return lines;
    }

    private static ArrayList<String> readFromFile(String path) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            reader.lines().filter(s -> !s.isEmpty()).forEachOrdered(lines::add);
            reader.close();
        } catch (IOException e) {
            System.exit(-3);
        }
        return lines;
    }

    private static void writeToConsole(List<String> content) {
        for (String line : content) {
            System.out.println(line);
        }
    }

    private static void writeToFile(String path, List<String> content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)))) {
            for (String line : content) {
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.exit(-4);
        }
    }
}
//