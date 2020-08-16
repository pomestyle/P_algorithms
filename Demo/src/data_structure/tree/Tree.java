package data_structure.tree;

/**
 * 树结合了 数组查找元素和链表增删元素的优点
 * <p>
 * 二叉树 : 每个节点只有两个子节点
 *
 * @author wangl
 */
public class Tree {

    //父节点
    private Node root;

    /**
     * 插入
     *
     * @param value
     */
    public void insert(int value) {


        //新建一个节点
        Node node = new Node(value);

        // 一次成功插入节点后,当前引用节点和父节点会指向新节点
        //引用当前节点
        Node current = root;
        //引用父节点
        Node parent;

        //第一次插入
        if (root == null) {
            root = node;
            return;
        } else {
            while (true) {
                //父节点指向当前节点
                parent = current;
                //当前节点比这个数据大 则往左走
                if (current.data > value) {
                    //当前节点
                    current = current.leftChild;
                    //当前节点等于空 说明 没有左子节点
                    // todo  如果节点有数据 就不插入  继续循环 判断节点data大小,然后父节点左右插入数据
                    if (current == null) {
                        //父节点 也就是 没有做左子节点的 current 设置新节点
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    //当前节点
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }

    }

    /**
     * 查找
     *
     * @param value
     * @return
     */
    public Node find(int value) {

        //从根节点开始查找
        Node current = root;

        while (current.data != value) {

            //左边查找
            if (current.data > value) {
                current = current.leftChild;
            } else {
                //右边查找
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }

        }

        return current;

    }


    /**
     * 3中遍历二叉树方法
     *
     * 前序遍历
     * 1 访问根节点
     * 2 前序遍历左子树
     * 3 前序遍历右子树
     *
     * 中序遍历
     * 1 中序遍历左子树
     * 2 访问根节点
     * 3 中序遍历右子树
     *
     *
     * 后序遍历
     * 1 后序遍历左子树
     * 2 后序遍历右子树
     * 3 访问根节点
     *
     *
     */

    public void frontOrder(Node localNode){

        if (localNode!=null){
            //访问根节点
            System.out.println(localNode.data);
            //前序遍历左子树
            frontOrder(localNode.leftChild);
            //遍历右子树
            frontOrder(localNode.rightChild);
        }

    }

    /**
     * 中序遍历 是从小到大的有序数组
     * @param localNode
     */
    public void inOrder(Node localNode){

        if (localNode!=null){
            //中序遍历左子树
            inOrder(localNode.leftChild);

            //访问根节点
            System.out.println(localNode.data);

            //遍历右子树
            inOrder(localNode.rightChild);
        }

    }


    /**
     * 后序遍历
     * @param localNode
     */
    public void afterOrder(Node localNode){

        if (localNode!=null){
            //后序遍历左子树
            afterOrder(localNode.leftChild);
            //后序遍历右子树
            afterOrder(localNode.rightChild);
            //后序访问根节点
            System.out.println(localNode.data);

        }

    }



    /**
     * 更新
     *
     * @param value
     */
    public void update(int value) {

    }


    /**
     * 删除
     *
     * @param value
     */
    public void delete(int value) {

    }


    public static void main(String[] args) {

        Tree tree = new Tree();


        tree.insert(10);
        tree.insert(1);
        tree.insert(0);
        tree.insert(2);
        tree.insert(13);
        tree.insert(11);
        tree.insert(18);

/*
        //10
        System.out.println(tree.root.data);
        //1
        System.out.println(tree.root.rightChild.data);
        //13
        System.out.println(tree.root.rightChild.rightChild.data);
        //18
        System.out.println(tree.root.rightChild.rightChild.rightChild.data);

        //根据值查找
        System.out.println(tree.find(18).data);
        //null
        System.out.println(tree.find(100));


        //前序遍历
        System.out.println("前序遍历");
        tree.frontOrder(tree.root);*/

        System.out.println("中序遍历");
        tree.inOrder(tree.root);

        System.out.println("后序遍历");
        tree.afterOrder(tree.root);



    }
}
