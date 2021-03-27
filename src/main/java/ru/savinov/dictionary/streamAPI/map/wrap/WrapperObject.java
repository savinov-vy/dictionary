package ru.savinov.dictionary.streamAPI.map.wrap;

import ru.savinov.dictionary.streamAPI.map.wrap.InnerObject;

/**
 * This object make from InnerObject
 * Этот объект создается на основе InnerObject
 */
public class WrapperObject {
    private Long id;

    private String name;

    private String email;

    private Integer bill;

    public WrapperObject(InnerObject innerObject) {
        this.id = innerObject.getId();
        this.name = innerObject.getName();
        this.email = innerObject.getEmail();
        this.bill = innerObject.getBill();
    }

    @Override
    public String toString() {
        return "WrapperObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bill=" + bill +
                '}';
    }
}
