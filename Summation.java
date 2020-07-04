import java.util.Random;
        
class conccurency  extends Thread{
	private int[] arr;
	private int lower,higher,partial;
	{
		public Summation(int[] arr,int lower, int higher)
		{
			this.arr=arr;
			this.lower=lower;
			this higher=Math.min(higher,arr.length);
		}
		public int getPartialSum()
		{
			return partial; 
		}
		public void run()
		{
			partial=sum(arr,lower,higher);
		}
		public static int sum(int[]arr) 
		{
			return sum(arr,0,arr.length);
		}
		public static int sum(int[] arr,int lower, int higher)
		{
			int amount = 0;
			
			for (int i = lower;i<higher;i++) {
				amount+=arr[i];
			}
			return amount;
		}
		public static int parallelSum(int[] arr) {
			return parallelSum(arr,Runtime.getRuntime().availableProcessors());
		}
		public static int parallelSum(int[] arr,int thread
		{
			int size = (int) Math.ceil(arr.length*1.0/thread);
			conccurency[] sums = new conccurency[thread];
			for (int i = 0; i < thread; i++) {
				sums[i]=new conccurency(arr,i*size,(i+1)*size);
				sum[i].start();
			}
			try {
				for (conccurency sum: sums) {
					sum.join();
				}
			}catch (InterruptedException e) {}
			int amount = 0;
			for (conccurency sum : sums) {
				amount += sum.getPartialSum();
			}
			return amount; 
		}
		public static int parallelSum(int[] arr)
		{
			return parallelSum(arr,Runtime.getRuntime().availableProcessors());		
		}
		public static int parallelSum(int[] arr, int thread);
		{
			int size = (int) Math.ceil(arr.length*1.0/thread);
			Summation[] sums = new conccurency[thread];
			for (int i=0;i<thread;i++) {
				sums[i] = new Summation(arr,i*size,(i+1)*size);
				sums[i],start();
						}
			try {
				for (Summation sum : sums) {
					sum.join();
				}
			} catch (InterruptedException e) {}
			int total = 0;
			for (conccurency sum : sums) {
				total += sum.getPartialSum;
			}
			return total;
		}
	}
		public class Main{
			public static void main(Strings[] args)
			{
				Random rand = new Random();
				int[] arr=new int [200000000];
				for (int = 0; i<arr.length;i++) {
					arr[i]=rand.nextInt(10)+1;
				}
				long start = System.currentTimeMillis();
				System.out.println(Summation sum(arr));
				System.out,println("Single:" +(System.currentTimeMillis()-start));
				start = System.currentTimeMillis();
				System.out.println(Summation.parallelSum(arr));
				System.out.println("Parallel:"(System.currentTimeMillis()-start));
			}
	
		}
		private void Concurrency(Object object, int lower2, int higher2) {
			// TODO Auto-generated method stub
			
		}
}