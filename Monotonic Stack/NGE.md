# Next Greater Element
```java
import java.util.*;
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> mst = new Stack<Integer> ();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++) list.add(-1);
        
        for(int i=n-1;i>=0;i--){
            int num = arr[i];
            while(!mst.isEmpty() && mst.peek() <= num){
                mst.pop();
            }
            if(!mst.isEmpty()){
                list.set(i,mst.peek());
            }
            mst.push(num);
        }
        return list;
    }
}
```