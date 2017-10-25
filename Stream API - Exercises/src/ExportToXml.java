import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ExportToXml {
    private static String PATH = "C:\\Users\\George-Lenovo\\Desktop\\";
    private static String DATA = "E:\\SOFTUNI\\Java Advanced - септември 2017\\07. Java-Advanced-Stream-API-Exercises\\StudentData.txt";
    private static final String SHEEET_NAME = "Student Data";

    public static void main(String[] args) throws IOException {
        writeInExcelFile();
    }

    private static void writeInExcelFile() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(SHEEET_NAME);
        Map<String, Object[]> data = generateData();
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File(PATH + "Student_Data.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println(SHEEET_NAME + ".xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Object[]> generateData() throws IOException {
        Map<String, Object[]> data = new TreeMap<>();
        readDataInMap(data);
        return data;
    }

    private static void readDataInMap(Map<String, Object[]> data) throws IOException {
        Object[] columns = readColumns();
        int index = 1;
        data.put(String.valueOf(index), columns);
        index++;
        try (BufferedReader br = new BufferedReader(new FileReader(DATA))) {
            br.readLine();
            for (String line; (line = br.readLine()) != null; ) {
                String[] currentLine = line.split("\\s+");
                String fn = currentLine[0];
                String firstName = currentLine[1];
                String lastName = currentLine[2];
                String email = currentLine[3];
                int age = Integer.parseInt(currentLine[4]);
                int group = Integer.parseInt(currentLine[5]);
                List<Integer> grades = getGrades(Arrays.copyOfRange(currentLine, 6, 10));
                String phone = currentLine[10];
                List<Object> filledObjectList = new ArrayList<Object>() {{
                    add(fn);
                    add(firstName);
                    add(lastName);
                    add(email);
                    add(age);
                    add(group);
                }};
                for (Integer grade : grades) {
                    filledObjectList.add(grade);
                }
                filledObjectList.add(phone);
                data.put(String.valueOf(index), filledObjectList.toArray());
                index++;
            }
        }
    }

    private static List<Integer> getGrades(String[] strings) {
        List<Integer> grades = new ArrayList<>();
        for (String string : strings) {
            grades.add(Integer.parseInt(string));
        }
        return grades;
    }

    private static Object[] readColumns() throws IOException {
        BufferedReader brTest = new BufferedReader(new FileReader(DATA));
        String[] firstLine = brTest.readLine().split("\t");
        brTest.close();
        Object[] columns = new Object[firstLine.length];

        int index = 0;
        for (String currentElement : firstLine) {
            columns[index] = currentElement;
            index++;
        }
        return columns;
    }
}
