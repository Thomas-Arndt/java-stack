import java.util.ArrayList;
import java.util.Random;

public class Puzzling{

    public ArrayList getTenRolls() {
        ArrayList<Integer> rolls = new ArrayList<Integer>(10);
        Random randomGenerator = new Random();

        for (int i = 0; i < 10; i++) {
            rolls.add(randomGenerator.nextInt(20)+1);
        }

        return rolls;
    }

    public String getRandomLetter() {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Random randomGenerator = new Random();

        return letters[randomGenerator.nextInt(26)];
    }

    public String generatePassword() {
        String password = new String();
        for(int i = 0; i < 8; i++) {
            password = password.concat(getRandomLetter());
        }
        return password;
    }

    public String[] getNewPasswordSet (int setSize) {
        String[] passwordSet = new String[setSize];
        for(int i = 0; i < setSize; i++) {
            passwordSet[i] = generatePassword();
        }
        for(int i = 0; i < passwordSet.length; i++) {
            System.out.printf("%s\n", passwordSet[i]);
        }
        return passwordSet;
    }

    public String[] shuffle(String[] items) {
        Random randomGenerator = new Random();
        int index1 = 0;
        int index2 = 0;
        for(int i = 0; i < items.length; i++){
            index1 = randomGenerator.nextInt(items.length);
            index2 = randomGenerator.nextInt(items.length);
            String temp = items[index1];
            items[index1] = items[index2];
            items[index2] = temp;
        }
        return items;
    }
}