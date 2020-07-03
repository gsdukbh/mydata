package top.werls.data.algorithm.C1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    // 欧几里得
    @RequestMapping("/gcd/{p}/{q}")
    public String gcdsString(@PathVariable(name = "p") Integer p, @PathVariable(name = "q") Integer q) {
        return gcd(p, q).toString();
    }

    public Integer gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = q % p;
        return gcd(q, r);
    }

    // 素数
    @RequestMapping("/prime/{x}")
    public Boolean isPrimeBoolean(@PathVariable(name = "x") Integer x) {
        if (x < 2) {
            return false;
        }
        for (Integer i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
            return true;
        }
        return true;
    }

    // 平方根
    @RequestMapping("/sqrt/{x}")
    public String sqrt(@PathVariable(name = "x") double x) {
        if (x < 0) {
            return String.valueOf(Double.NaN);
        }
        double err = 1e-15;
        double t = x;
        while (Math.abs(t - x / t) > err * t) {
            t = (x / t + t) / 2.0;
        }
        return String.valueOf(t);
    }

    @RequestMapping("/pi")
    public String pi() {
        return String.valueOf(Math.PI);
    }

    public double max(double[] a) {
        double Max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > Max) {
                Max = a[i];
            }
        }
        return Max;
    }
}