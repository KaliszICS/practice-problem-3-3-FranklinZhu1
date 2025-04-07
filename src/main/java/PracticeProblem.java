import java.util.ArrayList;

public class PracticeProblem {

	public static void permHelper (ArrayList<String> arr, String used, String unused, boolean unique) {
		if (unused.length() <= 1) { // catches when length is 0 (empty string)
			if (unique && arr.contains(used + unused)) return;
			arr.add(used + unused);
			return;
		}
		for (int i = 0; i < unused.length(); ++i) {
			permHelper(arr, used + unused.substring(i, i + 1), unused.substring(0, i) + unused.substring(i + 1), unique); // second parameter is the character at i, third is the string minus that character
		}
		return;
	}

	public static ArrayList<String> perms(String str) {
		ArrayList<String> p = new ArrayList<String>();
		permHelper(p, "", str, false);
		return p;
	}

	public static ArrayList<String> permsUnique(String str) {
		ArrayList<String> p = new ArrayList<String>();
		permHelper(p, "", str, true);
		return p;
	}

}