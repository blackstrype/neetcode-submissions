class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Map<Character, Integer> scount = new HashMap<>();
        Map<Character, Integer> tcount = new HashMap<>();
        if (sc.length != tc.length) {
            return false;
        }
        for (int i = 0; i < sc.length; i++) {
            scount.put(sc[i], scount.getOrDefault(sc[i], 0) + 1);
            tcount.put(tc[i], tcount.getOrDefault(tc[i], 0) + 1);
        }
        for (Character key : scount.keySet()) {
            Integer tval = tcount.get(key);
            Integer sval = scount.get(key);
            if (tval == null || !sval.equals(tval)) {
                System.err.println("Counts: " + tval + "," + sval);
                return false;
            }
        }
        return true;
    }
}
