import java.util.Scanner;

public class ATMSimulation {
      public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in); 

        double balance = 1000.00; // Initial balance 

        String correctPIN = "1234"; // Pre-set PIN for authentication 

 

        try { 

            // Step 1: Authentication 

            System.out.print("Enter your PIN: "); 

            String enteredPIN = scanner.nextLine(); 

 

            if (!enteredPIN.equals(correctPIN)) { 

                throw new SecurityException("Invalid PIN! Access Denied."); 

            } 

 

            // Step 2: ATM Operations 

            while (true) { 

                System.out.println("\n--- ATM Menu ---"); 

                System.out.println("1. Check Balance"); 

                System.out.println("2. Withdraw Money"); 

                System.out.println("3. Deposit Money"); 

                System.out.println("4. Exit"); 

                System.out.print("Choose an option: "); 

                 

                int choice = scanner.nextInt(); 

 

                switch (choice) { 

                    case 1: // Check Balance 

                        System.out.printf("Your current balance is: $%.2f%n", balance); 

                        break; 

 

                    case 2: // Withdraw Money 

                        System.out.print("Enter amount to withdraw: "); 

                        double withdrawAmount = scanner.nextDouble(); 

 

                        if (withdrawAmount <= 0) { 

                            throw new IllegalArgumentException("Withdrawal amount must be greater than zero."); 

                        } 

                        if (withdrawAmount > balance) { 

                            throw new ArithmeticException("Insufficient funds!"); 

                        } 

 

                        balance -= withdrawAmount; 

                        System.out.printf("Withdrawal successful! Remaining balance: $%.2f%n", balance); 

                        break; 

 

                    case 3: // Deposit Money 

                        System.out.print("Enter amount to deposit: "); 

                        double depositAmount = scanner.nextDouble(); 

 

                        if (depositAmount <= 0) { 

                            throw new IllegalArgumentException("Deposit amount must be greater than zero."); 

                        } 

 

                        balance += depositAmount; 

                        System.out.printf("Deposit successful! New balance: $%.2f%n", balance); 

                        break; 

 

                    case 4: // Exit 

                        System.out.println("Thank you for using the ATM. Goodbye!"); 

                        scanner.close(); 

                        System.exit(0); 

                        break; 

 

                    default: 

                        System.out.println("Invalid option! Please try again."); 

                        break; 

                } 

            } 

        } catch (SecurityException se) { 

            System.out.println("Error: " + se.getMessage()); 

        } catch (IllegalArgumentException iae) { 

            System.out.println("Error: " + iae.getMessage()); 

        } catch (ArithmeticException ae) { 

            System.out.println("Error: " + ae.getMessage()); 

        } catch (Exception e) { 

            System.out.println("Unexpected error: " + e.getMessage()); 

        } finally { 

            System.out.println("ATM session ended."); 

        } 

    } 
}
