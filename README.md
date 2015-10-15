# SecretFunction
Secret Function Code for Hannon Hill Coding Exercise

Description
-----------
A Secret encapsulates a function that accepts a single integer parameter and returns an integer. Secret is a given but you do not know its implementation. In Java or a language of your choice, write an application that determines if Secret is an additive function secret(x+y) = secret(x) + secret(y) for all combinations of prime numbers less than N where N is also a given.

Implementation
--------------
I chose Java because that is my strongest language and the language required by the job I am applying for.  My implementation uses a Sieve of Eratosthenes to efficiently generate prime numbers stored by true values in a Bitset.  To test secret() with all combinations of prime numbers, the program will loop through a computed BitSet for every combination of prime numbers x and y.  It will call a wrapper function with x+y, x and y seperately and compare if the results are equivalent.  If they ever yield false, the function is not additive.  If the loop completes then the function is additive thus it will return true.

The wrapper function will use a HashMap to cache values returned from the secret function.  Since we do not know the implementation of the function, we must assume worst case that it is inefficient.  HashMap lookups are quick and many duplicate values are sent to secret making this a good optimization.  Of course, we are assuming that sufficient memory is available to hold this HashMap, which is rather light. 

The secret() function is called via a static method in the Mystery class.  This method is currently implemented as an additive function for testing purposes.

For more details on individual functions and classes, please refer to the JavaDocs below.


JavaDocs
--------
[Documentation](http://nolepointer.github.io/SecretFunction/doc/)

Installation
------------
To build the classes, run the following command from src/

    $ javac *

Now run the driver class with one argument N, with N representing all combinations of prime numbers less than N

    $ java AdditiveFunctionTesterDriver 100
    $ Secret is an additive function!

You will get an output describing whether or not secret() is an additive function
