package Examen;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author hulkiniano
 */
public class TresEnRaya {

    public static void main(String[] args) {
        int j;
        String nuevo;
        Scanner sc = new Scanner(System.in);
        String[][] tabla = new String[3][3];
        do {
            System.out.println("Jugando al 3 en raya:");
            System.out.println("----------------------------------------------------");
            rellenarTablas(tabla);
            mostrarTabla(tabla);
            do {
                j = 1;
                jugador1(sc, tabla, j);
                if (tresRaya(tabla) == false && empate(tabla) == false) {
                    j = 2;
                    jugador2(sc, tabla, j);
                }
            } while (tresRaya(tabla) == false && empate(tabla) == false);
            if (tresRaya(tabla) == true) {
                System.out.println("Enhorabuena, ha ganado el jugador " + j);
                System.out.println("----------------------------------------------------");
            } else if (empate(tabla) == true) {
                System.out.println("Ha habido un empate");
                System.out.println("----------------------------------------------------");
            }
            sc.nextLine();
            do {
                System.out.print("¿Quieres jugar de nuevo?(Si/No): ");
                nuevo = sc.nextLine();
                if (!(nuevo.equalsIgnoreCase("Si") || nuevo.equalsIgnoreCase("No"))) {
                    System.out.println("Error, selecciona una opción correcta.");
                }
            } while (!(nuevo.equalsIgnoreCase("Si") || nuevo.equalsIgnoreCase("No")));
        } while (nuevo.equalsIgnoreCase("Si"));
        System.out.println("Buena partida");
    }

    public static void rellenarTablas(String[][] tabla) {
        for (int fila = 0; fila < tabla.length; fila++) {
            for (int columna = 0; columna < tabla[fila].length; columna++) {
                tabla[fila][columna] = "*";
            }
        }
    }

    public static void jugador1(Scanner sc, String[][] tabla, int j) {
        int fila, columna;
        System.out.println("----------------------------------------------------");
        System.out.println("Turno para el jugador " + j + ":");
        do {
            do {
                System.out.print("Dime el número de la fila: ");
                fila = (sc.nextInt() - 1);
                System.out.print("Ahora dime el numero de la columna: ");
                columna = (sc.nextInt() - 1);
                if (fila > 3 || fila < 0 || columna < 0 || columna > 3) {
                    System.out.println("Has introducido valores incorrectos");
                }
            } while (fila > 3 || fila < 0 || columna < 0 || columna > 3);
            if (tabla[fila][columna] == "X" || tabla[fila][columna] == "O") {
                System.out.println("Error, fila ya escogida");
            }
        } while (tabla[fila][columna] == "X" || tabla[fila][columna] == "O");
        tabla[fila][columna] = "O";
        mostrarTabla(tabla);
    }

    public static void jugador2(Scanner sc, String[][] tabla, int j) {
        int fila, columna;
        System.out.println("----------------------------------------------------");
        System.out.println("Turno para el jugador " + j + ":");
        do {
            do {
                System.out.print("Dime el número de la fila: ");
                fila = (sc.nextInt() - 1);
                System.out.print("Ahora dime el numero de la columna: ");
                columna = (sc.nextInt() - 1);
                if (fila > 3 || fila < 0 || columna < 0 || columna > 3) {
                    System.out.println("Has introducido valores incorrectos");
                }
            } while (fila > 3 || fila < 0 || columna < 0 || columna > 3);
            if (tabla[fila][columna] == "O" || tabla[fila][columna] == "X") {
                System.out.println("Error, fila ya escogida");
            }
        } while (tabla[fila][columna] == "O" || tabla[fila][columna] == "X");
        tabla[fila][columna] = "X";
        mostrarTabla(tabla);

    }

    public static void mostrarTabla(String[][] tabla) {
        for (int fila = 0; fila < tabla.length; fila++) {
            for (int columna = 0; columna < tabla[fila].length; columna++) {
                System.out.print(tabla[fila][columna] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean empate(String[][] tabla) {
        boolean empate = false;
        String guardar = "";
        for (int fila = 0; fila < tabla.length; fila++) {
            for (int columna = 0; columna < tabla[fila].length; columna++) {
                guardar = guardar + tabla[fila][columna];
            }
        }
        if (!(guardar.contains("*"))) {
            empate = true;
        }
        return empate;
    }

    public static boolean tresRaya(String[][] tabla) {
        boolean validar = false;
        if (tabla[0][0] == tabla[0][1] && tabla[0][1] == tabla[0][2] && tabla[0][2] != "*") {
            validar = true;
        } else if (tabla[1][0] == tabla[1][1] && tabla[1][1] == tabla[1][2] && tabla[1][2] != "*") {
            validar = true;
        } else if (tabla[2][0] == tabla[2][1] && tabla[2][1] == tabla[2][2] && tabla[2][2] != "*") {
            validar = true;
        } else if (tabla[0][0] == tabla[1][0] && tabla[1][0] == tabla[2][0] && tabla[2][0] != "*") {
            validar = true;
        } else if (tabla[0][1] == tabla[1][1] && tabla[1][1] == tabla[2][1] && tabla[2][1] != "*") {
            validar = true;
        } else if (tabla[0][2] == tabla[1][2] && tabla[1][2] == tabla[2][2] && tabla[2][2] != "*") {
            validar = true;
        } else if (tabla[0][2] == tabla[1][1] && tabla[1][1] == tabla[2][0] && tabla[2][0] != "*") {
            validar = true;
        } else if (tabla[0][2] == tabla[1][1] && tabla[1][1] == tabla[2][0] && tabla[2][0] != "*") {
            validar = true;
        }
        return validar;
    }
}
