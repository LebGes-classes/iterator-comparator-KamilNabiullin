package Iterator;

public abstract class List<T> implements iList<T>{

    protected Element<T> head;
    int size;
    public List() {
        this.size = 0;
    }



    public void add(T data){
        Element<T> newElement = new Element<T>(data);
        if (head == null){
            head = newElement;
        } else {
            Element last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newElement;
        }
        this.size ++;
    }
    public void add(T data, int index){
        Element<T> newElement = new Element<T>(data);
        Element<T> last = head;
        if (index == 0){
            head = newElement;
            head.next = last;
        }
        else {
            for (int i = 0; i< index - 1; i++){
                last = last.next;
            }
            if (last.next == null){
                last.next = newElement;
            }
            else {
                newElement.next = last.next;
                last.next = newElement;
            }
        }
        this.size ++;
    }

    public void clear(){
        head = null;
        this.size = 0;
    }
    public Object findByIndex(int index){
        Element<T> last = head;
        for (int i = 0; i <= index; i++){
            if (last.next == null){
                if (i == index){
                    return last.data;
                } else {
                    System.out.println("Index out of range");
                    break;
                }
            } else {
                if (i == index){
                    return last.data;
                } else {
                    last = last.next;
                }
            }
        }
        return new Object[0];

    }
    public int findByData(T data){
        Element<T> last = head;
        int index = 0;
        while (last.next != null){
            last = last.next;
            index++;
            if (last.data == data){
                return index;
            }
        }
        return -1;
    }
    public void removeByIndex(int index){
        Element<T> currentElement = head;
        Element<T> lastElement = new Element();

        for (int i = 0; i <= index; i++){
            if (index == 0){
                this.head = currentElement.next;
                this.size --;
                break;
            }
            if ((currentElement.next == null) & (i != index)){
                System.out.println("Index out of range");
                break;
            }
            if (i == index){
                lastElement.next = currentElement.next;
                this.size --;
                break;
            } else {
                lastElement = currentElement;
                currentElement = currentElement.next;
            }
        }

    }

    public void removeByData(T data) {
        removeByIndex(findByData(data));

    }

    public void printList(){
        Element<T> last = this.head;
        while (last != null){
            System.out.print(last.data + " ");
            last = last.next;
        }
        System.out.println();
    }
}
