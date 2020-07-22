package top.werls.data.algortihm.chapter.one;

import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 矩阵api
 * @author : Lee JiaWei
 * @version V1.0
 * @Project: data
 * @Date : 2020/7/22 9:24
 */

public class Matrix {




    /**
     * 向量点乘
     * @param x double[]
     * @param y double[]
     * @return double
     */
    public  static  double dot(double[]x ,double[] y){
        if (x.length!=y.length){
            throw  new Error("Inconsistent vector dot product");
        }
        double res=0;
        for (int i = 0; i < x.length; i++) {
            res += x[i] * y[i];
        }
        return res;
    }

    /**
     *
     * 矩阵与矩阵之积
     * @param a double[][]
     * @param b double[][]
     * @return double[][]
     */
    public  static double[][] mult(double[][]a ,double[][]b){
        if (a[0].length!=b.length){
            throw  new Error("Does not meet the requirements of matrix multiplication");
        }
         double[][] res=new double[a.length][b[0].length];
        for (int i=0;i<res.length ;i++){
            for (int j=0;j<res[0].length;j++){
                double temp=0;
                for (int x=0;x<b.length;x++){
                    temp +=a[i][x] * b[x][j];
                }
                res[i][j]=temp;
            }
        }
        return res;
    }

    /**
     * 转置矩阵
     * @param a double[][]
     * @return double[][]
     */
    public static  double[][] transpose(double[][]a){
        int x=a.length,y=a[0].length;

        double[][] res=new double[y][x];
        for (int i=0;i<y;i++){
            for (int j=0;j<x;j++){
                res[i][j]=a[j][i];
            }
        }
        return res;
    }

    /**
     * 矩阵与向量之积
     * @param a double[]
     * @param x double[][]
     * @return double[]
     */
    public static double[] mult(double[][]a ,double[] x){
        if (a[0].length!=x.length){
            throw  new Error("Does not meet the requirements of matrix multiplication");
        }
        double[] res=new double[x.length];
        double[][] temp=new double[x.length][x.length];
        for (int j=0;j<x.length;j++){
            res[j]=0;
            for (int i=0;i<x.length;i++){
                temp[j][i]=0;
                for (int k=0;k<a.length;k++){
                    temp[k][i] =x[i] * a[k][i];
                }
                res[j] += temp[j][i];
            }
        }

        return res;
    }

    /**
     * 向量于矩阵之积
     * @param y double[]
     * @param a double[][]
     * @return double[]
     */
    public static  double[] mult( double[]y ,double[][] a){


        return new double[]{0};
    }
}
