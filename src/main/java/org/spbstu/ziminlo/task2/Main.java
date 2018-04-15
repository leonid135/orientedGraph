package org.spbstu.ziminlo.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    private static Transpose transpose;
    private static String inputName = "", outputName = "";
    private static boolean flagA, flagT, flagR;
    static int num;
    private final static String REGEX = "(-r)|(-t)|(-a\\s[\\d]+)|(-o\\s[\\w]+\\.[\\w]+)|([\\w]+\\.[\\w]+)";

    public static void main(String[] args) throws FileNotFoundException {

        //Сборка входящей строки
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]);
            if (i < args.length - 1) sb.append(" ");
        }

        //Обработка входящией строки
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(sb.toString());
        while (matcher.find()) {
            flagR = matcher.group(1) != null || flagR;
            flagT = matcher.group(2) != null || flagT;
            flagA = matcher.group(3) != null || flagA;
            num = matcher.group(3) != null ? Integer.parseInt(matcher.group(3).split(" ")[1]) : num;
            outputName = matcher.group(4) != null ? matcher.group(4).split(" ")[1] : outputName;
            inputName = matcher.group(5) != null ? matcher.group(5) : inputName;
        }

        System.out.println("-r : " + flagR);
        System.out.println("-t : " + flagT);
        System.out.println("-a : " + flagA + " = " + num);
        System.out.println("-o : " + outputName);
        System.out.println("input : " + inputName);

        //Чтение из файла или чтение с консоли
        File input = new File(inputName);
        if (input.exists() && input.isFile())
            transpose = new Transpose(input);
        else {
            transpose = new Transpose(readFromConsole());
        }

        if(flagA) transpose.flagA(num);

        transpose.transpose();
        System.out.println(transpose.toString());
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
}
