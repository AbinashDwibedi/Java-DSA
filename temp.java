class temp {
    public static void main(String[] args) {
       int[] nums = new int[10];
       for (int i = 0; i < 10; i++) {
           nums[i] = i*2;
       }
       for (int i = 0; i < 10; i++) {
           System.out.println(nums[i]);
       }
       for(char ch = '1'; ch <= '9'; ch++){
        System.out.print(ch + ", ");
       }
    }
}