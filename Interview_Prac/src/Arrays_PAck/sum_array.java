package Arrays_PAck;

public class sum_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[]= {3,5,6,9,16};
		int result=sum(a1);
		System.out.println("The sum is:"+result);
		

	}
	public static int sum(int[] a) {
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
			
		}
		return sum;
		
	}

}
