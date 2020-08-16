package data_structure.recursion;

/**
 * @author 递归
 */
public class Recursion {

    public static void main(String[] args) {
//        test(100);

        System.out.println(test2(100));
        System.out.println(test3(100));
    }



    /**
     * 打印0-100的数据
     */
    static void test(int num) {

        System.out.println(num);
        if (num == 0) {
            return;
        }

        test(--num);
    }


    /**
     * 循环实现第n项和 是n + (n-1)项值
     *
     * @return
     */
    static int test2(int n) {

        int total = 0;

        //n -1 项 值
        int m = n -1;
        while (m > 0) {

            total = total + m ;

            m--;
        }

        // n -1 项值  +  n
        return total + n;


    }

    /**
     * 递归实现 循环实现第n项和 是n + (n-1)项值
     */
    static int test3(int n) {

        if (n==1){
            //如果是1直接返回1
            return n;
        }else {
            return n + test3(n -1 );
        }

    }
}
