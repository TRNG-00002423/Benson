import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Week 2 Exercise — String analysis (implement TODO methods).
 *
 * Compile: javac TextAnalyzer.java
 * Run:     java TextAnalyzer
 */
public class TextAnalyzer {
    /**
     * Find the word count after stripping all whitespace
     *
     * @param text is a String
     * @return the word count
    */
    public static int wordCount(String text) {
        String[] parts = text.split("\\s+");
        int count = 0;
        for(String part: parts){
            count += part.length();
        }
        return count;
    }

    public static boolean isPalindrome(String token) {
        /**
         * Find if a string is a palindrome
         * 
         * @param token is a String
         * @return true if the token is a palindrome else false
        */
        String cleanedToken = token.trim().toLowerCase();
        int leftPtr = 0;
        int rightPtr = cleanedToken.length() - 1;
        while(leftPtr < rightPtr){
            if(cleanedToken.charAt(leftPtr) != cleanedToken.charAt(rightPtr)){
                return false;
            }
            leftPtr += 1;
            rightPtr -= 1;
        }
        return true;
    }

    private static boolean findOccurence(int offset, String haystack, String needle){
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        for(int i = 0; i < haystackLength; i++){
            if(i + offset > haystackLength){
                return false;
            }
            if(haystack.charAt(i + offset) != needle.charAt(i)){
                return false;
            }

            if(i == needleLength - 1){
                return true;
            }
        }

        return true;
    }

    public static int countOccurrences(String haystack, String needle) {
        /**
         * Find the number of occurence of a substring in a string
         * 
         * @param offset is an int,
         * @param haystack is a String
         * @param needle is a String
         * @return the number of occurence of the substring in the string
        */
        int needleLength = needle.length();
        int haystackLength = haystack.length();

        if(needleLength > haystackLength){
            return 0;
        }

        int count = 0;

        for(int i = 0; i < haystackLength; i++){
            if(findOccurence(i, haystack, needle)){
                count += 1;
            }
        }

        return count;

    }

    public static void main(String[] args) throws IOException {
        Path p = Path.of("sample.txt");
        String body = Files.readString(p);
        System.out.println("words=" + wordCount(body));
        System.out.println("palindrome(Radar)=" + isPalindrome("Radar"));
        System.out.println("occurrences of 'QA'=" + countOccurrences(body, "QA"));
    }
}