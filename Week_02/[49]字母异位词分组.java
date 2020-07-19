//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 396 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 排序数组分类
 * 使用哈希表记录分组信息
 * 1.key 代表一组异位字符串
 *  确认：字符串排序 统一作为key
 *  根据key 往map中添加 值
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 异常校验
        if(strs.length == 0) return null;
        Map<String, List<String>> resMap = new HashMap<>();
        // 遍历字符串
        for(String str : strs) {
            // 字符数组
            char[] item = str.toCharArray();
            // 字符排序作为key
            Arrays.sort(item);
            // 基于同key,分组
            String key = String.valueOf(item);
            // 不包含当前key，基本key 添加到list
            if(!resMap.containsKey(key))
                resMap.put(key, new ArrayList<String>());
            // 根据同key添加字符串，实现分组
            resMap.get(key).add(str);
        }
        // 返回结果
        return new ArrayList<>(resMap.values());

    }
}
//leetcode submit region end(Prohibit modification and deletion)
