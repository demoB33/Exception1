public class Main {
    public static void main(String[] args) {
        boolean input = Validator.validate("12343DFDFfd","_sldsdl1!","_sldsdl");
        if (input) {
            System.out.println("Регистрация прошла успешно!");
        } else {
            System.out.println("Не правильно введен логин и/или пароль");
        }

    }
}