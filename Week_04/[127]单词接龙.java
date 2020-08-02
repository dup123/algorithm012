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
// 👍 394 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (beginWord.length() == 0
                    || beginWord.length() != endWord.length()
                    || !wordList.contains(endWord)) return 0;

            // 单词长度
            int len = endWord.length();
            // 通配符单词集合
            Map<String, ArrayList<String>> allComboDict = new HashMap<>();
            // 构建通配符数组
            wordList.forEach(currWord -> {
                for (int i = 0; i < len; i++) {
                    String comboWord = currWord.substring(0, i) + "*" + currWord.substring(i + 1, len);
                    ArrayList<String> comboWordList = allComboDict.getOrDefault(comboWord, new ArrayList<String>());
                    comboWordList.add(currWord);
                    allComboDict.put(comboWord, comboWordList);
                }
            });

            // 广度优先遍历队列
            Queue<Pair<String, Integer>> queue = new LinkedList<>();
            // 记录遍历过的单词
            Map<String, Boolean> visitedMap = new HashMap<>();
            // 添加第一个遍历的单词，深度为1
            queue.add(new Pair<String, Integer>(beginWord, 1));
            // 标记已访问过
            visitedMap.put(beginWord, true);
            // 广度优先遍历
            while (!queue.isEmpty()) {
                Pair<String, Integer> node = queue.remove();
                // 当前单词
                String currWord = node.getKey();
                Integer level = node.getValue();
                // 逐个字符处理
                for (int i = 0; i < len; i++) {
                    // 获取当前单词通配信息
                    String comboWord = currWord.substring(0, i) + "*" + currWord.substring(i + 1, len);
                    // 获取相邻单词列表
                    ArrayList<String> currWordList = allComboDict.getOrDefault(comboWord, new ArrayList<String>());
                    // 逐个检查判断是否是目标单词
                    for (String currComboWord : currWordList) {
                        // 是 直接返回结果
                        if (currComboWord.equals(endWord)) return level + 1;
                        // 不是判断是否之前处理过，没有处理过，加入队列,并标记
                        if (!visitedMap.containsKey(currComboWord)) {
                            visitedMap.put(currComboWord, true);
                            queue.add(new Pair<String, Integer>(currComboWord, level + 1));
                        }
                    }
                }
            }
            return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
