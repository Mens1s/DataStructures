public class DynamicArray {

    private int size;
    private int capacity = 10;
    private Object [] array;

    public DynamicArray() {
        this.array = new Object[capacity];
    }

    public DynamicArray(int capacity) {
        if(capacity < 1) capacity = 1;

        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public void add(Object data){
        if(size >= capacity) {
            grow();
        }
        array[size++] = data;
    }
    public void insert(int index, Object data) {
        if(size  >= capacity) {
            grow();
        }

        for(int i = size; i > index; i--)
            array[i] = array[i -1];

        array[index] = data;
        size++;
    }
    public void delete(Object data){
        for(int i = 0 ; i < size; i++){

            if(array[i] == data) {

                for(int j = 0; j < size - i - 1 ;j++)
                    array[i+j] = array[i+j+1];

                array[size - 1] = null;
                size--;

                if(size <= (int) capacity / 2)
                    shrink();

                // break; // if there are duplicates, it will delete only the first one
            }

        }
    }

    public int search(Object data){
        for(int i = 0; i < size; i++)
            if(array[i] == data)
                return i;
        return -1;
    }

    private void grow(){
        capacity *= 2;
        Object [] temp = new Object[capacity];

        for(int i = 0; i < size; i++)
            temp[i] = array[i];

        array = temp;
    }

    private void shrink(){
        capacity /= 2;
        Object [] temp = new Object[capacity];

        for(int i = 0; i < size; i++)
            temp[i] = array[i];

        array = temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        String string = "";

        for(int i = 0; i < size; i++)
            string += array[i] + ", ";

        if(string != "")
            return "[" + string.substring(0, string.length() - 2) + "]";

        return "[]";
    }
}
