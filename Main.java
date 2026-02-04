public class Main {
    public static void main(String[] args) {
        System.out.println("Демонстрація патернів: Singleton, Composite, Command ===");
        System.out.println("Файловий менеджер\n");

        FileManager manager = FileManager.getInstance();
        Folder root = manager.getRoot();

        Folder documents = new Folder("Documents");
        Folder images = new Folder("Images");
        Folder projects = new Folder("Projects");

        File readme = new File("readme.txt", 10);
        File report = new File("report.docx", 250);
        File photo1 = new File("photo1.jpg", 1500);
        File photo2 = new File("photo2.png", 2000);
        File code = new File("Main.java", 5);

        System.out.println("--- Виконання команд ---");

        manager.executeCommand(new AddCommand(root, documents));
        manager.executeCommand(new AddCommand(root, images));
        manager.executeCommand(new AddCommand(documents, readme));
        manager.executeCommand(new AddCommand(documents, report));
        manager.executeCommand(new AddCommand(documents, projects));
        manager.executeCommand(new AddCommand(projects, code));
        manager.executeCommand(new AddCommand(images, photo1));
        manager.executeCommand(new AddCommand(images, photo2));

        manager.displayFileSystem();

        // Демонстрація undo 
        System.out.println("--- Скасування останніх операцій ---");
        manager.undo();
        manager.undo();

        manager.displayFileSystem();

        // Перевірка Singleton 
        System.out.println("--- Перевірка Singleton ---");
        FileManager manager2 = FileManager.getInstance();
        System.out.println("manager == manager2: " + (manager == manager2));

        // Демонстрація RemoveCommand 
        System.out.println("\n--- Видалення папки Projects ---");
        manager.executeCommand(new RemoveCommand(documents, projects));
        manager.displayFileSystem();

        System.out.println("--- Скасування видалення ---");
        manager.undo();
        manager.displayFileSystem();
    }
} 