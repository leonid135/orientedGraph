package org.spbstu.ziminlo.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Transpose {
    private File input, output;
    private String[][] matrix;
    private int rows, columns;

    Transpose(ArrayList<String> lines){
        createMatrix(lines);
    }

    Transpose(File input) throws FileNotFoundException {
        this.input = input;

        BufferedReader reader = new BufferedReader(new FileReader(this.input));
        ArrayList<String> lines = new ArrayList<>();
        reader.lines().filter(s -> !s.isEmpty()).forEachOrdered(lines::add);

        createMatrix(lines);
    }

    private void createMatrix(ArrayList<String> lines) {
        int maxLength = 0;
        for (String line: lines) {
            int length = line.split(" ").length;
            if(length > maxLength) maxLength = length;
        }

        rows = lines.size();
        columns = maxLength;
        matrix = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = "";
            }
        }

        for (int i = 0; i < rows; i++) {
            int length = lines.get(i).split(" ").length;
            String[] words = lines.get(i).split(" ");
            for (int j = 0; j < length; j++) {
                matrix[i][j] = words[j];
            }
        }
    }

    public void flagA(int num) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int shift = num - matrix[i][j].length();
                matrix[i][j] = String.format("%s%d", matrix[i][j]);
            }
        }
    }

    public void transpose() {
        String[][] newMatrix = new String[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }

        int oldRows = rows;
        rows = columns;
        columns = oldRows;

        matrix = newMatrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String[] row: matrix) {
            for (String word: row) {
                sb.append(word).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
