package com.pb.mospan.hw8;

import java.util.regex.Pattern;

public class Auth {
    protected String login="";
    protected String password="";

    public Auth(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public Auth() {}

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    //Регистрация на сайте
    public void signUp (String login, String password, String confirmPassword)
            throws WrongLoginException {

        // проверяем логин
        if (Pattern.matches("[a-zA-Z0-9]{5,20}", login))
        { }
        else {throw new WrongLoginException ("Логин не соответствует правилам! Регистрация не прошла!");}

        // проверяем пароль
        if (Pattern.matches("\\w{5,}", password))
        {}
        else { throw new WrongLoginException("Пароль не соответствует правилам! Регистрация не прошла!");
               }
        // проверяем правильность повторного пароля
        if (password.equals(confirmPassword)) {}
        else {
            throw new WrongLoginException("Пароли не совпадают! Регистрация не прошла!");
                    }
         this.password = password;
         this.login = login;
        System.out.println("Вы успешно зарегистрировались на сайте:");
        System.out.println("Ваш логин: " + this.login);
        System.out.println("Ваш пароль: " + this.password);

    }

        //Вход на сайт
        public void signIn (String login, String password)
            throws WrongPasswordException  {
            // проверяем логин
            if (login.equals(this.login) && password.equals(this.password)) {
                System.out.println("Добро пожаловать на сайт!");;
            } else {
                throw new WrongPasswordException("Вы ввели неправильные данные! Вход на сайт не прошел!");
                }
            }
}