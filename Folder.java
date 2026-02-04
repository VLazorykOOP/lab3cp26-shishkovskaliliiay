import java.util.ArrayList;
import java.util.List;

// Composite Pattern - Composite 
public class Folder extends FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    public List<FileSystemComponent> getChildren() {
        return children;
    }

    @Override
    public void display(int indent) {
        System.out.println(getIndent(indent) + "[FOLDER] " + name + " (" + getSize() + " KB)");
        for (FileSystemComponent component : children) {
            component.display(indent + 1);
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
} 