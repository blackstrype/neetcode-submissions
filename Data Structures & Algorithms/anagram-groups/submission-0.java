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

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }
}
