package org.fari;



import info.debatty.java.stringsimilarity.RatcliffObershelp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("/Users/mihaildavydov/IdeaProjects/string_matcher/src/main/java/org/fari/input.txt"));
        File file_out = new File("/Users/mihaildavydov/IdeaProjects/string_matcher/src/main/java/org/fari/output.txt");
        PrintWriter pw = new PrintWriter(file_out);

        int n = Integer.parseInt(lines.get(0));
        int m = Integer.parseInt(lines.get(n + 1));

        List<String> firstPart = new ArrayList<>();
        List<String> secondPart = new ArrayList<>();

        if (n == 1) {
            firstPart.add(lines.get(1));
        } else for (int i = 1; i <= n; i++) {
            firstPart.add(lines.get(i));
        }

        for (int i = n + 2; i < lines.size(); i++) {
            secondPart.add(lines.get(i));
        }

        System.out.println(lines); // инпут от юзера
        System.out.println(n); // кол-во первых строк
        System.out.println(m); // кол-во вторых строк
        System.out.println(firstPart);
        System.out.println(secondPart);

        RatcliffObershelp ro = new RatcliffObershelp();

        String answer;
        for (String fp : firstPart) {
            for (String sp : secondPart) {
                if ((ro.similarity(fp, sp) > 0.4)) {
                    answer = fp + ":" + sp;
                    System.out.println(answer);
                    pw.println(answer);
                }
            }
            System.out.println();
        }
        pw.close();
    }
}


















