package codilitytest;

public class TestProgram {

	public static void main(String[] args) {
		TestProgram tp = new TestProgram();
		int[] A = { 2, 3, 4, 5 };
		System.out.println("Missing argument ans is=" + tp.permMissing(A));
		System.out.println("Missing argument ans is=" + tp.permMissing1(A));

	}
	public int permMissing(int[] A) {
		int aLength = A.length;
		if (aLength < 0)
			return -1;
		int xorSum = 0;
		for (int i = 0; i < aLength; i++) {
			String s = xorSum + "^" + A[i] + "^" + (i + 1);
			xorSum = xorSum ^ A[i] ^ (i + 1);
			System.out.println(xorSum + "=" + s);
		}
		return xorSum ^ (aLength + 1);
	}

	public int permMissing1(int[] A) {

		long N = A.length + 1;
		long total = N * (N + 1) / 2;

		for (int i : A) {
			total -= i;
		}
		return (int) total;
	}
}
