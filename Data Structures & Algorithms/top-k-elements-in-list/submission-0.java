class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Collect the frequencies of each number
        Map<Integer, Integer> numFrequencies = new HashMap<>();
        for(int num : nums) {
            int numFrequency = numFrequencies.getOrDefault(num, 0);
            numFrequencies.put(num, numFrequency + 1);
        }

        // Accumulate the list of top k frequencies
        PriorityQueue<int[]> topKFrequencies = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(Map.Entry<Integer, Integer> entry: numFrequencies.entrySet()) {
            topKFrequencies.offer(new int[]{entry.getValue(), entry.getKey()});
            // Shave one off the end of queue to maintain size k
            if (topKFrequencies.size() > k) {
                topKFrequencies.poll();
            }
        }

        return topKFrequencies.stream().mapToInt(pair -> pair[1]).toArray();
    }
}
