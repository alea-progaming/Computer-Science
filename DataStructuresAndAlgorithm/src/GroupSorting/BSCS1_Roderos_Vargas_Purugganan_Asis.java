package GroupSorting;
import java.util.Scanner;

	public class BSCS1_Roderos_Vargas_Purugganan_Asis {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the size of the array: ");
	        int size = scanner.nextInt();

	        int[] unsortedArray = new int[size];

	        System.out.print("Enter " + size + " values: ");
	        for (int i = 0; i < unsortedArray.length; i++) {
	            unsortedArray[i] = scanner.nextInt();
	        }

	        boolean hasExit = false;

	        while (!hasExit) {
	            System.out.println("Menu\n");
	            System.out.println("1. Merge Sort");
	            System.out.println("2. Quick Sort");
	            System.out.println("3. Heap Sort");
	            System.out.println("4. Exit\n");
	            System.out.print("Enter choice [1-4]: ");
	            int choice = scanner.nextInt();
	            System.out.println();

	            switch (choice) {
	                case 1:
	                    int[] mergeSortCopy = new int[unsortedArray.length];
	                    for (int i = 0; i < mergeSortCopy.length; i++)
	                        mergeSortCopy[i] = unsortedArray[i];
	                    System.out.print("UNSORTED: ");
	                    printArray(unsortedArray);
	                    System.out.println();
	                    mergeSort(mergeSortCopy);
	                    System.out.print("\n\nSORTED: ");
	                    printArray(mergeSortCopy);
	                    System.out.println("\n");
	                    break;
	                case 2:
	                    int[] copy = new int[unsortedArray.length];

	                    for (int i = 0; i < copy.length; i++)
	                        copy[i] = unsortedArray[i];
	                    System.out.print("UNSORTED: ");
	                    printArray(copy);
	                    System.out.println("\n");
	                    quickSort(copy, 0, size - 1);
	                    System.out.println();
	                    System.out.print("SORTED : ");
	                    printArray(copy);
	                    System.out.println("\n");
	                    break;
	                case 3:
	                    heapSort(unsortedArray);
	                    break;
	                case 4:
	                    hasExit = true;
	                    break;
	                default:
	                    break;
	            }
	        }

	        // printArray(unsortedArray);

	        scanner.close();
	    }

	    public static void mergeSort(int[] unsortedArray) {
	        int arrayLength = unsortedArray.length;
	        if (arrayLength < 2) {
	            return;
	        }

	        int q = arrayLength / 2;
	        int left[] = new int[q];
	        int right[] = new int[arrayLength - q];

	        System.out.print("\n");
	        for (int p = 0; p < q; p++) {
	            left[p] = unsortedArray[p];
	            System.out.print(left[p] + " ");
	        }
	        System.out.print("| ");
	        for (int r = q; r < arrayLength; r++) {
	            right[r - q] = unsortedArray[r];
	            System.out.print(right[r - q] + " ");
	        }

	        mergeSort(left);

	        mergeSort(right);

	        merge(unsortedArray, left, right);

	    }

	    public static void merge(int array[], int left[], int right[]) {
	        int leftSize = left.length;
	        int rightSize = right.length;

	        int i = 0, j = 0, k = 0;
	        System.out.print("\n");
	        while (i < leftSize && j < rightSize) {
	            if (left[i] <= right[j]) {
	                array[k] = left[i];
	                i++;
	            } else {
	                array[k] = right[j];
	                j++;
	            }
	            System.out.print(array[k] + " ");
	            k++;
	        }

	        while (i < leftSize) {
	            array[k] = left[i];
	            System.out.print(array[k] + " ");
	            i++;
	            k++;
	        }

	        while (j < rightSize) {
	            array[k] = right[j];
	            System.out.print(array[k] + " ");
	            j++;
	            k++;
	        }
	    }

	    public static void quickSort(int[] array, int start, int end) {
	        if (start < end) {
	            int pi = partition(array, start, end);
	            quickSort(array, start, pi - 1);
	            quickSort(array, pi + 1, end);
	        }
	    }

	    public static int partition(int[] array, int start, int end) {
	        int pivot = array[end];
	        int i = (start - 1);

	        for (int j = start; j <= end - 1; j++) {

	            if (array[j] < pivot) {
	                i++;
	                swap(array, i, j);

	                printArray(array);
	                System.out.println();
	            }
	        }
	        swap(array, i + 1, end);
	        return (i + 1);
	    }

	    public static void swap(int[] arr, int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }

	    public static void heapSort(int[] unsortedArray) {
	        int[] maxHeap = heapify(unsortedArray);

	        System.out.print("UNSORTED: ");
	        printArray(unsortedArray);
	        System.out.println("\n");

	        System.out.print("MAX HEAP: ");
	        printArray(maxHeap);
	        System.out.println();

	        BinaryTree<Integer> maxHeapTree = new BinaryTree<Integer>();
	        // Convert int to Integer
	        maxHeapTree.buildTreeFromArray(java.util.Arrays.stream(maxHeap).boxed().toArray(Integer[]::new));
	        maxHeapTree.print();
	        System.out.println("\n------------------------------------------------------------------------\n");
	        // int[] subsequence = subsequenceOf(maxHeap, 0, 3);
	        // System.out.print("Subsequence: ");
	        // printArray(subsequence);

	        for (int i = maxHeap.length - 1; i > 0; i--) {
	            int temp = maxHeap[i];
	            maxHeap[i] = maxHeap[0];
	            maxHeap[0] = temp;

	            int[] subHeap = heapify(subsequenceOf(maxHeap, 0, i - 1));

	            for (int j = 0; j < subHeap.length; j++) {
	                maxHeap[j] = subHeap[j];
	            }

	            printArray(maxHeap);
	            System.out.println();
	            BinaryTree<Integer> subHeapTree = new BinaryTree<Integer>();
	            // Convert int to Integer
	            subHeapTree.buildTreeFromArray(java.util.Arrays.stream(subHeap).boxed().toArray(Integer[]::new));
	            subHeapTree.print();
	            System.out.println("\n------------------------------------------------------------------------\n");
	        }

	        System.out.print("SORTED: ");
	        printArray(maxHeap);
	        System.out.println("\n");
	    }

	    public static int[] subsequenceOf(int[] array, int start, int end) {
	        if (start > end)
	            throw new InvalidSubsequenceIndexException();

	        int[] subsequence = new int[end - start + 1];

	        for (int i = start, j = 0; i <= end; i++, j++) {
	            subsequence[j] = array[i];
	        }

	        return subsequence;
	    }

	    public static int[] heapify(int[] array) {
	        int[] maxHeap = new int[array.length];

	        for (int i = 0; i < maxHeap.length; i++) {
	            maxHeap[i] = array[i];

	            int j = i;
	            while (j > 0) {
	                if (maxHeap[j] > maxHeap[((j + 1) / 2) - 1]) {
	                    int temp = maxHeap[((j + 1) / 2) - 1];
	                    maxHeap[((j + 1) / 2) - 1] = maxHeap[j];
	                    maxHeap[j] = temp;
	                    j = ((j + 1) / 2) - 1;
	                } else
	                    break;
	            }
	        }

	        return maxHeap;
	    }

	    public static void printArray(int[] array) {
	        for (int i = 0; i < array.length; i++) {
	            System.out.print(array[i] + " ");
	        }
	    }
	}

	class BinaryTreeNode<T> {
	    private T value;
	    private BinaryTreeNode<T> leftChild;
	    private BinaryTreeNode<T> rightChild;

	    public BinaryTreeNode(T value) {
	        this.value = value;
	        this.leftChild = null;
	        this.rightChild = null;
	    }

	    public void setValue(T value) {
	        this.value = value;
	    }

	    public T getValue() {
	        return this.value;
	    }

	    public BinaryTreeNode<T> getLeftChild() {
	        return this.leftChild;
	    }

	    public BinaryTreeNode<T> getRightChild() {
	        return this.rightChild;
	    }

	    public void setLeftChild(BinaryTreeNode<T> node) {
	        this.leftChild = node;
	    }

	    public void setRightChild(BinaryTreeNode<T> node) {
	        this.rightChild = node;
	    }

	    // public void inOrderTraversal() {
	    // if (this.getLeftChild() != null) {
	    // this.leftChild.inOrderTraversal();
	    // }

	    // System.out.print(this.value + " ");

	    // if (this.getRightChild() != null) {
	    // this.rightChild.inOrderTraversal();
	    // }
	    // }

	    // public void addToEnd(T value) {
	    // if (this.leftChild == null) {
	    // this.leftChild = new BinaryTreeNode<T>(value);
	    // } else if (this.rightChild == null) {
	    // this.rightChild = new BinaryTreeNode<T>(value);
	    // }
	    // }
	    public void print() {
	        print("", this, false);
	    }

	    public void print(String prefix, BinaryTreeNode<T> n, boolean isLeft) {
	        if (n != null) {
	            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.value);
	            print(prefix + (isLeft ? "|   " : "    "), n.leftChild, true);
	            print(prefix + (isLeft ? "|   " : "    "), n.rightChild, false);
	        }
	    }
	}

	class BinaryTree<T> {
	    private BinaryTreeNode<T> root;

	    public BinaryTree() {
	        this.root = null;
	    }

	    public void buildTreeFromArray(T[] array) {
	        root = insertLevelOrder(array, root, 0);
	    }

	    private BinaryTreeNode<T> insertLevelOrder(T[] array, BinaryTreeNode<T> parent, int index) {
	        if (index < array.length) {
	            parent = new BinaryTreeNode<T>(array[index]);

	            parent.setLeftChild(insertLevelOrder(array, parent.getLeftChild(), 2 * index + 1));
	            parent.setRightChild(insertLevelOrder(array, parent.getRightChild(), 2 * index + 2));
	        }

	        return parent;
	    }

	    public void inOrderTraversal() {
	        inOrder(root);
	    }

	    private void inOrder(BinaryTreeNode<T> parent) {
	        if (parent != null) {
	            inOrder(parent.getLeftChild());
	            System.out.print(parent.getValue() + " ");
	            inOrder(parent.getRightChild());
	        }
	    }

	    public void print() {
	        root.print();
	    }

	    // public void addToEnd(T value) {
	    // if (this.root == null) {
	    // this.root = new BinaryTreeNode<T>(value);
	    // } else {
	    // this.root.addToEnd(value);
	    // }
	    // }
	}

	class InvalidSubsequenceIndexException extends RuntimeException {
	    public InvalidSubsequenceIndexException() {
	        super("Invalid index of subsquence");
	    }
	}

