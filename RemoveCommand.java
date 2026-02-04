public class RemoveCommand implements Command {
    private Folder parent;
    private FileSystemComponent component;

    public RemoveCommand(Folder parent, FileSystemComponent component) {
        this.parent = parent;
        this.component = component;
    }

    @Override
    public void execute() {
        parent.remove(component);
        System.out.println("Видалено: " + component.getName());
    }

    @Override
    public void undo() {
        parent.add(component);
        System.out.println("Відновлено: " + component.getName());
    }
}