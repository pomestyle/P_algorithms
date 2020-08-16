package data_structure.linked;


/**
 *  双向链表   链表保持对下一个节点的引用同时还保持前一个节点的引用
 */
public class DoubbleLinkeList {


    /**
     * 头节点
     */
    public Node first;

    /**
     * 尾节点
     */
    public Node last;


    public DoubbleLinkeList() {
        this.first = null;
        this.last = null;
    }


    public DoubbleLinkeList(Node first) {
        this.first = first;
    }


    /**
     * 插入一个链表 从头部插入
     */
    public void push(int value) {
        //新建一个节点
        Node node = new Node(value);

        //第一次添加
        if(isNull()){
            last=node;
        }else {
            //第一个节点前置指针指向 新节点node
            first.previous=node;
        }

        //fisr 的next 指向新节点
        node.next = first;
        //第一个节点等于新节点
        first = node;
    }


    /**
     * 尾巴节点插入
     */
    public void pushByLast(int value){

        Node node = new Node(value);
        //如果链表为空 则设置新节点为头节点
        if (isNull()){
            first = node;
        }else {
            //尾节点指针指向 新节点
            last.next=node;
            //新添加的前置指针指向
            node.previous = last;
        }

        //尾巴节点指针指向新节点地址
        last = node;
    }


    /**
     * 从尾部删除
     */
    public Node deleteLast(){

        Node temp = last;
        if (temp.next==null){
            last=null;
        }else {
            //尾节点的前一个节点的下一个指针等于Null
            last.previous.next=null;
        }

        //然后设置尾节点等于前一个节点
        last=temp.previous;

        return temp;
    }


    /**
     * 判断是否为空
     */
    public boolean isNull(){

        return  first == null;
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

        //如果头节点下一个节点为空  则表示 没有尾节点
        if (first.next==null){
            last=null;
        }else {
            //头结点的下一个节点的前置指针等于Null
            first.next.previous=null;
        }

        //重新指向first指针
        first = node.next;

        //返回要被删除的节点
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

        while (f1.data!= value) {

            if (f1.next == null) {
                return null;
            }

            //当前所指节点地址
            f1 =f1.next;
        }

        //如果first节点数据是要查找的数据  就把first的指针赋值给头指针
        if (f1==first){
            first=first.next;
        }else {
            //被删除的指针的前置指针的下一个指针 指向被删除的下一个指针所指节点
            f1.previous.next=f1.next;
        }

        return f1;

    }


    public static void main(String[] args) {


        DoubbleLinkeList linkeList = new DoubbleLinkeList();
        //从头插入
       /* linkeList.push(11);
        linkeList.push(31);
        linkeList.push(14);
        linkeList.push(21);
        linkeList.push(10);
*/

        //从尾部插入  先插入 先输出
        linkeList.pushByLast(31);
        linkeList.pushByLast(14);
        linkeList.pushByLast(21);
        linkeList.pushByLast(10);
        linkeList.pushByLast(10);

        //获取头节点 数据
        linkeList.deleteFirst().display();
        linkeList.deleteFirst().display();
        linkeList.deleteFirst().display();
        linkeList.deleteFirst().display();
        linkeList.deleteFirst().display();



        //遍历
        linkeList.display();

        System.out.println("----");
        /*//查找
        linkeList.find(31).display();

        System.out.println("----");
        //根据值删除
        linkeList.deletByValue(31).display();
        linkeList.display();*/


        // todo  可以从尾部节点插入数据  可以从尾部节点删除吗？
        //  不可以，无法通过 尾节点找到前一个节点的指针！！！
        //  尾节点没有保存上一个节点的指针域，可以使用指针来保存上一个节点的指针域，这种链表被称为双向链表
    }

}
