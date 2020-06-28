/**
 * 链表java代码实现步骤
 * 1 创建node节点，包含编号，名称。。。。。，等(data, next)
 * 2 创建LinkList类，编写方法---包含头节点
 *      方法包括：链表的CRUD
 * 3 通过实例进行练习
 *
 *
 *
 */

public class Linklist_03 {
    public static void main(String[] args) {
        //创建节点
        HerNode hero1 = new HerNode(1, "宋江","及时雨");
        HerNode hero2 = new HerNode(2, "卢俊义","玉麒麟");
        HerNode hero3 = new HerNode(3, "吴用","智多星");
        HerNode hero4 = new HerNode(4, "林冲","豹子头");
        HerNode hero5 = new HerNode(2, "花容","小李广");

        //创建链表
        LinkList linkList = new LinkList();
//        linkList.add(hero1);
//        linkList.add(hero4);
//        linkList.add(hero2);
//        linkList.add(hero3);
        linkList.addOrder(hero1);
        linkList.addOrder(hero4);
        linkList.addOrder(hero2);
        linkList.addOrder(hero3);
//        linkList.addOrder(hero3);
        linkList.list();
        linkList.update(hero5);
        linkList.delete(5);
        linkList.list();
        int count = linkList.sumlist(linkList.getHead());
        System.out.println(count);
        // 查找链表中倒数第k个节点
        System.out.println(linkList.getLinkNode(linkList.getHead(),3));
        System.out.println("   ===========    ===============");
        //链表反转
        linkList.reverse(linkList.getHead());
        linkList.list();
    }
}


class LinkList{
    public HerNode getHead() {
        return head;
    }

    private HerNode head = new HerNode(0,"","");  // 构造头节点



    //添加节点到单链表
    public void add(HerNode herNode){
        //找到最后一个节点，将next指向新的节点
        HerNode temp = head;
        //遍历链表
        while(true){
            if (temp.next == null){
               break;
            }
            temp = temp.next;
        }
        temp.next = herNode;

    }

    //按顺序添加链表
    public void addOrder(HerNode node){
        HerNode temp = head;
        boolean flag = false;
        while (true)
        {
            if (temp.next==null){
                break;
            }
            if (temp.next.no > node.no){
                //在temp后面进行添加
                break;
            }else if (temp.next.no == node.no){
                //不进行添加重复的数据
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if (flag){
            System.out.printf("编号%d已经存在,不能重复添加\n", node.no);

        }else {
            //交换位置，按顺序排列
            node.next = temp.next;
            temp.next = node;
        }
    }

    //显示列表
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HerNode temp = head.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    //链表修改
    public void update(HerNode node){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        HerNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.no == node.no){
                flag=true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.nickname = node.nickname;
            temp.name = node.name;
        }else
            System.out.printf("不存在该需要修改的节点编号%d\n", node.no);
    }

    //链表删除
    public void delete(int node){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HerNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }else{
                if (temp.next.no == node){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
        }
        if (flag){
            temp.next = temp.next.next;
        }else
            System.out.printf("不存在要删除的节点编号%d", node);
    }

    // 求单链表中节点的个数
    public int sumlist(HerNode head){
        if (head.next == null){
            System.out.println("链表为空！");
            return 0;
        }
        HerNode temp = head;
        int sum=0;
        while (temp.next != null) {
            temp = temp.next;
            sum++;
        }
        return sum ;

    }

    //查找单链表中倒数第k个节点
    public HerNode getLinkNode(HerNode head,int k){
        if (head.next == null){
            System.out.println("链表为空");
            return null;
        }
        int a = sumlist(head);
        if (k<0 || k>a){
//            throw new RuntimeException("不存在该节点");
            return null;
        }else
            a = a-k+1;
        HerNode temp = head;
        int i =0;
        while (i<a){
            temp = temp.next;
            i++;
        }
        return temp;

    }

    //单链表反转插入
    public void reverse(HerNode head){
        if (head.next == null){
            System.out.println("数据表为空");
            return;
        }
        HerNode no = null;//辅助指针
        HerNode temp = head.next;//指向第一个节点
        HerNode resove = new HerNode(0,"","");
        while (temp!=null){
            no = temp.next;//指向temp的下一个节点
            temp.next = resove.next;
            resove.next = temp;
            temp = no;
        }
        head.next = resove.next;
    }
}




//创建结点
class HerNode{
    public int no;
    public String name;
    public String nickname;
    public HerNode next;

    //构造函数
    public HerNode(int no, String name, String nickname){
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