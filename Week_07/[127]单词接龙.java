//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 409 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 异常检查
        if(beginWord.length() == 0 || beginWord.length() != endWord.length() || !wordList.contains(endWord)) return 0;

        // 基础数据准备
        int len = beginWord.length();
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();

        // 基础通配字典数据构建（相邻结点）
        wordList.forEach(currWord -> {
            for(int i=0; i<len; i++) {
                String comboWord = currWord.substring(0, i) + "*" + currWord.substring(i+1, len);
                ArrayList<String> comboWordList = allComboDict.getOrDefault(comboWord, new ArrayList<String>());
                comboWordList.add(currWord);
                allComboDict.put(comboWord, comboWordList);
            }
        });

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        HashMap<String, Boolean> visitedMap = new HashMap<>();

        queue.offer(new Pair<String, Integer>(beginWord, 1));
        visitedMap.put(beginWord, true);

        // 广度优先遍历
        while(!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String currWord = node.getKey();
            Integer level = node.getValue();
            for(int i=0; i<len; i++) {
                String comboWord = currWord.substring(0, i) + "*" + currWord.substring(i+1, len);
                ArrayList<String> comboWordList = allComboDict.getOrDefault(comboWord, new ArrayList<String>());
                for(String word : comboWordList) {
                    if(word.equals(endWord)) return level + 1;
                    if(!visitedMap.containsKey(word)) {
                        queue.offer(new Pair<String, Integer>(word, level + 1));
                        visitedMap.put(word, true);
                    }
                }
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
