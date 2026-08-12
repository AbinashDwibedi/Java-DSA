# Previous Smaller Element
```java
import java.util.*;
class Solution {
    public ArrayList<Integer> prevSmaller(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i =0;i<n;i++){
            int num = arr[i];
            while(!st.isEmpty() && st.peek()>= num){
                st.pop();
            }
            if(!st.isEmpty()){
                list.add(st.peek());
            }
            else{
                list.add(-1);
            }
            st.push(num);
        }
        return list;
    }
}
```