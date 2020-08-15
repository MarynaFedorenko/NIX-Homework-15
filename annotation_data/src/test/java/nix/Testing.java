package nix;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class Testing {


    private AppProperties init(){
        AppProperties appProps = new AppProperties();
        try {
            FileInputStream input = new FileInputStream("src/main/resources/app.properties");
            Properties property = new Properties();
            property.load(input);
            new Initializer<>(appProps).init(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appProps;


    }

    @Test
    public void tests(){
        AppProperties appProps = init();
        assertEquals("Ford", appProps.brand);
        assertEquals("Mustang", appProps.model);
        assertEquals("convertible", appProps.car_body);
        assertEquals(2018, appProps.year);
        assertEquals(2.3, appProps.gas_tank_capacity);
        assertEquals(30000000000L, appProps.price);
        assertFalse(appProps.drive);

    }
}
