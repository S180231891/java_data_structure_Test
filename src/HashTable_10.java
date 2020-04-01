import java.util.Scanner;

public class HashTable_10 {
    public static void main(String[] args) {
        //创建Hash表
        HashTable hashTable = new HashTable(7);
        String key ="";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出雇员");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id：");
                    int id = scanner.nextInt();
                    System.out.println("输入name：");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp1 = new Emp(id, name);
                    hashTable.add(emp1);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("输入查找的id：");
                    id= scanner.nextInt();
                    hashTable.HashList(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }


    }
}
//创建哈希表HashTable，管理多条链表  3
class HashTable{
    private EmpLink[] empLinks;
    private int size;

    public HashTable(int size) {
        //TODO:能否直接使用？:不能直接使用创建的链表，必须要对每一条链表进行初始化
        this.size = size;
        empLinks = new EmpLink[size];//为每个哈希表初始化链表头
        //要分别初始化每一条链表
        for (int i=0;i<size;i++){
            empLinks[i] = new EmpLink();
        }
    }

    public void add(Emp emp){
        //根据id添加链表
        int selectIdLink = hashCode(emp.id);//使用hash散列方法添加链表
        empLinks[selectIdLink].add(emp);
    }
    //遍历所有链表
    public void list(){
        for (int i=0;i<size;i++){
            empLinks[i].list(i);
        }
    }

    //查找链表
    public void HashList(int id){
        int selectIdLink = hashCode(id);
        Emp emp = empLinks[selectIdLink].EmpList(id);
        if (emp !=null){
            System.out.printf("在第%d条链表中找到id=%d\t",(selectIdLink),id);
            System.out.println(emp.toString());
        }else
            System.out.println("不存在该值");
    }

    //编写哈希散列函数（散列函数种类较多）
    public int hashCode(int id){
        return id % size;
    }
}

//创建雇员  1
class Emp{
    public Integer id;
    public String name;
    public Emp next;//TODO:next的指针默认为空

    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Emp(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建EmpLink链表  2
class EmpLink{
    //创建头指针
    private Emp head = null;
    //添加员工
    //1、假设id为自增长，直接将雇员加入到本链表的最后位置即可
    public void add(Emp emp){
        if (head==null){
            head = emp;
            return;
        }
        //创建辅助指针
        Emp temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // 单链表
        temp.next = emp;
    }

    public void list(int no){
        // no是链表的条数，list显示链表中的数据
        if (head == null){
            System.out.printf("第%d链表为空\n",no);
            return;
        }
        Emp temp = head;
        while (true){
            System.out.printf("==>id=%d,name=%s\t", temp.id, temp.name);
            if (temp.next==null){
                break;
            }
            temp = temp.next;
        }
        System.out.println();

    }
    //根据id查找雇员
    public Emp EmpList(int id){
        if (head==null){
            throw new RuntimeException("数组为空");
        }
        Emp temp = head;
        while (true){
            if (temp.id == id){
                break;
            }
            if (temp.next == null){
                temp =null;
                break;
            }
            temp = temp.next;

        }
        return temp;
    }
}

