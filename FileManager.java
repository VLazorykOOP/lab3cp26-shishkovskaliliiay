import java.util.Stack;

// Singleton Pattern 
public class FileManager {
    private static FileManager instance;
    private Folder root;
    private Stack<Command> commandHistory = new Stack<>();

    private FileManager() {
        root = new Folder("root");
    }

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public Folder getRoot() {
        return root;
    }

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
            System.out.println("Операція скасована");
        } else {
            System.out.println("Немає операцій для скасування");
        }
    }

    public void displayFileSystem() {
        System.out.println("\n=== Файлова система ===");
        root.display(0);
        System.out.println();
    }
} 