package ru.savinov.dictionary.backend.streamAPI.map.wrap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * здесь создается список InnerObject
 * и при помощи метода map преобразуется в WrapperObject
 */
public class MainClassTransformation {
    public static void main(String[] args) {
        List<InnerObject> list = new ArrayList<>();
        list.add(new InnerObject(1L, "qwewr1", "m@m.ru", 1000));
        list.add(new InnerObject(2l, "qwewr2", "m@m.ru", 2000));
        list.add(new InnerObject(3L, "qwewr3", "m@m.ru", 3000));
        list.add(new InnerObject(4L, "qwewr4", "m@m.ru", 4000));

        List<WrapperObject> listWrappers = list.stream().map(WrapperObject::new).collect(Collectors.toList());

        System.out.println(listWrappers);
    }

}
