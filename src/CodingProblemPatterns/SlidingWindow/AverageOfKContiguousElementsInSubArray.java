package CodingProblemPatterns.SlidingWindow;

public class AverageOfKContiguousElementsInSubArray {
    public static void main(String[] args){
        int[] inputArray = new int[]{2,3,6,4,5,1,5,2,6,27,16,3,2};
        int subsetSize = 4;
        double[] avgOfSubset = avgOfKContiguousElementsInSubArray(inputArray, subsetSize);
        for (double i : avgOfSubset){
            System.out.println(i);
        }
    }

    private static double[] avgOfKContiguousElementsInSubArray(int[] input, int subsetSize){
        double[] result = new double[input.length - subsetSize + 1];
        int windowStart=0, windowEnd=0;
        double windowSum = 0;

        for(windowEnd = 0; windowEnd < input.length; windowEnd++){
            windowSum += input[windowEnd];

            if (windowEnd >= subsetSize -1 ){ // to ensure we consider all elements in sub-array of size subsetSize
                result[windowStart] = windowSum/subsetSize;
                windowSum -= input[windowStart];
                windowStart++;
            }
        }
        return result;
    }
}
