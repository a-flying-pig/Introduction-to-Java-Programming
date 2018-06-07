package chapter24;

public class SortLargeFile {
	public static final int MAX_ARRAY_SIZE = 100000;
	public static final int BUFFER_SIZE = 10000;
	
	public static void mian(String[] args) throws Exception {
		// Sort largedata.dat to sortedfile.dat
		sort("largedata.dat", "sortedfile.dat");
		
		// Display the first 100 numbers in the sorted file
		diaplayFile("sortedfile.dat");
	}

	/** Sort data in source file and into target file */
	public static void sort(String sourcefile, String targetfile) {
		// TODO Auto-generated method stub
		// Implement Phase 1:Create initial segments
		int numberOfSegments = 
				initializeSegments(MAX_ARRAY_SIZE, sourcefile, "f1.dat");
		
		// Implement Phase 2:Merge segments recursively
		merge(numberOfSegments, MAX_ARRAY_SIZE,
				"f1.dat", "f2.dat", "f2.dat", targetfile);
	}

}
