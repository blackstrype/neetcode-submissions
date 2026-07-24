class Solution {
    String DELIMITER = "!!";

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return null;
        }
        return String.join(DELIMITER, strs);
    }

    public List<String> decode(String str) {
        System.out.println(str);
        if (str == null) {
            return new ArrayList();
        }
        return List.of(str.split(DELIMITER, -1));
    }
}
