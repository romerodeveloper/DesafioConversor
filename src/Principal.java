import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        boolean salir = true;

        while (salir) {
            Scanner lectura = new Scanner(System.in);
            System.out.println("*********************************************************");
            System.out.println("Sea bienvenido/a al conversor de Moneda =]");

            System.out.println("1) Dolar =>> Peso argentido");
            System.out.println("2) Peso argentino =>> Dolar");
            System.out.println("3) Dolar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dolar");
            System.out.println("5) Dolar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dolar");
            System.out.println("7) Salir");
            System.out.println("Elija una opcion valida: ");
            System.out.println("*********************************************************");

            String opcion = lectura.nextLine();
            String unidadBuscada = "";
            String unidadConvertida = "";
            switch (opcion) {
                case "1":
                    unidadBuscada = "USD";
                    unidadConvertida = "ARS";
                    break;
                case "2":
                    unidadBuscada = "ARS";
                    unidadConvertida = "USD";
                    break;
                case "3":
                    unidadBuscada = "USD";
                    unidadConvertida = "BRL";
                    break;
                case "4":
                    unidadBuscada = "BRL";
                    unidadConvertida = "USD";
                    break;
                case "5":
                    unidadBuscada = "USD";
                    unidadConvertida = "COP";
                    break;
                case "6":
                    unidadBuscada = "COP";
                    unidadConvertida = "USD";
                    break;
                case "7":
                    System.out.println("Haz salido del conversor");
                    salir = false;
                    break;
                default:
                    System.out.println("Opcion invalida");

            }

            if (unidadBuscada != "" && unidadConvertida != ""){
                ConsultaMoneda respuestaConversion = new ConsultaMoneda();
                double multiplo = respuestaConversion.Conversion(unidadBuscada, unidadConvertida);
                System.out.println("Ingrese el valor que desea convertir");
                double veces = lectura.nextInt();
                double resultado = veces * multiplo;
                System.out.println("El valor de "+ veces + "[" +unidadBuscada+ "]" + " corresponde al valor final de ===>>"+ resultado + "[" +unidadConvertida+ "]");
            }
        }
    }
}
