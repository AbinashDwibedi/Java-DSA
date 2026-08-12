# Daily Temperature
```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<ArrayList<Integer>> st = new Stack<>();
        int n = temperatures.length;
        int[] res= new int[n];

        for(int i =n-1;i>=0;i--){
            int num = temperatures[i];
            while(!st.isEmpty() && st.peek().get(0) <= num){
                st.pop();
            }
            if(!st.isEmpty()){
                res[i] = st.peek().get(1) - i;
            }
            st.push(new ArrayList<>(List.of(num, i)));
        }
        return res;
    }
}
```