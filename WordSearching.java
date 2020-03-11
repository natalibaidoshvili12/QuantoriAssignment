package wordSearching;

import java.util.ArrayList;
import java.util.List;

public class WordSearching {

	static boolean rightWord(String str, String dictionary[]) {
		for (int i = 0; i < dictionary.length; i++)
			if (str.equals(dictionary[i]))
				return true;
		return false;
	}

	static boolean hasWord(String str, List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(str))
				return true;
		}
		return false;
	}

	static void findWordsLeft(char letters[][], boolean empty[][], int i, int j, String str, List<String> list,
			String dictionary[]) {
		empty[i][j] = true;
		str = str + letters[i][j];
		if (rightWord(str, dictionary) && !hasWord(str, list))
			list.add(str);
		for (int row = i; row <= i + 1 && row < letters.length; row++)
			for (int col = j; col <= j + 1 && col < letters.length; col++)
				if (row >= 0 && col >= 0 && !empty[row][col])
					findWordsLeft(letters, empty, row, col, str, list, dictionary);
		str = "" + str.charAt(str.length() - 1);
		empty[i][j] = false;
	}

	private static void findWordsRight(char[][] letters, boolean[][] empty, int i, int j, String str, List<String> list,
			String dictionary[]) {
		empty[i][j] = true;
		str += letters[i][j];

		if (rightWord(str, dictionary) && !hasWord(str, list))
			list.add(str);
		for (int row = i; row >= i - 1 && row >= 0; row--)
			for (int col = j; col >= j - 1 && col >= 0; col--)
				if (row < letters.length && col < letters.length && !empty[row][col])
					findWordsRight(letters, empty, row, col, str, list, dictionary);
		str = "" + str.charAt(0);
		empty[i][j] = false;

	}

	public static List<String> ans(char letters[][], String dictionary[]) {

		System.out.println("Following words of dictionary are present");
		List<String> list = new ArrayList<>();
		boolean empty[][] = new boolean[letters.length][letters.length];

		String str = "";
		for (int i = 0; i < letters.length; i++)
			for (int j = 0; j < letters.length; j++)
				findWordsLeft(letters, empty, i, j, str, list, dictionary);
		for (int i = letters.length - 1; i >= 0; i--) {
			for (int j = letters.length - 1; j >= 0; j--) {
				findWordsRight(letters, empty, i, j, str, list, dictionary);
			}
		}
		return list;
	}
}
