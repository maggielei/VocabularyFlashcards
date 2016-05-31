// VocabularyFlashcards.java handles any game functionality

package APP;

import java.util.*;

public class VocabularyFlashcards {
    private XMLParser parser;
    private HashMap definitionMap;

    // Create the English/German key-value HashMap
    public VocabularyFlashcards(){
        parser = new XMLParser();
        definitionMap = parser.getDefinitionMap();
    }
    public HashMap getHashMap() {
        return this.definitionMap;
    }

    // Populate randomMap with randomly selected keys from definitionMap
    public String generateRandomWord() {
        Random random = new Random();
        List<String> keys = new ArrayList<String>(definitionMap.keySet());
        String randomKey = keys.get(random.nextInt(keys.size()));

        return definitionMap.get(randomKey).toString();
    }

    public boolean checkAnswer(String Eng, String Ger){
        if(definitionMap.containsKey(Eng.toLowerCase())){
            if(definitionMap.get(Eng.toLowerCase()).equals(Ger)){
                System.out.println("Correct");
                return true;
            }
        }
        System.out.println("Incorrect");
        return false;
    }
}
