package Assignment2;

public class PrimeGenerator {
    private int current;
    public PrimeGenerator()
    {
        current = 1;
    }
    /**
     Calculates the next prime number.
     @return the next prime number
     */
    public int nextPrime()
    {
        int loopCur = current++;//to keep from a never ending loop
        for (; current < (loopCur + 10); current++) {
            if(isPrime(current)){
                break;
            }
        }
        return current;
    }
    /**
     Check if n is a prime number.
     @param n to check whether it is prime or not
     @return true if n is prime
     */
    public static boolean isPrime(int n) {
        if(n == 1){
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int getCurrent() {
        return current;
    }
}
