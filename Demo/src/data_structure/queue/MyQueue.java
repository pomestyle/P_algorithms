package data_structure.queue;

import data_structure.stack.MyStack;

/**
 * 队列
 *
 * @author wangl
 */
public class MyQueue {


    /**
     * 底层 用数组 来实现
     */
    private Long array[];

    /**
     * 有效数据的大小
     */
    private int element ;

    /**
     * 队头
     */
    private int start;

    /**
     * 队尾
     */
    private int end;


    /***
     * 默认构造方法
     */
    public MyQueue() {

        array = new Long[10];
        start = 0;
        element = 0;
        end = -1;
    }


    /**
     * 带参数的构造
     *
     * @param maxSize
     */
    public MyQueue(int maxSize) {
        array = new Long[maxSize];
        start = 0;
        element = 0;
        end = -1;

    }


    /**
     * 添加数据 从队尾插入
     * @param value
     */
    public void push(long value) {

        array[++end] = value;

        //有效数据++
        element++;
    }

    /**
     * 删除数据  从头部获取数据
     *
     * @return
     */
    public long remove() {
        //有效数据减一
        element--;
        //有效数据
        return array[start++];
    }


    /**
     * 查看数据
     *
     * @return
     */
    public long peek() {
        return array[start];
    }


    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return element==0;
    }


    /**
     * 判断 队列是否满了
     *
     * @return
     */
    public boolean isFull() {
        return element == array.length;
    }

    /**
     * 遍历队列
     */
    public void sysQueue() {

        while (!this.isEmpty()) {
            System.out.println(remove());
        }


    }


    public static void main(String[] args) {

        MyQueue myStack = new MyQueue(6);

        myStack.push(1);
        myStack.push(11);
        myStack.push(30);
        myStack.push(14);
        myStack.push(52);
        myStack.push(46);

        //查看是否为空
        System.out.println(myStack.isEmpty());
        //查看是否满了
        System.out.println(myStack.isFull());
        //查看元素
        System.out.println(myStack.peek());
        //移除元素
        System.out.println(myStack.remove());
        //查看元素
        System.out.println(myStack.peek());


        //遍历栈
        System.out.println("--遍历队列--");
        myStack.sysQueue();


        //再插入 队列  抛出异常： " java.lang.ArrayIndexOutOfBoundsException: 6
        //原因是 start 已经移动到数组底部了，虽然数组所有元素为空了。此时长度是6 end也是6
        // 解决办法是使用循环队列 当end 到达底部的时候 将end进行重置 start进行重置
        myStack.push(123);





    }

}
