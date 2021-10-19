package anna.studio;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkFiles {
    public void workFiles() throws IOException {
        File directory = new File("D:\\");
        File file = new File(directory, "FileTest.txt");
        file.createNewFile();

        if (file.exists()) {
            System.out.println("Имя файла: " + file.getName());
            System.out.println("Полный путь: " + file.getAbsolutePath());
            System.out.println("Родительский каталог: " + file.getParent());
            System.out.println("Права на запись в файл: " + (file.canWrite() ?
                    "доступ есть" :
                    "доступ запрещен"));
            System.out.println("Права на чтение из файла: " + (file.canRead() ?
                    "доступ есть" :
                    "доступ запрещен"));
            System.out.println("Размер файла: " + file.length() + " bytes");

            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
            System.out.println("Последняя модификация :\t" + dateFormat.format(new Date(file.lastModified())));

            System.out.println(getCount(directory.toString()));
            getListFile(directory.toString());
        }
    }

    public static int getCount(String path) {
        int count = 0;
        File file = new File(path);
        File[] s = file.listFiles();
        for (int j = 0; j < s.length; j++) {
            count++;
        }
        return count;
    }

    public static void getListFile(String directory) {
        File file = new File(directory);
        String[] files = file.list();
        for (String fileName : files) {
            System.out.println(fileName);
        }
    }
}
