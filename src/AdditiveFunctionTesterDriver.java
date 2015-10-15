import java.util.BitSet;

/**
 * 
 * @author Ryan Gidus
 *
 */
public class AdditiveFunctionTesterDriver {
    
    private static int DEFAULT_LIMIT = 100;

    public static void main(String[] args) {
	int limit = DEFAULT_LIMIT;
	if(args.length > 0) {
	    try {
		limit = Integer.parseInt(args[0]);
	    } catch(NumberFormatException e) {
		System.err.println("The argument must be an integer. Using default" + DEFAULT_LIMIT);
	    }
	    
	}
	AdditiveFunctionTester tester = new AdditiveFunctionTester();
	BitSet primes = tester.generatePrimes(limit);

	if(tester.isSecretAdditive(primes))
	    System.out.println("Secret is an additive function!");
	else
	    System.out.println("Secret is NOT an additive function.");

    }
}
