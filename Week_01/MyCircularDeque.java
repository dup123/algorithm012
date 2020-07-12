/**
 * 双端循环队列
 *
 * @author dup
 * @Description: 数组实现 + 双指针
 * headIndex 指向队首（第一个有效元素）的位置
 * tailIndex 指向队尾（最后一个有效的元素）的下一个位置
 * 数组越界判断 取模
 * @date 19:04 2020/7/12
 */
public class MyCircularDeque {
    /**
     * 存储数据的数组
     */
    private int[] data;

    /**
     * 头元素
     */
    private int headIndex;

    /**
     * 队列的元素个数
     */
    private int tailIndex;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        data = new int[k + 1];
        headIndex = 0;
        tailIndex = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        headIndex = (headIndex - 1 + data.length) % data.length;
        data[headIndex] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[tailIndex] = value;
        tailIndex = (tailIndex + 1) % data.length;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        headIndex = (headIndex + 1) % data.length;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tailIndex = (tailIndex - 1 + data.length) % data.length;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return data[headIndex];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(tailIndex - 1 + data.length) % data.length];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return headIndex == tailIndex;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return (tailIndex + 1) % data.length == headIndex;
    }
}
