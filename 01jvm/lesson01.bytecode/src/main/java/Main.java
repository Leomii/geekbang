/**
 * entrance
 *
 * @author lei.rong
 * @version 1.0.0
 * @date 2021-11-5
 */
public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        int result = 0;

        for (int i = 0; i < b; i++) {
            result = result + a;

            if (result > 3) {
                break;
            }
        }

        System.out.println(result);
    }
}