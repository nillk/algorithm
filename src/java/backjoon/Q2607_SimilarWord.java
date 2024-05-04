package backjoon;

import java.util.Scanner;

public class Q2607_SimilarWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        byte N = scan.nextByte();
        scan.nextLine();

        String word = scan.nextLine();
        int wordLength = word.length();

        byte count = 0;

        for (byte i = 1; i < N; i++) {
            String cand = scan.nextLine();
            int candLength = cand.length();

            if (candLength == wordLength) {
                for (int j = 0; j < wordLength; j++) {
                    if (cand.indexOf(word.charAt(j)) >= 0) {
                        cand = cand.replaceFirst(String.valueOf(word.charAt(j)), " ");
                    }
                }

                if (cand.trim().length() < 2) {
                    count++;
                }
            } else if (candLength + 1 == wordLength && checkWords(word, cand)) {
                count++;
            } else if (candLength - 1 == wordLength && checkWords(cand, word)) {
                count++;
            }
        }

        System.out.println(count);

        scan.close();
    }

    private static boolean checkWords(String longWord, String shortWord) {
        for (int i = 0; i < shortWord.length(); i++) {
            if (longWord.indexOf(shortWord.charAt(i)) >= 0) {
                longWord = longWord.replaceFirst(String.valueOf(shortWord.charAt(i)), " ");
            }
        }

        if (longWord.trim().length() == 1) {
            return true;
        }
        return false;
    }
}
