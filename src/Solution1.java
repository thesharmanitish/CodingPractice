import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution1 {
	public static List<String> removeAnagrams(String[] words) {
		Map<Character, Integer> map = new HashMap<>();
		boolean[] visited = new boolean[words.length];
		List<String> result = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			map.clear();
			if (!visited[i]) {
				for (char c : words[i].toCharArray()) {
					map.put(c, map.getOrDefault(c, 0) + 1);

				}
				result.add(words[i]);
			}
			Map<Character, Integer> tmap = new HashMap<>(map);
			for (int j = i + 1; j < words.length; j++) {
				if (words[i].length() != words[j].length() )
					continue;
				for (char s : words[i].toCharArray()) {
					if (map.get(s) != null) {

						map.put(s, map.get(s) - 1);
						if (map.get(s) == 0)
							map.remove(s);
					} else
						break;
				}
				map.putAll(tmap);

			}
		}
		return result;
	}
	public static void main(String[] args) {
		String[] inp = {"a","b","c","d","e"};
		removeAnagrams(inp);
	}
}