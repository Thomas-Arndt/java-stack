import java.util.ArrayList;

public class TestPuzzling {

    public static void main(String[] args) {
        Puzzling puzzleTest = new Puzzling();

        // ArrayList rollResults = puzzleTest.getTenRolls();
        // for (int i = 0; i < rollResults.size(); i++) {
        //     System.out.println(rollResults.get(i));
        // }

        // System.out.println(puzzleTest.getRandomLetter());
        // System.out.println(puzzleTest.generatePassword());
        String[] passwordSet = puzzleTest.getNewPasswordSet(5);
        String[] shuffledPasswords = puzzleTest.shuffle(passwordSet);
        System.out.println("\n");
        for(int i = 0; i < shuffledPasswords.length; i++) {
            System.out.printf("%s\n", shuffledPasswords[i]);
        }
    }
}