
class UsingArray{
    private int data[]; 
    private int top; 
    public UsingArray(int size) {
        this.data = new int[size];
        this.top = -1;
    }
    public void push(int num){
        if(isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        data[++top] = num; 
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        return data[top--]; 

    }
    private boolean isFull(){
        if (top+1 == this.data.length){
            return true;
        }
        return false;
    }
    private boolean isEmpty(){
            if (top == -1){
                return true;
            }
            return false;
    }
    public void clear(){
        top = 0;
        System.out.println("stack cleared");
    }
    public void printData(){
        for(int i = 0;i<=top;i++){
           System.out.print(this.data[i]) ;
        
           if(i != top){
            System.out.print(",");
           }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        UsingArray stack = new UsingArray(5);
        stack.push(234);
        stack.push(53);
        stack.push(523);
        stack.push(234);
        stack.push(53);
        stack.push(523);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.printData();

        stack.pop();        
        stack.pop();
        stack.printData();
    }
}