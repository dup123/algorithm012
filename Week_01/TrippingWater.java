/**
 * 接雨水
 *   使用栈的方法进行处理
 *
 * @author dup
 * @Description:
 * 蓄水量为每隔俩柱子真实高度差之间面积之和
 * 1.使用栈存储height数组下表，数组下表基于当前索引递减
 * 2.找当前柱子的边界值
 * 3.计算公式 space = boundHeight * distance
 * @date 21:31 2020/7/12
 */
public class TrippingWater {
    /**
     * 栈存储height数组下表
     * 遍历数组
     *
     * @param heights
     * @return
     */
    public static int trap(int[] heights) {
        // 定义单调递减栈 保存柱子高度数组下表
        Stack<Integer> stack = new Stack<Integer>();
        int i=0,sum = 0;
        while (i < heights.length) {
            // 当前柱子左边界的高度
            // 储水量 = 长（当前柱子高度与左边界前两个柱子高度之差的最小值决定蓄水高度）* 宽（当前柱子与左边界值最高的距离）
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                // 取出栈顶元素
                int topIndex = stack.pop();
                // 栈判断（是否存在前一个柱子）不存在，就跳出循环，
                if(stack.isEmpty()) { break;}
                // 当前柱子（数组下表）和左边界的柱子（当前栈元素）相隔记录
                int distance = i - stack.peek() - 1;
                // 边界高度=当前高度和左边界高度相隔的差的最小值 - 相隔中间柱子的高度
                int boundHeight = Math.min(heights[i], heights[stack.peek()]) - heights[topIndex];
                // 计算面积且累加
                sum += distance * boundHeight;

            }
            // 存储当前柱子下边作为下一个柱子的左边界下边素材
            stack.push(i++);
        }
        return sum;
    }
}
