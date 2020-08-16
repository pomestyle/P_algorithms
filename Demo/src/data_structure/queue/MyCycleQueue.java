package data_structure.queue;

/**
 * 循环队列
 *
 * @author wangl
 */
public class MyCycleQueue {


    /**
     * 底层 用数组 来实现
     */
    private Long array[];

    /**
     * 有效数据的大小
     */
    private int element;

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
    public MyCycleQueue() {

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
    public MyCycleQueue(int maxSize) {
        array = new Long[maxSize];
        start = 0;
        element = 0;
        end = -1;

    }


    /**
     * 添加数据 从队尾插入
     *
     * @param value
     */
    public void push(long value) {

        //如果插入数据end 等于数组长度的话 就将end 从头开始继续插
        if (end == array.length - 1 ) {
            end = -1;
            //有效数据重置为0
            //element = 0;
        }

        //为什么这儿不用end++ end+返回+1之前的值 还是-1
        //++end 返回+1之后的值 0
        array[++end] = value;
        System.out.println(end+ " --> " +value);

        //有效数据++
        element++;
    }

    /**
     * 删除数据  从头部获取数据
     *
     * @return
     */
    public long remove() {
        //如果删除数据等于数组长度的时候 表示数组元素删除完 重新开始插入 重新开始删除
        if (start==array.length){
            start=0;
        }

        //有效数据减一
        element--;
        System.out.println(  " element =  " + element);

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
        return element == 0;
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

        MyCycleQueue myStack = new MyCycleQueue(6);

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


        System.out.println("循环队列插入");

        myStack.push(1);
        myStack.push(11);
        myStack.push(30);
        myStack.push(14);
        myStack.push(52);
        myStack.push(46);
        System.out.println(" ===  "+ myStack.array.length + " end =  " + myStack.end + " element =  " + myStack.element );

        // 循环队列插入的速度大于 遍历的速度 会出现元素覆盖现象
        // 此时element是5 继续插入 会覆盖 前三个元素空间, 此时element 是8 ,  遍历完后会继续遍历执行remove方法,直到 element 为0   但实际上的 数组元素没有被删除
        myStack.push(461);
        myStack.push(462);
        myStack.push(463);

        //遍历
        myStack.sysQueue();




    }

}
