package ru.regulartech.officeObjects;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.04.2014
 * TIME: 21:56
 */
public interface baseActions {
    void changeRoom();

    void changeStatus(Integer status);
    void setOfficeObjectStatusId(Integer status);

    Integer getOfficeObjectStatusId();

    void setFixed();
}
