import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * This class consists of a static methods to generate prime numbers and to
 * check if a secret function is additive. It does this by calling secret with
 * all combinations of prime numbers up to a given value. Caching is used for
 * optimization.
 * 
 * @author Ryan Gidus
 * 
 */

public class AdditiveFunctionTester {

    /**
     * Wrapper function to call secret while caching known results.
     * 
     * @param n
     *            the input for the secret function
     * @return the result of the secret function
     */
    public static int checkSecret(int n) {
	Integer returnValue;
	/*
	* HashMap with Integer keys and values to save results from the secret
	* function
	*/
	Map<Integer, Integer> cacheMap = new HashMap<Integer, Integer>();

	if ((returnValue = cacheMap.get(n)) != null) {
	    return returnValue;
	} else {
	    returnValue = Mystery.secret(n);
	    cacheMap.put(n, returnValue);
	}
	return returnValue;
    }

    /**
     * Loops through a BitSet of prime numbers and calls secret using each
     * combination to check if secret is additive
     * 
     * @param primes
     *            a BitSet of prime numbers with primes marked as true
     * @return a boolean representing whether or not secret is additive
     */
    public static boolean isSecretAdditive(BitSet primes) {
	int length = primes.length();

	for (int i = 0; i < length; i++) {
	    if (primes.get(i)) {
		for (int j = i + 1; j < length; j++) {
		    if (primes.get(j)) {
			if (checkSecret(i + j) != checkSecret(i) + checkSecret(j))
			    return false;
		    }
		}
	    }
	}
	return true;
    }

    /**
     * Use a Sieve of Eratosthenes to generate prime numbers
     * 
     * @param N
     *            the limit on the value of prime numbers to generate
     * @return a Bitset with prime values marked as true
     */
    public static BitSet generatePrimes(int N) {
	BitSet numberSet = new BitSet(N);
	numberSet.set(0, N, true);

	numberSet.set(0, false);
	numberSet.set(1, false);
	numberSet.set(2, true);

	for (int i = 2; i < Math.sqrt(N); i++) {
	    if (numberSet.get(i)) {
		for (int j = i * i; j < N; j += i) {
		    numberSet.set(j, false);
		}
	    }
	}
	return numberSet;
    }
}