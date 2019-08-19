
public class MainClass {
	// find max and min values using divide and conquer algo

	public static void divideAndConquer(int[] array, int startIndex, int length) {
		if (length - startIndex >= 2) {
			int divide = (length + startIndex) / 2;
			divideAndConquer(array, startIndex, divide);
			divideAndConquer(array, divide + 1, length);
		} else {
			if (startIndex - length == 0)
				System.out.println(array[startIndex]);
			else
				System.out.println(array[startIndex] + " , " + array[length]);
		}

	}

	public static void main(String[] args) {
		divideAndConquer(new int[] { 1, 2, 3, 4 }, 0, 3);
	}
}
