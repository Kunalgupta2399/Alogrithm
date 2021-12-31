package FileHandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileExample {

    public static void main(String[] args) {
        //create
        //delete
        //write
        //read

        //go through library and implement the methods
        File file = new File("/Users/kunalgupta/Desktop/Alogrithm/Week1/src/FileHandling/test.txt"); //file object creation
        //handle the exceptions
        //null pointer
        //index out of bound
        //arithmetic
        //type mismatch
        //IO exception
        try {
//            FileWriter writer = new FileWriter(file);
//            file.createNewFile();
//            writer.write("this is my first file. file handling is awesome.");
//            writer.close();

            Scanner scanner = new Scanner(file);
            int count = 1;
            int countBooty = 0;
            int totalWords = 0;

            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                int wordsInLine = countWord(line);
                System.out.println("line number #" + count++ + " : " + line + " :: contains = " + wordsInLine + " words.");
                countBooty += countBootyFromLine(line);
                totalWords += wordsInLine;
            }

            System.out.println("count of booty is : " + countBooty);
            System.out.println("total words is : " + totalWords);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static int countBootyFromLine(String line) {
        String [] words = line.split(" ");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[i].equalsIgnoreCase("booty")) {
                count++;
            }
        }

        return count;
    }

    private static int countWord(String line) {
        String [] words = line.split(" ");
        return words.length;
    }
}
