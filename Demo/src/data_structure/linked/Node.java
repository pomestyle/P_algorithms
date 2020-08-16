package data_structure.linked;

import com.sun.jmx.snmp.SnmpOidDatabase;

/**
 * 链表连接点
 * @author wangl
 */
public class Node {

    /**
     * 指针域
     */
    public Node next;

    /**
     * 前一个指针域
     */
    public Node previous;


    /**
     * 数据域
     */
    public int data;

    public Node(int value) {
        this.data = value;
    }


    /**
     * 显示方法
     */

    public void display(){
        System.out.println(data + " ");
    }
}
