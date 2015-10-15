import java.util.BitSet;

/**
 * A driver class for the AdditiveFunctionTester.  This class will determine
 * whether secret is an additive function and display the results to the user
 * using standard out
 * 
 * @author Ryan Gidus
 *
 */
public class AdditiveFunctionTesterDriver {
    
    /*
     * Default limit used if no argument is given
     */
    private static int DEFAULT_LIMIT = 100;

    /**
     * Main class to be called from a command line and given an argument
     * representing the limit on the value of prime numbers to generate and 
     * test with the secret function
     * 
     * @param args
     */
    public static void main(String[] args) {
	int limit = DEFAULT_LIMIT;
	if(args.length > 0) {
	    try {
		limit = Integer.parseInt(args[0]);
	    } catch(NumberFormatException e) {
		System.err.println("The argument must be an integer. Using default: " + DEFAULT_LIMIT);
	    }
	    
	}
	AdditiveFunctionTester tester = new AdditiveFunctionTester();
	BitSet primes = AdditiveFunctionTester.generatePrimes(limit);

	if(tester.isSecretAdditive(primes))
	    System.out.println("Secret is an additive function!");
	else
	    System.out.println("Secret is NOT an additive function.");

    }
}
