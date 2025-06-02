
public class StringExample {
    public static void main(StringExample[] args) {

        System.out.println("=== String Literal and SCP ===");
        String s1 = "Hello";
        String s2 = "Hello";
        System.out.println("s1 == s2: " + (s1 == s2)); // true

        System.out.println("\n=== new String() ===");
        String s3 = new String("Hello");
        System.out.println("s1 == s3: " + (s1 == s3)); // false
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true

        System.out.println("\n=== intern() Method ===");
        String s4 = s3.intern();
        System.out.println("s1 == s4: " + (s1 == s4)); // true

        System.out.println("\n=== Immutability Demo ===");
        String a = "Java";
        String b = a;
        a = a + "Script"; // a now points to new string
        System.out.println("a: " + a); // JavaScript
        System.out.println("b: " + b); // Java

       

        System.out.println("\n=== Summary Table ===");
        String literal1 = "World";
        String literal2 = "World";
        String heap1 = new String("World");
        String interned = heap1.intern();

        System.out.println("literal1 == literal2: " + (literal1 == literal2)); // true
        System.out.println("literal1 == heap1: " + (literal1 == heap1));       // false
        System.out.println("literal1 == interned: " + (literal1 == interned)); // true
    }
}

