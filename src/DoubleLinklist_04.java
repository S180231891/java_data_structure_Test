//双向链表
public class DoubleLinklist_04 {
    public static void main(String [] args){
        System.out.println("双向链表代码实现");
    }

}

//创建类
class D_linklist{
    D_HerNode d_herNode = new D_HerNode(0,"","");//创建链表头节点
    public D_HerNode getD_herNode(){
        return d_herNode;
    }

    //显示链表中的数据
    public void list(){
        if (d_herNode.next == null){
            System.out.println("链表为空");
            return;
        }
        D_HerNode temp = d_herNode.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }

    }

    //按顺序添加节点
    public void addOrder(D_HerNode node)
    {
        D_HerNode temp = d_herNode;
        boolean flag = false;
        while (true)
        {
            if (temp.next==null){
                break;
            }
            if (temp.next.no > node.no){
                //在temp后面进行添加    temp.next.pre = node    node.pre = temp
                break;
            }else if (temp.next.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if (flag){
            System.out.printf("编号%d已经存在,不能重复添加\n", node.no);

        }else {
            //交换位置，按顺序排列
            temp.next.pre = node;
            node.next = temp.next;
            temp.next = node;
            node.pre = temp;
        }
    }

    //找到待删除的节点，进行删除操作
    public void Delete(D_HerNode node){
        D_HerNode temp = d_herNode.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                System.out.println("链表为空！！");
                break;
            }
            if (temp.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if(temp.next!=null){
                temp.next.pre = temp.pre;
            }
        }
    }


}
//创建节点
class D_HerNode{
    public int no;
    public String name;
    public String nickname;
    public D_HerNode next;
    public D_HerNode pre;

    public D_HerNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public String toString() {
        return "HerNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}