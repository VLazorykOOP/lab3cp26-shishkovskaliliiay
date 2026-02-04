public class File extends FileSystemComponent {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void display(int indent) {
        System.out.println(getIndent(indent) + "[FILE] " + name + " (" + size + " KB)");
    }

    @Override
    public int getSize() {
        return size;
    }
}