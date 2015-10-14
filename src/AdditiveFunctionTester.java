import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Ryan Gidus
 *
 */

public class AdditiveFunctionTester {
    private Map<Integer, Integer> cacheMap = new HashMap<Integer, Integer>();

    private int secret(int n) {
	/**
	 * Implementation unknown
	 */
	return n;
    }

    // cache then call secret
    public int checkSecret(int n) {
	Integer returnValue;

	if ((returnValue = cacheMap.get(n)) != null) {
	    return returnValue;
	} else {
	    returnValue = secret(n);
	    cacheMap.put(n, returnValue);
	}
	return returnValue;
    }

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

    public BitSet generatePrimes(int N) {
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