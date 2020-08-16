package data_structure.linked;


/**
 * 链表
 */
public class LinkeList {


    /**
     * 链表头
     */
    public Node first;


    public LinkeList() {
        this.first = null;
    }


    public LinkeList(Node first) {
        this.first = first;
    }


    /**
     * 插入一个链表
     */
    public void push(int value) {
        //新建一个节点
        Node node = new Node(value);
        //新建节点的指针指向first保存的下一个node
        node.next = first;
        //第一个节点等于新建节点
        first = node;


    }


    /**
     * 显示方法
     */
    public void display() {


        // first 头指针 指向下一个Node
        Node f1 = first;
        // 指针指向下一个node 为空时候就表示没数据了
        while (f1 != null) {
            //Node .data 就是数据
            System.out.println(f1.data);
            //遍历完之后指向下一个指针
            f1 = f1.next;
        }

        System.out.println(" =========== ");
    }


    /**
     * 删除一个节点 在头节点进行删除
     */

    public Node deleteFirst() {
        //头节点指针
        Node node = first;

        //重新指向first指针
        first = node.next;

        return node;
    }


    /**
     * 根据值 查找方法
     */
    public Node find(int value) {

        //从first 头节点开始查找
        Node f1 = first;

        while (f1.data != value) {

            if (f1.next == null) {
                return null;
            }
            f1=f1.next;
        }

        return f1;
    }

    /**
     * 根据数据 来删除
     * 返回删除的节点
     */
    public Node deletByValue(int value){

        //从first 头节点开始查找  当前所指
        Node f1 = first;
        //查找的节点
        Node f2 = first;

        while (f1.data!= value) {

            if (f1.next == null) {
                return null;
            }

            //前节点地址
            f2=f1;

            //当前所指节点地址
            f1 =f1.next;
        }

        //如果first节点数据是要查找的数据  就把first的指针赋值给头指针
        if (f1==f2){
            first=first.next;
        }else {
            //前节点指向被删除的节点（指向下一个节点的指针）
            f2.next=f1.next;
        }

        return f1;

    }


    public static void main(String[] args) {


        LinkeList linkeList = new LinkeList();
        linkeList.push(11);
        linkeList.push(31);
        linkeList.push(14);
        linkeList.push(21);
        linkeList.push(10);
        linkeList.push(10);

        //获取头节点 数据
        linkeList.deleteFirst().display();
        linkeList.deleteFirst().display();
        linkeList.deleteFirst().display();

        linkeList.display();


        /*//遍历
        linkeList.display();

        System.out.println("----");
        //查找
        linkeList.find(31).display();

        System.out.println("----");
        //根据值删除
        linkeList.deletByValue(31).display();
        linkeList.display();*/
    }

}
