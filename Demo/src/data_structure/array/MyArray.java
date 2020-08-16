package data_structure.array;


import java.util.Arrays;

/**
 * 自定义数组类封装 数组
 *
 * @author wangl
 */
public class MyArray {

    private long array[];

    private int element = 0;

    /**
     * 初始化
     *
     * @param maxSize
     */
    public void init(int maxSize) {

        array = new long[maxSize];

    }


    /**
     * 新增
     *
     * @param value
     */
    public void add(long value) throws Exception {

        if (array.length == element) {
            throw new Exception("数组长度已经满了。");
        }

        //赋值
        array[element] = value;

        //下标递增
        element++;

    }


    /**
     * 遍历数组
     */
    public void sysArray() {
        //判断数组长度
        if (array.length == 0) {
            System.out.println("暂无数据！");
        }

        System.out.print("[");
        for (int i = 0; i < this.array.length; i++) {

            System.out.print(array[i] + " ");
        }
        System.out.println("]");

    }


    /**
     * 根据下表查询数据
     *
     * @param index
     */
    public long getIndex(int index) {

        if (index >= element || index <= -1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return array[index];

    }


    /**
     * 根据值来查找  线性查找(从头到尾)
     *
     * @param value
     * @return
     */
    private int findByValue(int value) {

        //判断初始化
        if (this.array == null || array.length == 0) {
            return -1;
        }

        int index = 0;

        //遍历对比
        for (index = 0; index < array.length; index++) {
            if (array[index] == value) {
                break;
            }
        }

        //如果索引和长度一样相等 表示没有查询到
        if (index == element) {
            return -1;
        }


        return 1;
    }


    /**
     * 二分查找  前提数组必须是有序的
     */
    private int binarySearch(int value) {

        //排序
        Arrays.sort(array);

        //左边下标
        int low = 0;
        //左边下标
        int pow = element;

        //中间索引
        int middle = 0;

        while (true) {

            //中间索引
            middle = (low + pow) / 2;

            //如果中间数等于要查找的数 直接返回
            if (array[middle] == value) {

                return middle;

            } else if (low > pow) {
                return -1;
            } else if(array[middle]>value){
                //大于 从左半边开始查
               pow =  middle - 1;

            }else if (array[middle]<value){
                //从middle 左边 + 1 位置开始查
                low = middle  + 1;
            }
        }


    }


    /**
     * 根据索引删除
     *
     * @param index
     */
    private boolean removeByIndex(int index) {

        boolean falg = false;

        if (array == null || array.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index < 0 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }


        //搬迁的新数组
        long newArray[];

        for (int i = 0; i < array.length; i++) {
            if (index == array.length - 1) {
                //array[index]=null; 如果是引用的话 指向空引用

                //原始素组
                long[] var0 = this.array;
                element = index;
                //新数组
                newArray = new long[element];

                //元素搬迁
                for (int i1 = 0; i1 < newArray.length; i1++) {
                    newArray[i1] = var0[i1];
                }
                this.array = newArray;

                falg = true;
                break;
            } else if (index == i && index != array.length) {

                //讲后面元素往前移动
                this.array[i] = this.array[i + 1];
                element--;

                //删除原数组最后一个空元素位置  进行元素搬迁
                newArray = new long[array.length - 1];

                for (int l = 0; l < newArray.length; l++) {
                    newArray[l] = array[l];
                }
                //指向原地址
                this.array = newArray;
                falg = true;
                break;
            }


        }

        return falg;


    }


    /**
     * 更新下标值为value
     *
     * @param index
     * @param value
     */
    public void update(int index, long value) {

        if (index < 0 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }


        array[index] = value;


    }


    /**
     * 测试
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        MyArray myArray = new MyArray();
        //初始化
        myArray.init(6);

        //添加
        myArray.add(1);
        myArray.add(10);
        myArray.add(90);
        myArray.add(-10);
        myArray.add(-5);
        myArray.add(19);


        //打印
        myArray.sysArray();

        //查找index 下标的数据
        System.out.println(myArray.getIndex(1));

        //根据值来查找 返回下标 1表示查找到
        System.out.println(myArray.findByValue(1) == 1);

        //删除下标的数据
        System.out.println("---------- 删除 ---------- ");
        if (myArray.removeByIndex(0)) {
            System.out.println("删除成功!");
            //打印
            myArray.sysArray();
        }


        //更新
        System.out.println("---------- 更新 ----------");
        myArray.update(0, 100000);
        myArray.sysArray();


        System.out.println("---------- 二分查找 ----------");
        System.out.println(myArray.binarySearch(-5));
    }


}
