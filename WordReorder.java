package asignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordReorder {

    /**
     * @param args
     */
    public static void main(String[] args) {

    	Scanner keyboard = new Scanner(System.in);
    	
        WordReorder reorder = new WordReorder();
        List<String> words = new ArrayList<>();
        System.out.println("Press [Q] and enter to exit");
        while(true){
        	String input = keyboard.next();
        	if(input.equalsIgnoreCase("Q")){
        		break;
        	}
        	words.add(input);
        }
        
        /*words.add("pawa");
        words.add("wapa");
        words.add("awpa");
        words.add("how");
        words.add("who");
        words.add("here");
        words.add("paw");
        words.add("wap");
        words.add("awp");*/
        
        List<String> finalList = reorder.reorderWords(words);
        
        System.out.println("==Result==");
        for (String output : finalList)
            System.out.println(output);
        
        keyboard.close();
    }

    public List<String> reorderWords(List<String> words) {
        

        Map<String, List<String>> groupMap = new HashMap<>();

        for (String raw : words) {
            String sorted = sort(raw);

            List<String> wordList = groupMap.get(sorted);
            if (wordList == null) {
                wordList = new ArrayList<>();
                groupMap.put(sorted, wordList);
            }
            wordList.add(raw);
        }
        List<String> finalList = createSortedCSV(groupMap);
        Collections.sort(finalList, Collections.reverseOrder());
        return finalList;
    }

    private String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    private List<String> createSortedCSV(Map<String, List<String>> output) {
        List<String> list = new ArrayList<>();
        for (List<String> wordList : output.values()) {
            int size = wordList.size();
            String seq = String.valueOf(size) + ": ";
            String comma = ", ";
            for (String word : wordList) {
                seq = seq + word + comma;
            }
            list.add(seq.substring(0, seq.length() - 2));
        }
        return list;
    }
}
