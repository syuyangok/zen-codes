public class Zen01Sum{

    public static void main(String[] args){

        int[] arr = {1, 3, 5};
        System.out.println(sumloop(arr));
        System.out.println(sumRecurBegin(arr, 0));
        System.out.println(sumRecurEnd(arr, arr.length-1));
        System.out.println(sumWithBinary(arr, 0, arr.length-1));


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

    public static int sumWithBinary(int[] arr, int left, int right){

//        Exception in thread "main" java.lang.StackOverflowError, when left == right, it never stopped.
        //        if(left > right) return 0;

        if(left == right) return arr[left];

        int mid = left + (right - left) / 2;

        return sumWithBinary(arr, left, mid) + sumWithBinary(arr, mid+1, right);
    }


}
