
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Practica2 {
	private Scanner lector = new Scanner(System.in);
    private Stack pila = new Stack<>();
    public static void main(String[] args) {
        Stack<String> pila;
        String expr;
        try (Scanner lector = new Scanner(System.in)) {
            System.out.print("Introduce la expresión a evaluar: ");
            expr = lector.nextLine();
            pila = evaluarExpresion(expr);
            if (!pila.isEmpty()) {
                System.out.println("\nResultado final: " + pila.peek());
            } else {
                System.out.println("\nLa pila está vacía. No hay resultado final.");
            }
        }
    }

    public static Stack<String> evaluarExpresion(String expr) {
        Stack<String> pila = new Stack<>();
        StringTokenizer st = new StringTokenizer(expr);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            switch (token) {
                case "+": {
                    if (pila.size() >= 2) {
                        String b = pila.pop();
                        String a = pila.pop();
                        String res = a + b;
                        pila.push(res);
                        System.out.println(a + " + " + b + " = " + res);
                    }
                    break;
                }
                case "-": {
                    if (pila.size() >= 2) {
                        String b = pila.pop();
                        String a = pila.pop();
                        String res = a.replaceAll("[" + b + "]", "");
                        pila.push(res);
                        System.out.println(a + " - " + b + " = " + res);
                    }
                    break;
                }
                case "@": {
                    if (!pila.isEmpty()) {
                        String a = pila.pop();
                        Stack<Character> aux = new Stack<>();
                        for (char c : a.toCharArray()) aux.push(c);
                        StringBuilder sb = new StringBuilder();
                        while (!aux.isEmpty()) sb.append(aux.pop());
                        String res = sb.toString();
                        pila.push(res);
                        System.out.println(a + " @ = " + res);
                    }
                    break;
                }
                case "*": {
                    if (pila.size() >= 2) {
                        String b = pila.pop();
                        String a = pila.pop();
                        StringBuilder sb = new StringBuilder();
                        for (char c : a.toCharArray()) {
                            if (b.indexOf(c) != -1 && sb.indexOf(String.valueOf(c)) == -1) {
                                sb.append(c);
                            }
                        }
                        String res = sb.toString();
                        pila.push(res);
                        System.out.println(a + " * " + b + " = " + res);
                    }
                    break;
                }
                case "/": {
                    System.out.println("Contenido de la pila:");
                    while (!pila.isEmpty()) {
                        System.out.println(pila.pop());
                    }
                    break;
                }
                default:
                    pila.push(token);
                    break;
            }
        }
        return pila;
    }

}