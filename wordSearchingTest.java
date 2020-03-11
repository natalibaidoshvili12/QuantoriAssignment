package wordSearching;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class wordSearchingTest {

	@Test
	public void test() {
		char letters[][] = { { 'm', 'v', 'j', 'l', 'i', 'x', 'a', 'p', 'e' },
				{ 'j', 'h', 'b', 'x', 'e', 'e', 'n', 'p', 'p' }, { 'h', 'k', 't', 't', 'h', 'b', 's', 'w', 'y' },
				{ 'r', 'w', 'a', 'i', 'n', 'u', 'y', 'z', 'h' }, { 'p', 'p', 'f', 'x', 'r', 'd', 'z', 'k', 'q' },
				{ 't', 'p', 'n', 'l', 'q', 'o', 'y', 'j', 'y' }, { 'a', 'n', 'h', 'a', 'p', 'f', 'g', 'b', 'g' },
				{ 'h', 'x', 'm', 's', 'h', 'w', 'y', 'l', 'y' }, { 'u', 'j', 'f', 'j', 'h', 'r', 's', 'o', 'a' } };
		String dictionary[] = { "algorithm", "syzygy", "ape", "hshp", "byk", "hhpq", "kkp" };
		WordSearching ws = new WordSearching();
		List<String> list = ws.ans(letters, dictionary);
		List<String> expected = Arrays.asList("ape", "byk", "syzygy", "algorithm", "hhpq", "hshp");
		assertEquals(expected, list);
	}

}
