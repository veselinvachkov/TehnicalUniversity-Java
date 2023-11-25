package TU_Java.SAA;

public class Exercise_2 {
    public static int calculateSum(int[] arr, int index) {
        if(index == arr.length -1) {
            return arr[index];
        }
        return arr[index] + calculateSum(arr, index + 1);

    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int sum=calculateSum(array, 0);
        System.out.println(+sum);
    }
}