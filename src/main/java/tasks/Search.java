package tasks;

public class Search {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "banana", "cherry"};
        String targetWord = "banana";
        boolean found = false;
        for (String word : words) {
            if (word.equals(targetWord)) {
                System.out.println("Слово " + word + " найдено");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Слово не найдено");
        }
    }
}