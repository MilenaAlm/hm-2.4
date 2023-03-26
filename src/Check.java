import java.util.Objects;

public class Check {
    private Check() {
    }
    public static boolean Check(String login, String password, String confirmPassword) {
        try {
            test(login, password, confirmPassword);
            return false;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private static void test (String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
            if (Objects.isNull(login) || login.length() > 20) {
                throw new WrongLoginException("Логин должен быть равен или меньше 20 символов");
            }
            if (Objects.isNull(password) || password.length() >= 20) {
                throw new WrongPasswordException ("Пароль должен быть строго меньше 20 символов");
            }
            if (!password.equals(confirmPassword)){
                throw new WrongPasswordException ("Пароли не совпадают!");
            }
            if (!writing(login, password)){
                throw new WrongLoginException("Введены некорректные символы");
        }
    }
    public static boolean writing (String login, String password){
        for (int i = 0; i < login.length(); i++) {
            char smb = login.charAt(i);
            if (!(smb == '_' || smb >= 'A' && smb <= 'Z' || smb >= 'a' && smb <= 'z' ||smb >= '0' && smb <= '9'))
                return false;
        }
        for (int i = 0; i < password.length(); i++) {
            char smb = login.charAt(i);
            if (!(smb == '_' || smb >= 'A' && smb <= 'Z' || smb >= 'a' && smb <= 'z' ||smb >= '0' && smb <= '9'))
                return false;
        }
        return true;
    }
}

