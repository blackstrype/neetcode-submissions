class Solution {
    private static final int MAX_POSSIBLE_SEQUENCE = 1000;

    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = IntStream.of(nums)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));
        int maxSequence = 0;
        for(Integer number : numbers) {
            if(!numbers.contains(number - 1)) {
                int i = number + 1;
                int sequence = 1;
                while(i < MAX_POSSIBLE_SEQUENCE && numbers.contains(i++)) {
                    sequence++;
                }
                maxSequence = Math.max(sequence, maxSequence);
            }
        }
        return maxSequence;
    }
}
