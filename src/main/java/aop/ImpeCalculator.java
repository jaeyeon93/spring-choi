package aop;

public class ImpeCalculator implements Calculator {

    @Override
    public long factorial(long num) {
        long startTime = System.currentTimeMillis();
        long result = 1;
        for (int i = 1; i <= num; i++)
            result *= i;
        long endTime = System.currentTimeMillis();
        System.out.printf("ImpeCalculator(%d) 실행 시간 = %d\n", num,(endTime - startTime));
        return result;
    }

}
