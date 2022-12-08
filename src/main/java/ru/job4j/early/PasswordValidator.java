package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
            return "OK";
/*        2. Добавить валидацию в метод validate(), применив принцип охранных выражений. Если password null, то выбросить исключение IllegalArgumentException с сообщением "Password can't be null";

        3. Учесть требования к паролю ниже. Если хотя бы одно из требований нарушается, то необходимо генерировать исключение IllegalArgumentException с соответствующим сообщением (в скобках будет указано какую строку-сообщение необходимо передавать в конструктор при генерации исключения):

        1) Длина пароля находится в диапазоне [8, 32] ("Password should be length [8, 32]");

        2) Пароль содержит хотя бы один символ в верхнем регистре ("Password should contain at least one uppercase letter");

        3) Пароль содержит хотя бы один символ в нижнем регистре ("Password should contain at least one lowercase letter");

        4) Пароль содержит хотя бы одну цифру ("Password should contain at least one figure");

        5) Пароль содержит хотя бы один спец. символ (не цифра и не буква) ("Password should contain at least one special symbol");

        6) Пароль не содержит подстрок без учета регистра: qwerty, 12345, password, admin, user. Без учета регистра, значит что, например, ни qwerty ни QWERTY ни qwErty и т.п. не должно быть в составе пароля ("Password shouldn't contain substrings: qwerty, 12345, password, admin, user").

                Для проверок использовать статические методы класса Character. */
    }

}
