package huiswerk.recursie;

public class opdracht {

	public static void main(String[] args) {
		int sum=0;
		int n=1000;
		
		long startTime;
		long endTime;
		
		// Fragment 1
		startTime = System.nanoTime();
		for( int i = 0; i < n; i++ )
		 sum++;
		endTime   = System.nanoTime();
		runtime(startTime, endTime);
		
		// Fragment 2
		startTime = System.nanoTime();
		for( int i = 0; i < n; i += 2 )
		 sum++;
		endTime   = System.nanoTime();
		runtime(startTime, endTime);
		// Fragment 3
		startTime = System.nanoTime();
		for( int i = 0; i < n; i++ )
		 for( int j = 0; j < n; j++ )
		 sum++;
		endTime   = System.nanoTime();
		runtime(startTime, endTime);
		// Fragment 4
		startTime = System.nanoTime();
		for( int i = 0; i < n; i++ )
		 sum++;
		endTime   = System.nanoTime();
		runtime(startTime, endTime);
		for( int j = 0; j < n; j++ )
		 sum++;
		endTime   = System.nanoTime();
		runtime(startTime, endTime);
		// Fragment 5
		startTime = System.nanoTime();
		for( int i = 0; i < n; i++ )
		 for( int j = 0; j < n * n; j++ )
		 sum++;
		endTime   = System.nanoTime();
		runtime(startTime, endTime);
		// Fragment 6
		startTime = System.nanoTime();
		for( int i = 0; i < n; i++ )
		 for( int j = 0; j < i; j++ )
		 sum++;
		endTime   = System.nanoTime();
		runtime(startTime, endTime);
		// Fragment 7
		startTime = System.nanoTime();
		for( int i = 0; i < n; i++ )
		 for( int j = 0; j < n * n; j++ )
		 for( int k = 0; k < j; k++ )
		 sum++;
		endTime   = System.nanoTime();
		runtime(startTime, endTime);
		// Fragment 8
		startTime = System.nanoTime();
		for( int i = 1; i < n; i = i * 2 )
		 sum++;
		endTime   = System.nanoTime();
		runtime(startTime, endTime);
	}
	
	public static void runtime(long start, long end) {
		long totalTime = end - start;
		System.out.println(totalTime + "ms");
	}
}

