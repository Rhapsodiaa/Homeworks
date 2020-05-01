package advancedJava;

public class ExceptionsHomework {
    public static void main(String[] args) throws ExceptionsHomework2.IncorrectNumberOfSigns, ExceptionsHomework2.IncorrectNumberOfSpecialSigns {
        System.out.println(checkPassword("Popr@wneHaslo"));
        System.out.println(checkPassword("M@z@duzoZnakowSpecjalnych"));
        System.out.println(checkPassword("DobradlugoscBezZnakuspecjalnego"));
    }

    /*Jeżeli chodzi o znaki specjalne, to możesz sprawdzić metody.
        Character.isJavaIdentifierPart(), Character.isDigit()*/
    static boolean checkPassword(String password) throws IllegalArgumentException, ExceptionsHomework2.IncorrectNumberOfSigns, ExceptionsHomework2.IncorrectNumberOfSpecialSigns {
        int upperLetterCounter = 0;
        int specialSignsCounter = 0;

        for(int i = 0; i < password.length() - 1; i++){
            Character specialSign = password.charAt(i);
            char dollar = '$';
            if(specialSign.isJavaIdentifierPart(dollar))
                specialSignsCounter += 1;
        }

        for (int i = 0; i < password.length() - 1; i++) {
            Character upperCase = password.charAt(i);
            if (upperCase.isUpperCase(upperCase)) {
                upperLetterCounter += 1;
            }
        }

        if(upperLetterCounter<1){
            throw new IllegalArgumentException("Haslo musi posiadać przynajmniej jeden znak specjalny!");
        }else if(password.length()<8){
            throw new ExceptionsHomework2.IncorrectNumberOfSigns("Haslo musi byc dluzsze niz 8 znakow!");
        }else if(specialSignsCounter<1){
            throw new ExceptionsHomework2.IncorrectNumberOfSpecialSigns("Haslo musi posiadać przynajmniej jedną wielką literę!");
        }
        return true;
    }

}
