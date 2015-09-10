package prac1;

class HeapSorter {

	/*
	 * DATASTRUCTURES AND ALGORITHMS 2015-2016 Practical assignment 1 Deadline:
	 * Thursday September 17, 2015
	 * 
	 * Name(s) : Alae Bohoudi VUid(s) : abi420
	 */

	/*
	 * - Every method must be declared static. - Please make sure you clean up
	 * your file before handing it in. E.g. remove insertionSort() (provided
	 * below as an example) as well as any debugging methods you may have
	 * written and used.
	 */
	void addNode(int number) {

	}

	void removeRoot() {

	}

	static int[] maxHeapify(int[] numberArray, int heapSize, int index) {

		int left = leftChild(index);
		int right = rightChild(index);
		int largest;
		if (left <= heapSize && numberArray[left] > numberArray[index]) {
			largest = left;
		} else
			largest = index;
		if (right <= heapSize && numberArray[right] > numberArray[largest]) {
			largest = right;
		}
		if (largest != index) {
			swap(numberArray[index], numberArray[largest]);
			maxHeapify(numberArray, heapSize, largest);
		}
		return null;
	}

	static void swap(int number1, int number2) {

		int temp = number1;
		number1 = number2;
		number2 = temp;

	}

	static void maxHeap(int[] numberArray) {
		int heapSize = numberArray.length;
		for (int i = (heapSize / 2) - 1; i >= 0; i--) {
			maxHeapify(numberArray, heapSize, i);
		}
	}

	int parent(int index) {
		return index / 2;
	}

	static int leftChild(int index) {
		return 2 * index;
	}

	static int rightChild(int index) {
		return 2 * index + 1;
	}

	static int[] heapSort(int[] numberArray) {
		maxHeap(numberArray);

		int heapsize = numberArray.length;
		for (int i = numberArray.length - 1; i > 0; i--) {
			swap(numberArray[i], numberArray[0]);
			heapsize -= 1;
			maxHeapify(numberArray, heapsize, 0);
		}
		return numberArray;
	}

	static int[] insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			/*
			 * The test i < a.length is executed for i=1,...,a.length, so
			 * a.length times. The assignment i++ is executed for
			 * i=1,...,a.length-1. The body of this for-loop is executed
			 * a.length-1 times.
			 */
			int key = a[i];
			/*
			 * This assignment is carried out a.length-1 times, for index
			 * i=1,...,a.length-1.
			 */
			int j = i;
			/*
			 * Similarly, this assignment is carried out a.length-1 times.
			 */
			while (j > 0 && a[j - 1] > key) {
				/*
				 * For a fixed i, the test j>0 is carried out at most i+1 times.
				 * For a fixed i, the test a[j-1] is carried out at most i
				 * times. In the best case, a[j-1]<= key for j=i. In the worst
				 * case, a[j-1]>key for all j=1,...,i, that is, key is the
				 * smallest element up to index i. So the body of the loop is
				 * executed i times in the worst case.
				 */
				a[j] = a[j - 1];
				/*
				 * For a fixed i, this shift operation is carried out i times,
				 * if we have i executions of the body, so in the worst case.
				 */
				j = j - 1;
				/*
				 * Similary, this assignment is executed i times in the worst
				 * case.
				 */
			}
			a[j] = key;
			/*
			 * This assignment is executed a.length-1 times, once for every run
			 * of the for-loop.
			 */
		}

		return a;
		/*
		 * Carried out once.
		 */
	}

	/*
	 * The worst-case time complexity for the test of the while loop is
	 * determined by the summation from i=1 up to i=a.length-1 of i+1, that is,
	 * 2 + ... + a.length. The worst-case time complexity for the two
	 * assignments in the body of the while-loop is determined by the summation
	 * from i=1 up to a.length-1 of i, that is, 1 + ... + a.length-1. Both
	 * summations yield a worst-case time comlexity of O(n^2). for the
	 * algorithm.
	 */

	static int[] start(int[] toSort, boolean binaryHeap) {
		if (binaryHeap) {
			insertionSort(toSort);
		} else { // ternary heap
			insertionSort(toSort);
		}

		return toSort;
	}
}