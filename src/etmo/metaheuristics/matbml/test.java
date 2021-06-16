package etmo.metaheuristics.matbml;

import etmo.core.Solution;
import etmo.util.JMException;
import etmo.util.PseudoRandom;
import etmo.util.logging.LogIGD;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class test {
    public static void main(String[] args) throws IOException, JMException {
//        int[] a = Utils.permutation(5, 5);
//        System.out.println(Arrays.toString(a));
//        for (int i = 0; i < 20; i++){
//            System.out.println(PseudoRandom.randDouble());
//        }

//        Solution s = new Solution();
//        LogIGD.LogIGD("TEST.txt", new double[]{1,2,3,4,5});

//        double[][][] data = new double[9][1][2];
//        data[0][0] = new double[]{1, 0.5};
//        data[1][0] = new double[]{1.5, 1.5};
//        data[2][0] = new double[]{2, 1};
//        data[3][0] = new double[]{3, 4};
//        data[4][0] = new double[]{3.5, 3};
//        data[5][0] = new double[]{4.5, 3.5};
//        data[6][0] = new double[]{5, 1.5};
//        data[7][0] = new double[]{6, 2};
//        data[8][0] = new double[]{6.5, 2.5};
//        List<List<Integer>> res = Utils.AGNES(data, 3);

//        int[] a = {1,2,3,4,5};
////        if (IntStream.of(a).anyMatch(x -> x == 4))
////            System.out.println("contain!");
////
////        System.out.println("end");

        double[][] data1 = {
                {2, 5, 2, 3, 6},
                {4, 2, 1, 2, 4},
                {1, 2, 2, 3, 5},
                {5, 4, 3, 3, 2},
                {2, 1, 5, 1, 1},
        };
        double[][] data2 = {
                {1, 2, 3, 4, 5},
                {4, 2, 1, 3, 5},
                {1, 1, 3, 3, 1},
                {2, 5, 2, 3, 6},
                {5, 4, 5, 5, 5},
        };
        double distance1 = WassersteinDistance.getWD(data1, data2);
        double distance2 = WassersteinDistance.getWD2(data1, data2);
        System.out.println("distance1: " + distance1 + "\ndistance2: " + distance2);
    }
}