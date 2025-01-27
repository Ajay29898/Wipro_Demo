// Operations.java
public class C2 
{

    // Method for multiplication
    public int multiply(int a, int b) 
    {
        return a * b;
    }

    // Method for modulo (remainder of division)
    public int modulo(int a, int b) 
    {
        return a % b;
    }

    public static void main(String[] args) 
    {
        C2 operations = new C2();

        int num1 = 10;
        int num2 = 5;

        // Calling multiply method
        int product = operations.multiply(num1, num2);
        System.out.println("Multiplication: " + product);

        // Calling modulo method
        int remainder = operations.modulo(num1, num2);
        System.out.println("Modulo: " + remainder);
    }
}

