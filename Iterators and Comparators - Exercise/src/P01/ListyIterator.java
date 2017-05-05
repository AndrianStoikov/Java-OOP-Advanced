package P01;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private List<String> strings;
    private int index;

    public ListyIterator(String... str) {
        this.setStrings(str);
        this.index = 0;
    }

    private void setStrings(String[] strings) {
        this.strings = Arrays.asList(strings);
    }

    public boolean move() {
        if (this.index < this.strings.size() - 1) {
            this.index += 1;
            return true;
        }

        return false;
    }

    public String print() throws IllegalArgumentException {
        if(this.strings.size() <= this.index || this.strings.size() == 0)
            throw new IllegalArgumentException("Invalid Operation!");

        return this.strings.get(this.index);
    }

    public boolean hasNext() {
        return this.index < this.strings.size() - 1;
    }
}
