package listIterator;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class ListIterator {

    private List<String> data;
    private int index;

    public ListIterator(String... data) throws OperationNotSupportedException {
        setData(data);
        this.index = 0;
    }

    private void setData(String[] data) throws OperationNotSupportedException {
        if (data == null || data.length < 1) {
            throw new OperationNotSupportedException();
        }
        this.data = new ArrayList<>();
        for (String str : data) {
            if (str != null) {
                this.data.add(str);
            }
        }
    }

    public boolean move() throws OperationNotSupportedException {

        if (this.data.isEmpty() || this.index >= data.size()) {
            throw new OperationNotSupportedException();
        }
        this.index++;
        return true;
    }

    public boolean hasNext() throws OperationNotSupportedException {
        if (this.index + 1 >= data.size()) {
            throw new OperationNotSupportedException();
        }
        return true;
    }

    public String print()  {
        if (this.index >= data.size()) {
            return "Invalid operation!";
        }
        return this.data.get(this.index);
    }
}
