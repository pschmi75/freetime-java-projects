package palindromeChecker;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String phrase = input.nextLine();
        if (isPalindrome(phrase)) System.out.println("\"" + phrase + "\" is a palindrome!");
        else System.out.println("\"" + phrase + "\" is not a palindrome!");
    }

    public static boolean isPalindrome(String phrase) {
        phrase = phrase.toLowerCase();
        for (int i = 0; i < phrase.length() / 2; i++) {
            if (phrase.charAt(i) != phrase.charAt(phrase.length() - i - 1)) return false;
        }
        return true;
    }
}
