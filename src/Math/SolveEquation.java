package Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [640] Solve the Equation
 *
 * @author huangrui
 * @date 2022/8/10
 */
public class SolveEquation {

    public String solveEquationRegexp(String equation) {
        String pattern = "([+,-]?[\\d+]?[x]?)";
        Pattern r = Pattern.compile(pattern);
        String[] equationExpression = equation.split("=");
        int leftConstant = 0;
        int leftCoefficient = 0;
        int rightConstant = 0;
        int rightCoefficient = 0;
        for (int i = 0; i <= 1; i++) {
            int tempConstant = 0;
            int tempCoefficient = 0;
            Matcher matcher = r.matcher(equationExpression[i]);
            while (matcher.find()) {
                String e = matcher.group();
                if (e.isEmpty()) {
                    break;
                }
                if (e.endsWith("x")) {
                    tempCoefficient += e.equals("x") || e.equals("+x") ? 1 : Integer.parseInt(e.substring(0, e.length() - 1));
                } else {
                    tempConstant += Integer.parseInt(e);
                }
            }
            if (i == 0) {
                leftConstant = tempConstant;
                leftCoefficient = tempCoefficient;
            } else {
                rightConstant = tempConstant;
                rightCoefficient = tempCoefficient;
            }
        }
        int constant = rightConstant - leftConstant;
        int coefficient = leftCoefficient - rightCoefficient;
        if (coefficient == 0 && constant == 0) {
            return "Infinite solutions";
        }
        if (coefficient == 0) {
            return "No solution";
        }
        return "x=" + constant / coefficient;
    }

    public String solveEquation(String equation) {
        int leftConstant = 0;
        int leftCoefficient = 0;
        int constant = 0;
        int coefficient = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (c == '+' || c == '-' || c == '=' || i == equation.length() - 1) {
                if (i == equation.length() - 1) {
                    res.append(c);
                }
                String resStr = res.toString();
                if (!resStr.isEmpty()) {
                    if (resStr.endsWith("x")) {
                        coefficient += resStr.equals("x") || resStr.equals("+x") || resStr.equals("-x") ?
                                Integer.parseInt(resStr.substring(0, resStr.length() - 1) + "1") :
                                Integer.parseInt(resStr.substring(0, resStr.length() - 1));
                    } else {
                        constant += Integer.parseInt(resStr);
                    }
                }
                res = new StringBuilder();
                if (c == '=') {
                    leftConstant = constant;
                    leftCoefficient = coefficient;
                    constant = 0;
                    coefficient = 0;
                    continue;
                }
            }
            res.append(c);
        }
        constant = constant - leftConstant;
        coefficient = leftCoefficient - coefficient;
        if (coefficient == 0 && constant == 0) {
            return "Infinite solutions";
        }
        if (coefficient == 0) {
            return "No solution";
        }
        return "x=" + constant / coefficient;
    }

    public static void main(String[] args) {
        SolveEquation solveEquation = new SolveEquation();
        System.out.println(solveEquation.solveEquation("2x+3x-6x=x+2"));
    }
}
