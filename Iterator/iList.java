public interface iList<T> {
    void add(T data);
    void removeByIndex(int index);
    void removeByData(T data);
    void clear();
    Object findByIndex(int index);
    int findByData(T data);
}
