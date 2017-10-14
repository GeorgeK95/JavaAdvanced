import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SerializeArrayList {
    private static final String path = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\serialized.ser";

    public static void main(String[] args) {
        List<Double> doubles = Arrays.asList(3.14, 7.55, 6.00);
        serialize(doubles);
        deserialize();
    }

    private static void deserialize() {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object deserialized = ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void serialize(List<Double> doubles) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(doubles);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
