package nix;

import nix.annotation.PropertyKey;

import java.lang.reflect.Field;
import java.util.Properties;

public class Initializer <T> {
    private  final T object;

    public Initializer(T object) {
        this.object = object;
    }


    public void init(Properties props) {
        Object instance = new AppProperties();

        Class<?> classOfInstance = instance.getClass();

        for(Field field : classOfInstance.getFields()){
            field.setAccessible(true);
            String property;
                PropertyKey key = field.getAnnotation(PropertyKey.class);
                if (key == null) continue;
                property = props.getProperty(key.value());
                if (property == null) continue;

                String type = field.getType().getName();


            try {
                if (int.class.getName().equals(type)) {
                    field.setInt(object, Integer.parseInt(property));
                } else if (long.class.getName().equals(type)) {
                    field.setLong(object, Long.parseLong(property));
                } else if (double.class.getName().equals(type)) {
                    field.setDouble(object, Double.parseDouble(property));
                } else if (boolean.class.getName().equals(type)) {
                    field.setBoolean(object, Boolean.parseBoolean(property));
                } else if (String.class.getName().equals(type)) {
                    field.set(object, property);
                }
                else {
                    System.out.println("This type is not provided!");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

}
