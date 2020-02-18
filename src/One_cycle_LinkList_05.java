public class One_cycle_LinkList_05 {
    public static void main(String[] args) {
        One_Cycle_list one_cycle_list = new One_Cycle_list();
        one_cycle_list.add(5);
       // one_cycle_list.one_list();
        one_cycle_list.delete(2);//循环出圈
    }
}


class One_Cycle_list{
    HeadNode first = null;

    public HeadNode getFirst() {
        return first;
    }

    public void add(int nums){
        if (nums<2)
            System.out.println("编号不符合要求，添加失败");
        HeadNode curtemp = null;
        for (int i=1;i<=nums;i++){
            HeadNode boy = new HeadNode(i,"a"+i);
            if (i==1){
                first = boy;
                first.next = boy;
                curtemp = first;

//                TODO：两种方法均是好的方法
//                first = boy;
//                first.setNext(first);//第一个节点构成循环
//                curtemp = first;
            }else{
                curtemp.next = boy;
                boy.next = first;
                curtemp = boy;
//                curtemp.setNext(boy);//断链指向新节点
//                boy.setNext(first); //构成循环
//                curtemp = boy;//更新指针
            }



        }
    }

    //显示单项链表
    public void one_list(){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        HeadNode curtemp = first;
        while (curtemp.next != first) {
            System.out.println(curtemp.toString());
            curtemp = curtemp.next;
        }

    }


    //小孩出圈问题
    public void delete(int nums){
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        HeadNode curtemp = first;
        HeadNode helper = null;
        while(curtemp.next!=first)
            curtemp = curtemp.next;
        helper = curtemp;
        curtemp = first;
        while (helper != curtemp) {
            for (int i = 1; i <= nums - 1; i++) {
                helper = helper.next;
                curtemp = curtemp.next;
            }
            System.out.println(curtemp.toString());
            curtemp = curtemp.next;
            helper.next = curtemp;//删除curtemp节点
        }
        System.out.println(helper);

    }

}

class HeadNode{
    private Integer id;
    private String name;

    public void setNext(HeadNode next) {
        this.next = next;
    }

    HeadNode next;

    public HeadNode(Integer no, String uname){
        id = no;
        name = uname;
    }

    public String toString() {
        return "HeadNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}