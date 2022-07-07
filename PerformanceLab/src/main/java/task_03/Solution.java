package task_03;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static final String RED_BOLD = "\u001B[31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String CYAN_BOLD = "\033[1;36m";
    public static final String RESET = "\033[0m";

    public static String file_1 = "C:\\Users\\AlRezn\\Documents\\JAVA\\Projects\\InterviewTests\\PerformanceLab\\src\\main\\resources\\tests.json";
    public static String file_2 = "C:\\Users\\AlRezn\\Documents\\JAVA\\Projects\\InterviewTests\\PerformanceLab\\src\\main\\resources\\values.json";

    public static void main(String[] args) throws IOException, JAXBException {
        ObjectMapper objectMapper_1 = new ObjectMapper();
        SomeClass someClass = objectMapper_1.readValue(new File(file_1), SomeClass.class);
        ObjectMapper objectMapper_2 = new ObjectMapper();
        Values valuesClass = objectMapper_2.readValue(new File(file_2), Values.class);

        for (SomeClass sc : someClass.tests) {
            if (sc.value.equals("")) {
                for (Values val : valuesClass.values) {
                    if (val.id == sc.id) {
                        sc.value = val.value;
                        if (val.value.equals("failed")) {
                            System.out.println(RED_BOLD + "id: " + sc.id + " | title: " + sc.title + " | volue: " + sc.value + RESET);
                        } else if (val.value.equals("passed")) {
                            System.out.println(GREEN_BOLD + "id: " + sc.id + " | title: " + sc.title + " | volue: " + sc.value + RESET);
                        }
                    }
                }
            } else {
                System.out.println(CYAN_BOLD + "New Array: id: " + sc.id + " | title: " + sc.title + RESET);
            }
            if (sc.values != null) {
                enumerationOfFiles(sc, valuesClass);
            }
        }

        StringWriter stringWriter = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(stringWriter, someClass);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(someClass));


        Files.write(Paths.get("C:\\Users\\AlRezn\\Documents\\JAVA\\Projects\\InterviewTests\\PerformanceLab\\src\\main\\resources\\report.json"),
                mapper.writerWithDefaultPrettyPrinter().writeValueAsString(someClass).getBytes(StandardCharsets.UTF_8));
    }

    public static void enumerationOfFiles(SomeClass sc, Values val) {
        for (int i = 0; i < sc.values.size(); i++) {
            if (sc.values.get(i).value != null) {
                for (Values values : val.values) {
                    if (values.id == sc.values.get(i).id) {
                        sc.values.get(i).value = values.value;
                        if (values.value.equals("failed")) {
                            System.out.println(RED_BOLD + "id: " + sc.values.get(i).id + " | title: " + sc.values.get(i).title + " | volue: " + sc.values.get(i).value + RESET);
                        } else if (values.value.equals("passed")) {
                            System.out.println(GREEN_BOLD + "id: " + sc.values.get(i).id + " | title: " + sc.values.get(i).title + " | volue: " + sc.values.get(i).value + RESET);
                        }
                    }
                }
            } else {
                System.out.println(CYAN_BOLD + "new Array: id: " + sc.values.get(i).id + " | title: " + sc.values.get(i).title + RESET);
            }
            if (sc.values.get(i).values != null) {
                enumerationOfFiles(sc.values.get(i), val);
            }
        }
    }
}
