import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class java_task {
    public static void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    public static int romanToInteger(String s) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            int value = romanCharToInt(c);

            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }

            prevValue = value;
        }
        return result;
    }
    public static int romanCharToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    public static boolean isPangram(String s) {
        // Convert the input to lowercase to make the check case-insensitive
        s = s.toLowerCase();

        // Initialize an array to mark the presence of each letter from 'a' to 'z'
        boolean[] isPresent = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                isPresent[c - 'a'] = true;
            }
        }

        // Check if all alphabet letters are present
        for (boolean letterPresent : isPresent) {
            if (!letterPresent) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Create an array and shuffle it
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        shuffleArray(array);
        System.out.print("Shuffled array: ");
        System.out.println(Arrays.toString(array));

        // Get a Roman numeral input and convert it to an integer
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a Roman numeral (e.g., IX = 9): ");
        String romanNumeral = scanner.nextLine();
        int intValue = romanToInteger(romanNumeral);
        System.out.println("Integer value of " + romanNumeral + " is: " + intValue);

        // Check if the input is a pangram
        System.out.print("Enter a sentence to check for a pangram: ");
        String sentence = scanner.nextLine();
        boolean isPangram = isPangram(sentence);
        if (isPangram) {
            System.out.println("The input is a pangram.");
        } else {
            System.out.println("The input is not a pangram.");
        }
    }
}