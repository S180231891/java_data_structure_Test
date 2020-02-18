import java.util.Scanner;

public class list_02 {
    public static void main(String[] args) {
        ArrayQuere quere= new ArrayQuere(3);
        char key = ' ';  // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
           System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列获取数据");
            System.out.println("h(head):查看队列头数据");
            key = scanner.next().charAt(0); //接收一个字符
            switch (key){
                case 's':
                    quere.listQuere();
                    break;
                case 'a':
                    System.out.println("输入一个数据");
                    int value = scanner.nextInt();
                    quere.addQuere(value);
                    break;
                case 'g':
                    try{
                        int res = quere.getQuere();
                        System.out.printf("取出的数据为%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = quere.headQuere();
                        System.out.printf("查看的头数据为%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("退出程序");
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayQuere{
    private int maxsize;
    private int front;
    private int rear;
    private int[] arr;  //存放数据

    //创建对列
    public ArrayQuere(int arrmaxsize){
        maxsize = arrmaxsize;
        arr = new int[maxsize];
        front = -1;  // 指向队列头的前一个位置
        rear = -1;  // 指向队列尾部
    }

    //判断队列满
    public boolean isFull(){
        return rear == maxsize-1;
    }

    //判断队列空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加数据
    public void addQuere(int n){
        if(isFull()){
             throw new RuntimeException("队列满");
        }
        rear++;
        arr[rear] = n;
    }

    //获取数据
    public int getQuere(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    // 显示队列
    public void listQuere(){
       if (isEmpty()){
           System.out.println("数据为空");
           return;
       }
       for(int i=0;i<arr.length;i++){
           System.out.printf("arr[%d] = %d\n",i, arr[i]);
       }
    }

    // 显示队列头数据
    public int headQuere(){
        if (isFull()){
            throw new RuntimeException("队列为空");
        }
        return arr[++front];
    }
}

