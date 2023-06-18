package org.example;
import java.io.FileReader;
import java.io.BufferedReader;

// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE
// этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде
// json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class HW2_1 {
    public static void main(String[] args) {
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("src/data1.json"));
            StringBuilder sb = new StringBuilder(bf.readLine());
            System.out.println(sb);
            sb.replace(0, 1, "");
            sb.replace(sb.length() - 1, sb.length(), "");
            System.out.println(sb);
            String s = sb.toString();
            // s = s.replace("{", "");
            // s = s.replace("}", "");
            s = s.trim();
            s = s.replace('"', ' ');
            s = s.replace(" ", "");
            // System.out.println(s);
            String[] lst = s.split(",");
            int i = 0;
            if (lst[i].contains("null")) i++;               // Если условие сработало, то идем дальше и ищем первое появления null
            System.out.printf("%s ", lst[i]);           // Если условие не сработало то выводим на экран первый элемент без null
            for (int j = i + 1; j < lst.length; j++) {      // После вывода на экран первого элемента выводим все остальное, что требуется
                if (lst[j].contains("null")) continue;      // Если строка содержит null то пропускаем цикл
                System.out.printf("and " + "%s ", lst[j]);      // Выводим на экран ответ через and
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                bf.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
