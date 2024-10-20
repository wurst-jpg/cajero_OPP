import java.util.Scanner;

public class CajeroAutomatico {
    private double saldo = 0;
    private Scanner scanner = new Scanner(System.in);
    private String usuario;

    public void iniciar() {
        System.out.println("Digite su nombre de usuario:");
        usuario = scanner.nextLine();

        if (deseaContinuar()) {
            mostrarMenu();
        } else {
            System.out.println("Gracias por usar el cajero " + usuario);
        }
    }

    private boolean deseaContinuar() {
        boolean respuestaValida = false;
        boolean continuar = false;

        while (!respuestaValida) {
            System.out.println("¿Quieres continuar? Escribe 'si' o 'no': ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                continuar = true;
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("no")) {
                respuestaValida = true;
            } else {
                System.out.println("Respuesta inválida. Escribe 'si' o 'no'.");
            }
        }
        return continuar;
    }

    private void mostrarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("---- MENÚ DE OPCIONES ----");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Cambiar clave");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    depositar();
                    break;
                case 3:
                    retirar();
                    break;
                case 4:
                    cambiarClave();
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Gracias por usar el cajero " + usuario);
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void consultarSaldo() {
        System.out.println("Tu saldo es: $" + saldo);
    }

    private void depositar() {
        System.out.println("¿Cuánto desea depositar?");
        double cantidadDeposito = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        boolean depositoCorrecto = false;
        while (!depositoCorrecto) {
            System.out.println("Su depósito será de $" + cantidadDeposito + ". ¿Esto es correcto? (si/no)");
            String confirmacion = scanner.nextLine();

            if (confirmacion.equalsIgnoreCase("si")) {
                saldo += cantidadDeposito;
                System.out.println("Fondos depositados correctamente.");
                depositoCorrecto = true;
            } else if (confirmacion.equalsIgnoreCase("no")) {
                System.out.println("Depósito cancelado.");
                depositoCorrecto = true;
            } else {
                System.out.println("Responda únicamente 'si' o 'no'.");
            }
        }
    }

    private void retirar() {
        System.out.println("¿Cuánto desea retirar?");
        double cantidadRetiro = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        if (saldo >= cantidadRetiro) {
            saldo -= cantidadRetiro;
            System.out.println("Retiro exitoso. Ha retirado $" + cantidadRetiro);
        } else {
            System.out.println("Saldo insuficiente. Vuelva a intentarlo.");
        }
    }

    private void cambiarClave() {
        System.out.println("Funcionalidad de cambio de clave aún no implementada.");
    }
}
