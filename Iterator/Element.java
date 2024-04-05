public class Element<T> {
    T data;
    Element next;
    Element previous;

    public Element(T data) {
        this.data = data;
    }
    public Element() {
    }
    public void printElement(){
        System.out.println(data);
    }
}
