# Triangle 

```java
class Solution {
    List<Integer> dp = new ArrayList<>();
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(0).size();
        for(int j=0;j<m+1;j++) dp.add(0);
        for(int i = m-1;i>= 0;i--){
            List<Integer> temp = new ArrayList<>();
            for(int k=0;k<=i;k++) temp.add(0);
            for(int j= i;j>=0;j--){
                int val = triangle.get(i).get(j) + Math.min(dp.get(j),dp.get(j+1));
                temp.set(j,val);
            }
            dp = temp;
        }
        return dp.get(0);
    }
    // private int helper(List<List<Integer>> tri, int i, int j){
    //     if(i >= tri.size()) return 0;
    //     if(!dp.get(i).get(j).equals(-1)) return dp.get(i).get(j);
    //     int fCase = helper(tri, i+1, j);
    //     int sCase = helper(tri, i+1, j+1);
    //     var list = dp.get(i);
    //     int val = tri.get(i).get(j) + Math.min(fCase, sCase);
    //     list.set(j,val);
    //     dp.set(i,list);
    //     return val;
    // }
}
```
