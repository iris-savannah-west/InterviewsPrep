package CodingProblemPatterns.SlidingWindow;

public class SumOfKContiguousElementsInSubArray {
    public static void main(String[] args){
        int[] input = new int[]{1,2,3,4,5,6,7,8};
        int subsetSize = 4;
        int[] sumOfSubarray = sumOfKContiguousElements(input, subsetSize);

        for (int i : sumOfSubarray){
            System.out.println(i);
        }
    }

    private static int[] sumOfKContiguousElements(int[] input, int subsetSize){
        int[] result = new int[input.length - subsetSize + 1];
        int windowStart=0, windowEnd=0, windowSum=0;

        for(windowEnd = 0; windowEnd < input.length ; windowEnd++){
            windowSum += input[windowEnd];
            if (windowEnd >= subsetSize - 1){
                result[windowStart] = windowSum;
                windowSum -= input[windowStart];
                windowStart++;
            }
        }
        return result;
    }
}
