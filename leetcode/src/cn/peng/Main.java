package cn.peng;

import java.util.Scanner;

public class Main {

    private static final double 社保比例 = 0.225;
    private static final double 公积金比例 = 0.24;
    private static final double 发薪数 = 16;
    private static final double[][] 税率表 = new double[7][3];
    static {
        税率表[0][0] = 36000;税率表[0][1] = 0.03;税率表[0][2] = 0;
        税率表[1][0] = 144000;税率表[1][1] = 0.1;税率表[1][2] = 2520;
        税率表[2][0] = 300000;税率表[2][1] = 0.2;税率表[2][2] = 16920;
        税率表[3][0] = 420000;税率表[3][1] = 0.25;税率表[3][2] = 31920;
        税率表[4][0] = 660000;税率表[4][1] = 0.3;税率表[4][2] = 52920;
        税率表[5][0] = 960000;税率表[5][1] = 0.35;税率表[5][2] = 85920;
        税率表[6][0] = -1;税率表[6][1] = 0.45;税率表[6][2] = 181920;
    }

    // 税后年薪带公积金和补贴
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("月薪：");
        double monthMoney = sc.nextDouble();
        System.out.println("发薪数：");
        double 发薪数 = sc.nextDouble();
        System.out.println("补贴：");
        double 补贴 = sc.nextDouble();
        double add = monthMoney * (公积金比例 - 社保比例) * 12;
        double yearMoney = monthMoney * 发薪数;
        if (yearMoney < 税率表[0][0]) {
            yearMoney -= yearMoney * 税率表[0][1];
        } else if (yearMoney < 税率表[1][0]) {
            yearMoney -= (yearMoney - 税率表[0][0]) * 税率表[1][1] - 税率表[0][2];
        } else if (yearMoney < 税率表[2][0]) {
            yearMoney -= (yearMoney - 税率表[1][0]) * 税率表[2][1] - 税率表[1][2];
        } else if (yearMoney < 税率表[3][0]) {
            yearMoney -= (yearMoney - 税率表[2][0]) * 税率表[3][1] - 税率表[2][2];
        } else if (yearMoney < 税率表[4][0]) {
            yearMoney -= (yearMoney - 税率表[3][0]) * 税率表[4][1] - 税率表[3][2];
        } else if (yearMoney < 税率表[5][0]) {
            yearMoney -= (yearMoney - 税率表[4][0]) * 税率表[5][1] - 税率表[4][2];
        } else {
            yearMoney -= (yearMoney - 税率表[5][0]) * 税率表[6][1] - 税率表[5][2];
        }
        yearMoney += add + 补贴;
        System.out.println(yearMoney);
        sc.close();
    }
}
