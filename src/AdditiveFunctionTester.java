import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 *  This class consists of a static method to generate prime numbers and to 
 *  functions to call a check if a secret function is additive by calling
 *  it with combinations of prime numbers.  It also uses caching for optimization.
 * 
 * @author Ryan Gidus
 *
 */

public class AdditiveFunctionTester {
    
    /*
     * HashMap with Integer keys and values to save results from the secret function
     */
    private Map<Integer, Integer> cacheMap = new HashMap<Integer, Integer>();

    /**
     * Checks the cache for the result of the input n. If there's a hit,
     * the value is returned.  Otherwise, secret is called and the result
     * is cached and returned.
     * 
     * @param n the input for the secret function
     * @return the result of the secret function
     */
    public int checkSecret(int n) {
	Integer returnValue;

	if ((returnValue = cacheMap.get(n)) != null) {
	    return returnValue;
	} else {
	    returnValue = Mystery.secret(n);
	    cacheMap.put(n, returnValue);
	}
	return returnValue;
    }

    /**
     * Loops through a BitSet of prime numbers and calls uses each combination
     * to check if secret is additive
     * 
     * @param primes a BitSet of prime numbers with primes marked as true
     * @return a boolean representing whether or not secret is additive
     */
    public boolean isSecretAdditive(BitSet primes) {
	int length = primes.length();

	for (int i = 0; i < length; i++) {
	    if (primes.get(i)) {
		for (int j = i + 1; j < length; j++) {
		    if (primes.get(j)) {
			if (checkSecret(i + j) != checkSecret(i)
				+ checkSecret(j))
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
     * @param N the limit on the value of prime numbers to generate
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