//数据栈：后进先出
public class Stack_06 {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(8);
        stack.push(0);
        stack.list();
        System.out.printf("取出数据:%d",stack.pop());


    }
}

//创造栈
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判断栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    //判空
    public boolean Empty(){
        return top == -1;
    }

    //插入
    public void push(int nums) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = nums;
    }
    //取出
    public int pop(){
        if (Empty()){
            throw  new RuntimeException("数组为空，异常操作");
        }
        return stack[top--];
    }
    //显示栈数据
    public void list(){
        if (Empty()){
            System.out.println("数组为空！");
        }
        for (int s=top;s>-1;s--){
            System.out.printf("stack[%d]=%d\n" ,s,stack[s]);
        }
    }
}

