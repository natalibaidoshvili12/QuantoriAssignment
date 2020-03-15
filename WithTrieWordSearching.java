package wordSearching;

import java.util.ArrayList;
import java.util.List;

public class WithTrie {
	static class TrieNode {
		TrieNode[] Child = new TrieNode[26];
		boolean leaf;
		public TrieNode() {
			leaf = false;
			for (int i = 0; i < 26; i++)
				Child[i] = null;
		}
	}

	static void insert(TrieNode root, String str) {
		int n = str.length();
		TrieNode parent = root;
		for (int i = 0; i < n; i++) {
			int index = str.charAt(i) - 'A';
			if (parent.Child[index] == null)
				parent.Child[index] = new TrieNode();
			parent = parent.Child[index];
		}
		parent.leaf = true;
	}

	static void findingWord(TrieNode root, char letters[][], int i, int j, boolean empty[][], String str,
			List<String> list) {
		if (root.leaf && !hasWord(str, list))
			list.add(str);

		if (valid(i, j, empty)) {
			empty[i][j] = true;
			for (int k = 0; k < 26; k++) {
				if (root.Child[k] != null) {
					char ch = (char) (k + 'A');
					if (valid(i, j + 1, empty) && letters[i][j + 1] == ch)
						findingWord(root.Child[k], letters, i, j + 1, empty, str + ch, list);
					if (valid(i - 1, j - 1, empty) && letters[i - 1][j - 1] == ch)
						findingWord(root.Child[k], letters, i - 1, j - 1, empty, str + ch, list);
					if (valid(i, j - 1, empty) && letters[i][j - 1] == ch)
						findingWord(root.Child[k], letters, i, j - 1, empty, str + ch, list);
					if (valid(i + 1, j + 1, empty) && letters[i + 1][j + 1] == ch)
						findingWord(root.Child[k], letters, i + 1, j + 1, empty, str + ch, list);
					if (valid(i - 1, j, empty) && letters[i - 1][j] == ch)
						findingWord(root.Child[k], letters, i - 1, j, empty, str + ch, list);
					if (valid(i + 1, j, empty) && letters[i + 1][j] == ch)
						findingWord(root.Child[k], letters, i + 1, j, empty, str + ch, list);
				}
			}
			empty[i][j] = false;
		}
	}

	static boolean valid(int i, int j, boolean empty[][]) {
		return (i >= 0 && i < empty.length && j >= 0 && j < empty.length && !empty[i][j]);
	}

	static boolean hasWord(String str, List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(str))
				return true;
		}
		return false;
	}

	static void findWords(char letters[][], TrieNode root, List<String> list) {
		boolean[][] empty = new boolean[letters.length][letters.length];
		TrieNode parent = root;
		String str = "";
		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < letters.length; j++) {
				if (parent.Child[(letters[i][j]) - 'A'] != null) {
					str = str + letters[i][j];
					findingWord(parent.Child[(letters[i][j]) - 'A'], letters, i, j, empty, str, list);
					str = "";
				}
			}
		}
	}

	public static List<String> ans(char letters[][], String dictionary[]) {
		TrieNode root = new TrieNode();
		List<String> list = new ArrayList<>();
		int n = dictionary.length;
		for (int i = 0; i < n; i++)
			insert(root, dictionary[i]);
		findWords(letters, root, list);
		return list;
	}
}
