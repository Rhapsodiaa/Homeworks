package advancedJava;

public class ExceptionsHomework {
    public static void main(String[] args) {
        System.out.println(checkPassword("Popr@wneHaslo"));
        System.out.println(checkPassword("M@z@duzoZnakowSpecjalnych"));
        System.out.println(checkPassword("maosiemliteraleniemawielkiejlitery"));
    }

    /*Jeżeli chodzi o znaki specjalne, to możesz sprawdzić metody.
        Character.isJavaIdentifierPart(), Character.isDigit()*/
    static boolean checkPassword(String password) throws IllegalArgumentException {
        int upperLetterCounter = 0;

        for (int i = 0; i < password.length() - 1; i++) {
            Character upperCase = password.charAt(i);
            if (upperCase.isUpperCase(upperCase))
                upperLetterCounter += 1;
        }
        if(password.length()<8||upperLetterCounter<1){
            throw new IllegalArgumentException("Haslo musi byc dluzsze niz 8 znakow, posiadać przynajmniej jeden znak specjalny oraz przynajmniej jedną wielką literę!");
        }

        return true;
    }

}
