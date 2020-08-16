package data_structure.array;

import java.util.Arrays;

/**
 * 数组排序
 *
 * @author 鲜橙科技
 */
public class MyArraySort {

    private long[] myArra;

    /**
     * 冒泡排序
     */
    private void bubbleSort(long[] myArra) {

        long temp = 0;
        int index = 0;

        // 2,1,3,4,6  两两比较 外层循环 -1 次
        //   1,3,4,6
        for (int i = 0; i < myArra.length - 1; i++) {
            System.err.println("第 " + (i + 1) + "轮开始 ");

            for (int j = 0; j < myArra.length - i - 1; j++) {


                System.out.println("----- 第 " + (j + 1) + "次比较前的数组数据 " + Arrays.toString(myArra));

                //每次都进行比较交换
                if (myArra[j] > myArra[j + 1]) {
                    //保存大值 进行交换
                    temp = myArra[j];
                    //小值前移
                    myArra[j] = myArra[j + 1];
                    //大值后移
                    myArra[j + 1] = temp;
                }
                System.out.println("----- 第 " + (j + 1) + "次比较[后]的数组数据 " + Arrays.toString(myArra));
            }


        }


    }


    /**
     * 选择排序
     */
    private void selectSort(long myArra[]) {

        //指向循环开始的地方
        int k = 0;
        long temp;

        for (int i = 0; i < myArra.length - 1; i++) {
            k = i;

            //从第i个开始 比较完之后 就不需要比较了 会把最小的放在第i个位置
            // 如  9,2,1,3,4  第一次比较之后 k为2 值为 1 , 数据交换之后数组为 1,2,9,3,4
            for (int j = i; j < myArra.length; j++) {

                //最外层 第一个 跟 最里层每一个相比 取值最小的下标
                if (myArra[k] > myArra[j]) {
                    //k指向最小的数据
                    k = j;
                }

            }


            System.out.println("第 " + (i + 1) + "轮比较 k处下标 是 " + k + " 最小值为 " + myArra[k]);
            System.err.println("交换之前数据为 : " + Arrays.toString(myArra));

            //第i个位置元素值
            temp = myArra[i];

            //将最小值赋给第i个
            myArra[i] = myArra[k];
            //讲第i个位置值赋给下标最小值k处元素
            myArra[k] = temp;

            System.err.println("交换之[后]数据为 : " + Arrays.toString(myArra));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    /**
     * 希尔排序
     * 基于插入排序添加了一些新特性,大大提高了插入排序的执行效率
     * 加大排序元素之间的间隔,对这些间隔的元素进行排序,从而使得元素可以大幅度移动;
     * 完成间隔移动后,希尔排序会减少数据间隔,继续进行排序.依次进行下去;
     * <p>
     * 插入排序:多次移动,存在缺陷
     */
    private void shellSort(long[] myArra) {

        //计算间隔 初始值是1
        int h = 1;
        //计算最大间隔 不大于数组大小的最大值
        while (h < myArra.length) {
            h = h * 3 + 1;
            System.out.println(" h  : " + h);
        }

        System.out.println("最大间隔是 : " + h);

        long temp = 0;

        //间隔减少计算
        // h = (h -1) /3
        while (h > 0) {

            System.out.println("当前间隔是: " + h);

            //从跨度h开始比较
            for (int i = h; i < myArra.length; i++) {
                //初始值
                temp = myArra[i];

                int j = i;

                //初始值和 跨度直进行比较
                while (j > h - 1 && myArra[j - h] >= temp) {
                    myArra[j] = myArra[j - h];
                    j -= h;
                }
                //j位置的 进行最小值赋值
                myArra[j] = temp;
            }

            //减小的间隔
            h = (h - 1) / 3;

        }
    }

    /**
     * 插入排序
     */
    private void insertSort(long[] myArra) {

        long temp = 0;


        //i=1 首部 要保持一个空位数据
        for (int i = 1; i < myArra.length; i++) {
            // 2,1,0,-1  - 1 ,2,0 ,-1
            //  1 2 0 -1
            //  0 1 2 -1
            //  -1 0 1 2
            // 0 1 2 3
            //初始值
            temp = myArra[i];//1 i=1 0 i=2

            int j = i;
            System.out.println(temp + "--->" + myArra[j - 1]);

            //初始值和 myArra[j] 进行比较 如果大于则 数组J开始整体向后移动
            while (j > 0 && myArra[j - 1] >= temp) {
                System.err.println(j);
                myArra[j] = myArra[j - 1];

                j--;
            }
            //j位置的 进行最小值赋值
            myArra[j] = temp;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Arrays.toString(myArra));
        }


    }


    public static void main(String[] args) {


        MyArraySort myArray = new MyArraySort();
        //原数组
//        long[] arr = new long[]{9, 0, 2, 7, 1, 8, 10, 2};
        long[] arr = new long[]{9, 0, 2, 7, 1, 8, 10, -12, 2,3,6};

        System.out.println(Arrays.toString(arr));

//        long[] arr = new long[]{9, 0, 2, 7, 1};
        //冒泡排序
//        myArray.bubbleSort(arr);
        //选择排序
//        myArray.selectSort(arr);
        //插入排序
//        myArray.insertSort(arr);
        //希尔排序
//        myArray.shellSort(arr);
        //快速排序
//        myArray.quickSort(arr);

        //切点下标
        //myArray.partition(arr, 0, arr.length - 1, arr[arr.length - 1]);
        //快速排序
        myArray.quickSort(arr, 0, arr.length - 1);

        //打印
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 快速排序
     *
     * @param arr
     */
    private void quickSort(long[] arr, int left, int right) {

        if (right - left <= 0) {
            return;
        } else {

            //设置关键字
            long point = arr[right];

            //获得切入点 对数组进行切分
            int partition = partition(arr, left, right, point);

            //对左边的数组进行快速排序
            quickSort(arr, left, partition - 1);
            //对右边的数组进行快速排序
            quickSort(arr, partition + 1, right);

        }

    }


    /**
     * 快速排休获取分区点
     *
     * @param arr   数组
     * @param left  左边下标
     * @param right 右边下标
     * @param point 区分值
     * @return
     */
    public int partition(long[] arr, int left, int right, long point) {

        //可以自己选择一个数组里的元素进行 左右分区
        // 一般选择数组最右边的元素进行原地分区
        // 比最后一个大的放在右边
        // 比最后一个小的放在数组左边
        //左边
        int rightS = right;
        //左边
        int leftS = left - 1;

        while (true) {

            //将关键字小的留在左边  指针从左边开始往右边查,当左边指针所指的值大于point 时候循环停下
            while (leftS < rightS && arr[++leftS] < point) ;
            //将关键字大的留在右边  指针从右边开始往左边查,当右边指针所指的值小于point 时候循环停下
            while (rightS > leftS && arr[--rightS] > point) ;
            if (leftS >= rightS) {
                break;
            } else {
                //获取 并且交换 两个值 继续循环
                long tem = arr[leftS];
                arr[leftS] = arr[rightS];
                arr[rightS] = tem;
            }

        }

        // 交换分区值和中间值
        //中间值
        int temp = (int) arr[leftS];
        //中间值等于最后一个值
        arr[leftS] = arr[right];
        //最后面值等于中间值
        arr[right] = temp;

        //返回区分点下标
        return leftS;
    }

}
