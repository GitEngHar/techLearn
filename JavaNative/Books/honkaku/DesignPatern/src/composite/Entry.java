package composite;

public interface Entry {
    void add(Entry entry);
    void remove();
    void rename(String name);
}
