package wordSearching;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WordSearchingTest2 {

	@Test
	public void test() {
		char letters[][] = { { 'm', 'v', 'j', 'l', 'i', 'x', 'a', }, { 'j', 'h', 'b', 'x', 'e', 'e', 'n', },
				{ 'h', 'k', 't', 't', 'h', 'b', 's', }, { 'r', 'w', 'a', 'i', 'n', 'u', 'y', },
				{ 'p', 'p', 'f', 'x', 'r', 'd', 'z', }, { 't', 'p', 'n', 'l', 'q', 'o', 'y', },
				{ 'a', 'n', 'h', 'a', 'p', 'f', 'g', }, };
		String dictionary[] = { "orith", "wain", "dof", "algorithm", "syzygy", "dictionary" };
		WordSearching ws = new WordSearching();
		List<String> list = ws.ans(letters, dictionary);
		List<String> expected = Arrays.asList("orith", "wain", "dof");
		assertEquals(expected, list);
	}

}
