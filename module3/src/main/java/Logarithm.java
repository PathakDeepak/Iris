/**
 * @author valar_morghulis onumber 25/01/23.
 * @project multi-module-gradle
 * @description
 */
public class Logarithm {

    static double log(double number, double base) {
        double result = 0;
        while(number>1)
        {
            number = Arithmetic.div(number , base);
            result++;
        }
        result = Arithmetic.add(result, number);
        return Arithmetic.sub(result, 1);
    }
}
