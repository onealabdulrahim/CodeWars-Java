package CountDivisors;
public class CountDivisors {

    public long numberOfDivisors(int n) {
        long divisorCount = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisorCount++;
            }
        }
        return divisorCount;
    }

    public static void main(String[] args) {
        CountDivisors cd = new CountDivisors();
        System.out.println(cd.numberOfDivisors(500000));
    }

}
