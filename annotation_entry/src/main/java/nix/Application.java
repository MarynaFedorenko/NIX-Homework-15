package nix;

import org.jetbrains.annotations.PropertyKey;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Application {



    public static void main(String[] args) {
        AppProperties appProps = new AppProperties();
        try {
            FileInputStream input = new FileInputStream("annotation_data/src/main/resources/app.properties");
            Properties property = new Properties();
            property.load(input);
            new Initializer<>(appProps).init(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        appProps.print();
    }
}