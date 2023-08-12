import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
//		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt(), k = fs.nextInt();
			PriorityQueue<Integer> alice = new PriorityQueue<>();
			PriorityQueue<Integer> bob = new PriorityQueue<>();
			PriorityQueue<Integer> both = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				int t = fs.nextInt(), a = fs.nextInt(), b = fs.nextInt();
				if (a == 1 && b == 1) {
					both.add(t);
				} else if (a == 1) {
					alice.add(t);
				} else if (b == 1) {
					bob.add(t);
				}
			}
			if (alice.size() + both.size() < k || bob.size() + both.size() < k) {
				System.out.println(-1);
				continue;
			}
			long sum = 0;
			int chosen;
			while (k > 0) {
				if (alice.isEmpty() || bob.isEmpty()) {
					chosen = both.poll();
				} else if (both.isEmpty()) {
					chosen = alice.poll() + bob.poll();
				} else {
					if (alice.peek() + bob.peek() <= both.peek()) {
						chosen = alice.poll() + bob.poll();
					} else {
						chosen = both.poll();
					}
				}
//				System.out.println(k + " = " + chosen);
				sum += chosen;
				k--;
			}
			System.out.println(sum);
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
