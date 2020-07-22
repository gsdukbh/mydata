package top.werls.data.algortihm.chapter.one;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Lee JiaWei
 * @version V1.0
 * @Project: data
 * @Date : 2020/7/22 11:20
 */

@SpringBootTest

class MatrixTest {

    @Test
    void dot() {
        double[] x={1,3,-5} ,y={4,-2,-1};
        System.out.println(Matrix.dot(x,y));
    }

    @Test
    void mult() {
        double[][] a={
                {1,0,2},
                {-1,3,1}
        },b={
                {3,1},
                {2,1},
                {1,0}
        } ;
        for (double[] in :
                Matrix.mult(a, b)) {
            System.out.println(Arrays.toString(in));
        }
    }

    @Test
    void transpose() {
        double[][] a={
                {1,0,2},
                {-1,3,1}
        };
        for (double[] in :
                Matrix.transpose(a)) {
            System.out.println(Arrays.toString(in));
        }
    }

    @Test
    void testMult() {
        double[][] a={
                {1,2},
                {3,4}
        };
        double[] x={1,2};
        System.out.println(Arrays.toString(Matrix.mult(a,x)));
    }

    @Test
    void testMult1() {
    }
}