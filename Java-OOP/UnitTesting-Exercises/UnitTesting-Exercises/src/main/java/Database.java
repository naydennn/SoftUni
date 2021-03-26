import javax.naming.OperationNotSupportedException;

public class Database {

    private Integer[] data;
    private int index;

    public Database(Integer... data) throws OperationNotSupportedException {
        this.index = 0;
        this.data = new Integer[data.length];
        setData(data);
    }

    public void setData(Integer[] data) throws OperationNotSupportedException {
        if (data.length > 16 || data.length < 1) {
            throw new OperationNotSupportedException();
        }
        this.data = new Integer[16];
        for (Integer integer : data) {
            this.data[this.index] = integer;
            this.index++;
        }
    }

    public void add(Integer element) throws OperationNotSupportedException {
        if (element == null || index + 1 >= 16) {
            throw new OperationNotSupportedException();
        }
        this.data[index] = element;
        index++;
    }
    public void remove() throws OperationNotSupportedException {
        try {
            index--;
            this.data[index] = null;
        } catch (IndexOutOfBoundsException ignored) {
            throw new OperationNotSupportedException();
        }
    }
    public Integer[] fetch() {
        Integer[] bufferArr = new Integer[index];

        int index = 0;
        for (Integer element : this.data) {
            if (element != null) {
                bufferArr[index] = element;
                index++;
            }
        }
        return bufferArr;
    }

    public int getElement(int index) {
        return this.data[index];
    }

    public int getIndex() {
        return index;
    }
}
