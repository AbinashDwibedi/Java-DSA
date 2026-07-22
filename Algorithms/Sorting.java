
import java.util.ArrayList;
import java.util.List;


class Sorting<T>{
    public static <T extends Comparable <T>> ArrayList<T> mergeSort(ArrayList<T> arr){
        if(arr.size() <= 1){
            return arr;
        }
        int n = arr.size();
        int mid = n/2;
        ArrayList<T> leftArr = mergeSort(new ArrayList<> (arr.subList(0, mid)));
        ArrayList<T> rightArr = mergeSort(new ArrayList<> (arr.subList(mid, n)));

        return merge(leftArr, rightArr);
    }
    private static <T extends Comparable <T>> ArrayList<T> merge(ArrayList<T> leftArr, ArrayList<T> rightArr){
        ArrayList<T> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < leftArr.size() && j < rightArr.size()){
            if(leftArr.get(i).compareTo(rightArr.get(j)) > 0){
                result.add(rightArr.get(j++));
            }
            else{
                result.add(leftArr.get(i++));
            }
        }
        while(i<leftArr.size()){
            result.add(leftArr.get(i++));
        }
        while(j<rightArr.size()){
            result.add(rightArr.get(j++));
        }
        return result;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(3,45234,53,645));
        System.out.println(list);
        ArrayList<Integer> res = mergeSort(list);
        System.out.println(res);
    }
}