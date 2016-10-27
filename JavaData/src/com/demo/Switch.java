package com.demo;

/**
 * Created by xhp on 2016/10/23.
 *
 * switch语句中只允许使用：byte、short、int、char、enum类型
 * 不允许使用:String,long,float,double
 *
 */
public class Switch {
    public static void main(String[] args) {
        char score = 'C';
        switch (score){
            case 'A':
                System.out.println("优秀.");
                break;
            case 'B':
                System.out.println("良好.");
                break;
            case 'C':
                System.out.println("及格.");
                break;
            default:
                System.out.println("输入错误");
        }
    }
    private void test(){
        for(int i = 1;i <= 100;i++){
         for (int j = 1;j <=100;j++){
             if(j%i==0){

             }
         }
        }
    }
}
