class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramGroups = new ArrayList<>();
        for (String str : strs) {
            boolean grouped = false;
            for(List<String> anagramGroup : anagramGroups) {
                if(isAnagram(anagramGroup.getFirst(), str)) {
                    anagramGroup.add(str);
                    grouped = true;
                    break;
                }
            }
            if (!grouped) {
                List group = new ArrayList<String>();
                group.add(str);
                anagramGroups.add(group);
            }
        }
        return anagramGroups;
    }

    private Map<String, Map<Character, Integer>> charCountMapCache = new HashMap<>();
    public Map<Character, Integer> collectCharCountMap(String s) {
        Map<Character, Integer> countS = charCountMapCache.get(s);
        if (countS == null) {
          countS = new HashMap<>();
        } else {
            return countS;
        }

        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
        }
        return countS;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> countS = collectCharCountMap(s);
        Map<Character, Integer> countT = collectCharCountMap(t);
        return countS.equals(countT);
    }
}
