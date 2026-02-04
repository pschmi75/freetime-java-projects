package crossSum;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i < 1001; i++) {
            System.out.println(9  + " x " + i + " :  \t" + crossSum(9 * i));
        }
    }

    public static int crossSum(int num) {
        String numStr = String.valueOf(num);
        int csum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            csum += (numStr.charAt(i) - '0');
        }
        return csum;
    }
}
