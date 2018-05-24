package org.spbstu.ziminlo.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transpose {
    private String[][] matrix;
    private int rows, columns, num;
    private boolean a, t, r;

    public Transpose(List<String> lines, boolean a, int num, boolean t, boolean r) {
        this.a = a;
        this.t = t;
        this.r = r;
        this.num = num;
        createMatrix(lines);
    }

    private void createMatrix(List<String> lines) {
        int maxLength = 0;
        for (String line : lines) {
            int length = (int) Arrays.stream(line.split(" "))
                    .filter(s -> !s.equals(" ") && !s.isEmpty()).count();
            if (length > maxLength) maxLength = length;
        }

        rows = lines.size();
        columns = maxLength;
        matrix = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            ArrayList<String> words = new ArrayList<>();
            Arrays.stream(lines.get(i).split(" "))
                    .filter(s -> !s.equals(" ") && !s.isEmpty()).forEachOrdered(words::add);
            int length = words.size();
            for (int j = 0; j < length; j++) {
                if (!a && (t || r)) {
                    a = true;
                    num = 10;
                }
                if (a) {
                    if (words.get(j).length() >= num) {
                        if (t)
                            matrix[i][j] = words.get(j).substring(0, num);
                        else
                            matrix[i][j] = words.get(j);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (int k = 0; k < num; k++) {
                            sb.append(" ");
                        }
                        if (r)
                            matrix[i][j] = sb
                                    .replace(num - words.get(j).length(), num, words.get(j)).toString();
                        else
                            matrix[i][j] = sb
                                    .replace(0, words.get(j).length(), words.get(j)).toString();
                    }
                } else
                    matrix[i][j] = words.get(j);
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

    ArrayList<String> getTranspose() {
        ArrayList<String> result = new ArrayList<>();
        for (String[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            if (row.length > 0)
                sb.append(row[0]);
            for (int i = 1; i < row.length; i++) {
                String word = row[i];
                if (word != null)
                    sb.append(" ").append(word);
            }
            result.add(sb.toString());
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String[] row : matrix) {
            if (row.length > 0)
                sb.append(row[0]);
            for (int i = 1; i < row.length; i++) {
                String word = row[i];
                if (word != null)
                    sb.append(" ").append(word);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}