import java.util.HashMap;

public class MorseToEnglish {
    private static HashMap<String, String> key = morseToEnglishMap();

    public static String toEnglish(String[] toEnglish) {
        String[][] morseWords = new String[toEnglish.length][];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < toEnglish.length; i++)
            morseWords[i] = toEnglish[i].split("/");

        for (int i = 0; i < morseWords.length; i++) {
            for (int j = 0; j < morseWords[i].length; j++) {
                morseWords[i][j] = morseWords[i][j].trim();
                stringBuilder.append(toEnglishWord(morseWords[i][j])).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String toEnglishWord(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] letters = s.split(" ");
        for (String letter: letters)
            stringBuilder.append(key.get(letter));
        return stringBuilder.toString();
    }

    private static HashMap morseToEnglishMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < MorseCode.code.length; i++)
            hashMap.put(MorseCode.code[i], MorseCode.english[i]);
        return hashMap;
    }
}
