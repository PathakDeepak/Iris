import java.util.Scanner;

/**
 * @author valar_morghulis on 25/01/23.
 * @project multi-module-gradle
 * @description
 */
public class Application {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("1. ADD ");
        System.out.println("2. SUB ");
        System.out.println("3. MUL ");
        System.out.println("4. DIV ");
        System.out.println("5. LOGARITHM ");

        int choice = input.nextInt();
        System.out.println("Enter two numbers");
        int a = input.nextInt();
        int b = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("The sum is: " + Arithmetic.add(a, b));
                break;
            case 2:
                System.out.println("The sub is: " + Arithmetic.sub(a, b));
                break;
            case 3:
                System.out.println("The mul is: " + Arithmetic.mul(a, b));
                break;
            case 4:
                System.out.println("The div is: " + Arithmetic.div(a, b));
                break;
            case 5:
                System.out.println("The log of " + a + " base " + b + " is: " + Logarithm.log(a, b));
                break;
            default:
                System.out.println("Enter correct choice!");
                break;
        }

    }
}
