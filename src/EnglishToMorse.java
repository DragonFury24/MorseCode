import java.util.HashMap;

public class EnglishToMorse {
    private static HashMap<String, String> key = englishToMorseMap();

    public static String toMorse(String[] toMorse) {
        String[][] englishWords = new String[toMorse.length][];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < toMorse.length; i++)
            englishWords[i] = toMorse[i].split(" ");

        for (int i = 0; i < englishWords.length; i++) {
            for (int j = 0; j < englishWords[i].length; j++) {
                englishWords[i][j] = englishWords[i][j].trim().toUpperCase();
                stringBuilder.append(toMorseWord(englishWords[i][j])).append(" / ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String toMorseWord(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] letters = s.toCharArray();
        for (char letter : letters)
            stringBuilder.append(key.get(Character.toString(letter))).append(" ");
        return stringBuilder.toString();
    }

    private static HashMap englishToMorseMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < MorseCode.english.length; i++)
            hashMap.put(MorseCode.english[i], MorseCode.code[i]);
        return hashMap;
    }
}
