package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
// Дополнительное задание
// Дана json-строка(можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//         Написать метод(ы),который распарсит json и, используя StringBuilder, создаст строки вида:
//         Студент[фамилия]получил[оценка]по предмету[предмет]
//         .Пример вывода: Студент Иванов получил 5 по предмету Математика. Студент Петрова получил 4 по предмету Информатика. Студент Краснов получил 5 по предмету Физика.
//         Сравнить время выполнения замены символа"а"на"А"любой строки содержащей>1000 символов средствами String и StringBuilder.
public class HW2_2 {
    public static void main(String[] args) {
        String file = "data2.json";
        printData(file);
    }
    public static void printData(String data) {
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(data));
            StringBuilder sb = new StringBuilder(bf.readLine());
            sb.replace(0, 1, "");
            sb.replace(sb.length() - 1, sb.length(), "");
            System.out.println(sb);
            String s = sb.toString();
            s = s.replace("{", "");
            s = s.replace("}", "");
            // s = s.replace(":", ",");
            s = s.replace('"', ' ');
            s = s.replace(" ", "");
            s = s.trim();
            System.out.println(s);
            String[] keys = s.split(",");
            String[][] words = new String[keys.length][keys.length / 2];
            // String[] words = new String[keys.length * 2];
            for (int i = 0; i < keys.length; i++) {
                words[i] = keys[i].split(":");
            }
            for (int i = 0; i < keys.length; i++) {
                System.out.printf("Студент %s получил %s по предмету %s \n", words[i][1], words[i + 1][1], words[i + 2][1]);
                i += keys.length / 3 - 1;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bf.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
