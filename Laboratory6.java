import java.util.*;

public class Laboratory6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== LABORATORY 6 - JAVA FUNDAMENTALS =====");
            System.out.println("1. Greeting (Name & Age)");
            System.out.println("2. Fibonacci Series");
            System.out.println("3. Sum & Average of 5 Numbers");
            System.out.println("4. Palindrome Checker");
            System.out.println("5. Rectangle Area");
            System.out.println("6. Product Stream Filter");
            System.out.println("7. EXIT");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                // ----------------------------------------------------
                // 1. Greeting
                // ----------------------------------------------------
                case 1:
                    System.out.println("\n=== ACTIVITY 1: GREETING ===");
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter your age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Hello " + name + "! You are " + age + " years old.");
                    break;

                // ----------------------------------------------------
                // 2. Fibonacci
                // ----------------------------------------------------
                case 2:
                    System.out.println("\n=== ACTIVITY 2: FIBONACCI SERIES ===");
                    System.out.print("Enter N (number of terms): ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    int a = 0, b = 1;
                    System.out.print("Fibonacci Series: ");

                    for (int i = 1; i <= n; i++) {
                        System.out.print(a + " ");
                        int next = a + b;
                        a = b;
                        b = next;
                    }
                    System.out.println();
                    break;

                // ----------------------------------------------------
                // 3. Sum & Average (comma-safe)
                // ----------------------------------------------------
                case 3:
                    System.out.println("\n=== ACTIVITY 3: SUM & AVERAGE OF ARRAY ===");
                    System.out.println("Enter 5 numbers (spaces or commas allowed):");

                    String line = sc.nextLine();
                    line = line.replace(",", " ");
                    String[] parts = line.trim().split("\\s+");

                    if (parts.length != 5) {
                        System.out.println("Error: Please enter exactly 5 numbers.");
                        break;
                    }

                    int[] numbers = new int[5];
                    int sum = 0;

                    for (int i = 0; i < 5; i++) {
                        numbers[i] = Integer.parseInt(parts[i]);
                        sum += numbers[i];
                    }

                    double average = sum / 5.0;

                    System.out.println("Sum = " + sum);
                    System.out.println("Average = " + average);
                    break;

                // ----------------------------------------------------
                // 4. Palindrome Checker
                // ----------------------------------------------------
                case 4:
                    System.out.println("\n=== ACTIVITY 4: PALINDROME CHECKER ===");
                    System.out.print("Enter a string: ");
                    String str = sc.nextLine();

                    String reversed = new StringBuilder(str).reverse().toString();

                    if (str.equalsIgnoreCase(reversed)) {
                        System.out.println(str + " is a palindrome!");
                    } else {
                        System.out.println(str + " is NOT a palindrome.");
                    }
                    break;

                // ----------------------------------------------------
                // 5. Rectangle
                // ----------------------------------------------------
                case 5:
                    System.out.println("\n=== ACTIVITY 5: RECTANGLE AREA ===");
                    System.out.print("Enter rectangle length: ");
                    double length = sc.nextDouble();
                    System.out.print("Enter rectangle width: ");
                    double width = sc.nextDouble();
                    sc.nextLine();

                    Rectangle rect = new Rectangle(length, width);
                    System.out.println("Area of Rectangle = " + rect.calculateArea());
                    break;

                // ----------------------------------------------------
                // 6. Product Stream Filter
                // ----------------------------------------------------
                case 6:
                    System.out.println("\n=== ACTIVITY 6: PRODUCT STREAM FILTER ===");

                    ArrayList<Product> products = new ArrayList<>();
                    products.add(new Product("Laptop", 55000));
                    products.add(new Product("Mouse", 450));
                    products.add(new Product("Keyboard", 800));
                    products.add(new Product("Monitor", 6200));
                    products.add(new Product("Flash Drive", 300));

                    System.out.print("Enter minimum price to filter: ");
                    double minPrice = sc.nextDouble();
                    sc.nextLine();

                    long countExpensive = products.stream()
                            .filter(p -> p.price > minPrice)
                            .count();

                    System.out.println("Products more expensive than " +
                            minPrice + ": " + countExpensive);
                    break;

                case 7:
                    System.out.println("\nExiting program... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}

// ----------------------------------------------------
// Rectangle CLASS
// ----------------------------------------------------
class Rectangle {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

// ----------------------------------------------------
// Product CLASS
// ----------------------------------------------------
class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
