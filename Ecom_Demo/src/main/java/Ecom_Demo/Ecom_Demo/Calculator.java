package Ecom_Demo.Ecom_Demo;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res1=add(20,30);
		int mul_r=mul(5,4);
		System.out.println(res1);
		System.out.println(mul_r);

	}
	public static int add(int num1,int num2) {
		//int  = 0;
		int sum=num1+num2;
		return sum;
		
	}
	public static int mul(int num1,int num2) {
		//int  = 0;
		int res=num1*num2;
		return res;
		
	}
	

}
