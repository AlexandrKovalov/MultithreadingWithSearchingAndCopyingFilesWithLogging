import FilesCopying.CopyWithApache;
import FilesSearching.SearchFiles;
import interfaces.CopyFileTask;
import interfaces.FindFilesTask;
import interfaces.TaskExecutor;
import interfaces.TasksStorage;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        CopyFileTask task1 = new CopyFileTaskImpl("E:\\IdeaCEProjectd\\Lesson32\\test\\image.bmp",
                "copy\\Task1.bmp", 1);
        CopyFileTask task2 = new CopyFileTaskImpl("E:\\IdeaCEProjectd\\Lesson32\\test\\image.bmp",
                "copy\\Task2.bmp", 2);
        CopyFileTask task3 = new CopyFileTaskImpl("E:\\IdeaCEProjectd\\Lesson32\\test\\image.bmp",
                "copy\\Task3.bmp", 3);
        CopyFileTask task4 = new CopyFileTaskImpl("E:\\IdeaCEProjectd\\Lesson32\\test\\image.bmp",
                "copy\\Task4.bmp", 4);
        CopyFileTask task5 = new CopyFileTaskImpl("E:\\IdeaCEProjectd\\Lesson32\\test\\image.bmp",
                "copy\\Task5.bmp", 5);


        FindFilesTask task6 = new FindFilesTaskImpl(new PrintStream("Результаты поиска.txt"),
                "E:\\IdeaCEProjectd\\Lesson32\\test", "a", 6 );
        FindFilesTask task7 = new FindFilesTaskImpl(new PrintStream("Результаты поиска2.txt"),
                "E:\\IdeaCEProjectd\\Lesson32\\test", "a", 7 );
        FindFilesTask task8 = new FindFilesTaskImpl(new PrintStream("Результаты поиска3.txt"),
                "E:\\IdeaCEProjectd\\Lesson32\\test", "a", 8 );
        FindFilesTask task9 = new FindFilesTaskImpl(new PrintStream("Результаты поиска4.txt"),
                "E:\\IdeaCEProjectd\\Lesson32\\test", "a", 9 );
        FindFilesTask task10 = new FindFilesTaskImpl(new PrintStream("Результаты поиска5.txt"),
                "E:\\IdeaCEProjectd\\Lesson32\\test", "b", 10 );

        task1.setFileCopyUtils(new CopyWithApache());
        task2.setFileCopyUtils(new CopyWithApache());
        task3.setFileCopyUtils(new CopyWithApache());
        task4.setFileCopyUtils(new CopyWithApache());
        task5.setFileCopyUtils(new CopyWithApache());


        task6.setSearchUtils(new SearchFiles());
        task7.setSearchUtils(new SearchFiles());
        task8.setSearchUtils(new SearchFiles());
        task9.setSearchUtils(new SearchFiles());
        task10.setSearchUtils(new SearchFiles());


        TasksStorage storage = new TasksStorageImpl();
        storage.add(task1);
        storage.add(task2);
        storage.add(task3);
        storage.add(task4);
        storage.add(task5);
        storage.add(task6);
        storage.add(task7);
        storage.add(task8);
        storage.add(task9);
        storage.add(task10);

        TaskExecutor executor1 = new TaskExecutorImpl();
        TaskExecutor executor2 = new TaskExecutorImpl();
        TaskExecutor executor3 = new TaskExecutorImpl();

        executor1.setStorage(storage);
        executor2.setStorage(storage);
        executor3.setStorage(storage);

        executor1.start();
        executor2.start();
        executor3.start();
    }
}
