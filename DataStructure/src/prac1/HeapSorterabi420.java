package prac1;

class HeapSorterabi420 {

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

	static int leftChild(int index) {
		/*
		 * we calculate the index of left child of the node: 2i and we add one
		 * because the array starts at index 0 *
		 */
		return 2 * index + 1;
	}

	static int rightChild(int index) {
		/*
		 * we calculate the index of the right child of the node : 2i+1 and we
		 * add one because the array starts at index 0 *
		 */
		return 2 * index + 2;
	}

	static void maxHeapify(int[] numberArray, int heapSize, int index) {
		/*
		 * this method corrects the heap property in the heap(subtree's if
		 * necessary) the method takes three argument : 1-numberArray: the heap
		 * 2-heapSize 3-index: points to the root of the subtree. Since this
		 * method corrects the heap property per level and the height of a heap
		 * with size n is Log n. this method can call its self recursively up to
		 * Log n times. the worst time complexity of this method is O(log n)
		 */

		int left = leftChild(index);//
		int right = rightChild(index);
		int largest = Integer.MIN_VALUE, temp = 0;
		if (left <= heapSize && numberArray[left] > numberArray[index]) {
			largest = left;
		} else
			largest = index;
		if (right <= heapSize && numberArray[right] > numberArray[largest]) {
			largest = right;
		}
		if (largest != index) {
			temp = numberArray[index];
			numberArray[index] = numberArray[largest];
			numberArray[largest] = temp;
			maxHeapify(numberArray, heapSize, largest);
		}
	}

	static void maxHeap(int[] numberArray) {

		// this function builds the max heap from unordered array
		// worst case time complexity is O(n) due to
		// the recurrence summation
		int heapSize = numberArray.length - 1;
		/*
		 * this for loop starts from n/2 which's the last level of nodes because
		 * [n/2+1,....n]are all leaves
		 */
		for (int i = (heapSize / 2); i >= 0; i--) {

			maxHeapify(numberArray, heapSize, i);
		}
	}

	static int[] heapSort(int[] numberArray) {

		maxHeap(numberArray);// Worst time complexity O(n)
		int temp = 0;// this assignment is carried out one time
		int heapsize = numberArray.length - 1;// this assignment is carried out
												// one time
		// after building Max heap the biggest number is at the root
		for (int i = numberArray.length - 1; i > 0; i--) {
			// this for-loop is executed numberArray-1 times (n -1)
			temp = numberArray[i];// first we swap the root of the heap
			numberArray[i] = numberArray[0];// with the last element
			numberArray[0] = temp;// of the array and we consider it sorted
			heapsize -= 1;// by decreasing the heap size with 1
			maxHeapify(numberArray, heapsize, 0);// and we corrects the heap
													// property with O (log n)
			// the worst time complexity of the for loop is O(n log n)
		}
		/*
		 * 
		 * the worst time complexity of the heap sort is O( n log n)
		 */
		return numberArray;
	}

	static int tenaryLeftChild(int index) {
		/*
		 * we calculate the index of left child of the node: 3i and we add one
		 * because the array starts at index 0 *
		 */
		return 3 * index + 1;

	}

	static int tenaryMiddleChild(int index) {
		/*
		 * we calculate the index of middle child of the node: 3i+1 and we add
		 * one because the array starts at index 0 *
		 */
		return 3 * index + 2;
	}

	static int tenaryRightChild(int index) {
		/*
		 * we calculate the index of right child of the node: 3i+2 and we add
		 * one because the array starts at index 0 *
		 */
		return 3 * index + 3;
	}

	static void ternaryMaxHeapify(int[] numberArray, int heapSize, int index) {

		/*
		 * this method corrects the heap property in the heap(subtree's if
		 * necessary) the method takes three argument : 1-numberArray: the heap
		 * 2-heapSize 3-index: points to the root of the subtree. Since this
		 * method corrects the heap property per level and the height of a heap
		 * with size n is Log n. this method can call its self recursively up to
		 * Log n times. the worst time complexity of this method is O(log n)
		 */
		int left = tenaryLeftChild(index);
		int middle = tenaryMiddleChild(index);
		int right = tenaryRightChild(index);
		int largest = Integer.MIN_VALUE, temp = 0;

		if (left <= heapSize && numberArray[left] > numberArray[index]) {
			largest = left;
		} else {
			largest = index;
		}
		if (middle <= heapSize && numberArray[middle] > numberArray[largest]) {
			largest = middle;
		}
		if (right <= heapSize && numberArray[right] > numberArray[largest]) {
			largest = right;
		}
		if (largest != index) {
			temp = numberArray[index];// swap
			numberArray[index] = numberArray[largest];
			numberArray[largest] = temp;
			ternaryMaxHeapify(numberArray, heapSize, largest);
		}
	}

	static void ternaryMaxHeap(int[] numberArray) {
		/*
		 * this function builds the max heap from unordered array worst case
		 * time complexity is O(n) due to the recurrence summation
		 */
		int heapSize = numberArray.length - 1;
		/*
		 * this for loop starts from n/3 which's the last level of nodes because
		 * [n/3+1,....n]are all leaves
		 */

		for (int i = (heapSize / 3); i >= 0; i--) {

			ternaryMaxHeapify(numberArray, heapSize, i);
		}
	}

	static int[] ternaryHeapSort(int[] numberArray) {
		ternaryMaxHeap(numberArray);
		int temp = 0;// this assignment is carried out one time
		int heapsize = numberArray.length - 1;// this assignment is carried out
												// one time
		// after building Max heap the biggest number is at the root
		for (int i = numberArray.length - 1; i > 0; i--) {
			// this for-loop is executed numberArray-1 times (n -1)
			temp = numberArray[i];// first we swap the root of the heap
			numberArray[i] = numberArray[0];// with the last element
			numberArray[0] = temp;// of the array and we consider it sorted
			heapsize -= 1;// by decreasing the heap size with 1
			ternaryMaxHeapify(numberArray, heapsize, 0);// and we corrects the
														// heap property
		}
		return numberArray;
	}
	/*
	 * the ternary heap sort is faster than binary heap sort because each node
	 * in the ternary heap has three children resulting in reducing the height
	 * of the heap and the number of comparisons and swaps
	 * 
	 * the worst time complexity of the heapSort and teanryHeapSort are both in
	 * O(n log n) but the ternary heap sort is faster.
	 */

	static int[] start(int[] toSort, boolean binaryHeap) {
		if (binaryHeap) {
			heapSort(toSort);
		} else { // ternary heap
			ternaryHeapSort(toSort);
		}

		return toSort;
	}
}
