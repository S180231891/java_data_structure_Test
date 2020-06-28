//循环队列
public class list_cycle_02 {
    // front 指向队列的第一个元素 front = 0 初始值
    // rear 指向队列的最后一个元素的后一位 rear= 0 初始值
    // 判断队列满的条件：(rear+1)% maxSize = front
    // 判断队列空的条件：rear==front
    // 队列中有效的数据个数：（rear-front+maxsize）% maxsize
}

class ArrayQuere_cycle {
    private int maxsize;
    private int front;
    private int rear;
    private int[] arr;  //存放数据

    //创建对列
    public ArrayQuere_cycle(int arrmaxsize) {
        maxsize = arrmaxsize;
        arr = new int[maxsize];
        front = 0;  // 指向队列头
        rear = 0;  // 指向队列尾部后一个位置
    }

    //判断队列满
    public boolean isFull() {
        return (rear+1)% maxsize == front;
    }

    //判断队列空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据
    public void addQuere(int n) {
        if (isFull()) {
            throw new RuntimeException("队列满");
        }
        arr[rear] = n;  //指向最后一个数据的后一位
        rear = (rear+1)% maxsize;
    }

    //获取数据
    public int getQuere() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front= (front+1)% maxsize;
        return value;
    }

    // 显示队列
    public void listQuere() {
        if (isEmpty()) {
            System.out.println("数据为空");
            return;
        }
        for (int i = front; front < front+(rear-front+maxsize)% maxsize; i++) {
            System.out.printf("arr[%d] = %d\n", i % maxsize, arr[i % maxsize]);
        }
    }

    // 显示队列头数据
    public int headQuere() {
        if (isFull()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];  // 显示对头，不是取出对头
    }
}
