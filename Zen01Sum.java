public class Zen01Sum{

    public static void main(String[] args){

        int[] arr = {1, 3, 5};
        System.out.println(sumloop(arr));
        System.out.println(sumRecurBegin(arr, 0));
        System.out.println(sumRecurEnd(arr, arr.length-1));

    }

    public static int sumloop(int[] arr){
        int sum = 0;

        for (int i : arr){
            sum +=i;
        }
        return sum;
    }

    public static int sumRecurBegin(int[] arr, int cur) {
        if (cur == arr.length) return 0;

        return arr[cur] + sumRecurBegin(arr, cur+1);
      
    }

    public static int sumRecurEnd(int[] arr, int end){
        if (end < 0) return 0;

        return arr[end] + sumRecurEnd(arr, end-1);

    }


}