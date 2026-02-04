public class AddCommand implements Command {
    private Folder parent;
    private FileSystemComponent component;

    public AddCommand(Folder parent, FileSystemComponent component) {
        this.parent = parent;
        this.component = component;
    }

    @Override
    public void execute() {
        parent.add(component);
        System.out.println("Додано: " + component.getName());
    }

    @Override
    public void undo() {
        parent.remove(component);
        System.out.println("Видалено: " + component.getName());
    }
}