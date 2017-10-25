import java.io.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SerializeCustomObject {
    private static final String path = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\course.ser";
    private static final int STUDENTSCOUNT = 200;

    public static void main(String[] args) {
        Course course = new Course("Java Advanced - september 2017", STUDENTSCOUNT);
        serialize(course);
        deserialize();
    }

    private static void deserialize() {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object deserialized = ois.readObject();
            System.out.println(deserialized);
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void serialize(Course course) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(course);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Course implements Serializable{
    private String name;
    private int studentsCount;

    Course(String name, int studentsCount) {
        this.setName(name);
        this.setStudentsCount(studentsCount);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", studentsCount=" + studentsCount +
                '}';
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getStudentsCount() {
        return studentsCount;
    }

    private void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }
}