package data_structure.stack;

/**
 * 栈  先进后出  后进先出
 *
 * @author wangl
 */
public class MyStack {


    /**
     * 底层 用数组 来实现
     */
    private Long array[];

    private int top = -1;

    /***
     * 默认构造方法
     */
    public MyStack() {

        array = new Long[10];
        top = -1;
    }


    /**
     * 带参数的构造
     *
     * @param maxSize
     */
    public MyStack(int maxSize) {
        array = new Long[maxSize];
        top = -1;


    }


    public void push(long value) {
        int index = ++top;
        array[index] = value;
    }

    /**
     * 移除(弹出)数据   获取后进的数据
     *
     * @return
     */
    public long pop() {
        return array[top--];
    }


    /**
     * 查看数据 不同弹出数据
     *
     * @return
     */
    public long peek() {
        return array[top];
    }


    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }


    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isFull() {
        return top == array.length - 1;
    }

    /**
     * 遍历栈
     */
    public void sysStack() {

        while (this.top > -1) {
            System.out.println(array[this.top]);
             this.top--;
        }


    }


    public static void main(String[] args) {

        MyStack myStack = new MyStack(6);

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);

        //查看是否为空
        System.out.println(myStack.isEmpty());
        //查看是否满了
        System.out.println(myStack.isFull());
        //查看元素
        System.out.println(myStack.peek());
        //移除元素
        System.out.println(myStack.pop());
        //查看元素
        System.out.println(myStack.peek());


        //遍历栈
        System.out.println("--遍历栈--");
        myStack.sysStack();


    }
}
