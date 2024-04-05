import java.util.NoSuchElementException;

public class LinkedList<T> extends List<T>{
    Element end;

    public Iterator<T> iterator() {
        return new Iterator<>(this);
    }
    private class Iterator<T> implements java.util.Iterator<T> {

        private int i;
        private Element<T> cur;

        public Iterator(LinkedList<T> list) {
            this.cur = list.head;
        }

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public T next() {
            try {
                Element<T> tmp = cur;
                i++;
                if (hasNext()) {
                    cur = cur.next;
                }
                return tmp.data;
            } catch (NoSuchElementException ex) {
                throw new NoSuchElementException(ex);
            }
        }

        @Override
        public void remove() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            if (cur.previous == null) {
                cur = cur.next;
            } else if (cur.next == null) {
                cur = cur.previous;
            } else {
                cur.previous.next = cur.next;
                cur.next = cur.previous.previous;
            }
        }
    }



    public void add(T data){
        Element<T> newElement = new Element<>(data);
        if (head == null){
            head = newElement;
            end = newElement;
        } else {
            Element<T> last = head;
            while (last.next != null) {
                last.next.previous = last;
                last = last.next;
            }
            last.next = newElement;
            newElement.previous = last;
            this.end = newElement;
        }
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
                newElement.previous = last;
                last.next = newElement;

            }
            else {
                newElement.next = last.next;
                last.next = newElement;
                newElement.previous = last;
                newElement.next.previous = newElement;
            }
        }
        end = newElement;
    }

    public void clear(){
        head = null;
        end = null;
    }

    public void removeByIndex(int index) {
        Element<T> currentElement = head;
        Element<T> lastElement = new Element<T>();

        for (int i = 0; i <= index; i++) {
            if (index == 0) {
                currentElement.next.previous = null;
                this.head = currentElement.next;
                break;
            }

            if ((currentElement.next == null)) {
                if (i != index) {
                    System.out.println("Index out of range");
                    break;
                } else {
                    end = lastElement;
                    lastElement.next = null;
                    break;
                }

            }
            else {
                if (i == index) {
                    currentElement.next.previous = lastElement;
                    lastElement.next = currentElement.next;
                    break;
                } else {
                    lastElement = currentElement;
                    currentElement = currentElement.next;
                }
            }

        }
    }
    public void removeByData(T data){
        removeByIndex(findByData(data));
    }


}
