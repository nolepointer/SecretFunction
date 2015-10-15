# SecretFunction
Secret Function README for Hannon Hill Coding Exercise

Description
-----------
A Secret encapsulates a function that accepts a single integer parameter and returns an integer. Secret is a given but you do not know its implementation. In Java or a language of your choice, write an application that determines if Secret is an additive function secret(x+y) = secret(x) + secret(y) for all combinations of prime numbers less than N where N is also a given.

Implementation
--------------
I chose Java because that is my strongest language and the language required by the job I am applying for.  My implementation uses a Sieve of Eratosthenes to efficiently generate prime numbers. These numbers are stored by marking the index of their value as 'true' in a Bitset.  The program will test secret() with all combinations of prime numbers within a given range. It does this using a nested loop which identifies all pairs of prime numbers, x and y, in a BitSet.  It will then call a wrapper function with x+y, x and y seperately and compare if the results are equivalent.  If any pair is not equivalent then the secret function is not additive.  If the loop completes then the secret function is additive.

The wrapper function will use a HashMap to cache values returned from the secret function.  Since we do not know the implementation of the secret function, we must assume that it is inefficient.  HashMap lookups are quick and many duplicate values are sent to secret which makes caching a good optimization.  Of course, we are assuming performance is more important than memory usage as this optimization utilizes extra memory. 

The secret() function is called via a static method in the Mystery class.  This method is currently implemented as an additive function for testing purposes.

For more details on individual functions and classes, please refer to the JavaDocs below.


JavaDocs
--------
[Documentation](http://nolepointer.github.io/SecretFunction/doc/)

Installation
------------
To build the classes, run the following command from src/

    $ javac *.java

To run the driver class call the java function as shown below with one argument N. N represents the upper limit on the value of the generated prime numbers.

    $ java AdditiveFunctionTesterDriver 100
    $ Secret is an additive function!

You will get an output describing whether or not secret() is an additive function
