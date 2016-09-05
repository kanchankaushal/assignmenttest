package asignment;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

public class WordReorderTest {
	
	@Test
	public void reorderWordsTest(){
		WordReorder wordReorder = new WordReorder();
		List<String> words = new ArrayList<>();
        
        words.add("pawa");
        words.add("wapa");
        words.add("awpa");
        words.add("how");
        words.add("who");
        words.add("here");
        words.add("paw");
        words.add("wap");
        words.add("awp");
        
        List<String> finalList = wordReorder.reorderWords(words);
        
        List<String> finalListTest = new ArrayList<String>();
        finalListTest.add("3: pawa, wapa, awpa");
        finalListTest.add("3: paw, wap, awp");
        finalListTest.add("2: how, who");
        finalListTest.add("1: here");
        
        Assert.assertEquals(finalList, finalListTest);
	}
	
	@Test
	public void reorderWordsTestAllSame(){
		WordReorder wordReorder = new WordReorder();
		List<String> words = new ArrayList<>();
        
        words.add("pawa");
        words.add("pawa");
        words.add("pawa");
        words.add("pawa");
        
        List<String> finalList = wordReorder.reorderWords(words);
        
        List<String> finalListTest = new ArrayList<String>();
        finalListTest.add("4: pawa, pawa, pawa, pawa");
        
        Assert.assertEquals(finalList, finalListTest);
	}
}
