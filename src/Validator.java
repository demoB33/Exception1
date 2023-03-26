import java.util.Objects;

public class Validator {
    private Validator() {
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        //Для задания "Исключения обработаны в multi-catch block"
   /*     try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    */
    try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }


    public static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() >= 20) {
            throw new WrongLoginException("Длина логина меньше или равна 20!");
        }
        if (Objects.isNull(password) || password.length() > 20) {
            throw new WrongPasswordException("Длина пароля меньше 20!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать!");
        }
        if (!login.matches("^\\w+$")) {
            throw new WrongLoginException("Проверь символы в логине");
        }
        if (!password.matches("^\\w+$")) {
            throw new WrongPasswordException("Проверь символы в пароле");
        }
    }

}
