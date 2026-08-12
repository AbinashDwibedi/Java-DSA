# Next Smaller Element
```java
import java.util.*;
class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i =0;i<n;i++) list.add(-1);
        for(int i=n-1;i>=0;i--){
            int num = arr[i];
            while(!st.isEmpty() && st.peek() >= num){
                st.pop();
            }
            
            if(!st.isEmpty()){
                list.set(i,st.peek());
            }
            
            st.push(num);
        }
        return list;
    }
}
```