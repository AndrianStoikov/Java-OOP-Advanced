package P09;

public class Interpreter<T extends Comparable<T>> {
    private CustomList<T> list;

    public Interpreter() {
        this.list = new CustomList<>();
    }

    public void Add(T element) {
        this.list.add(element);
    }

    public void Remove(int index) {
        this.list.remove(index);
    }

    public void Contains(T element) {
        System.out.println(this.list.contains(element));
    }

    public void Swap(int index1, int index2) {
        this.list.swap(index1, index2);
    }

    public void Greater(T element) {
        System.out.println(this.list.countGreaterThat(element));
    }

    public void Max() {
        System.out.println(this.list.getMax());
    }

    public void Min() {
        System.out.println(this.list.getMin());
    }

    public void Print () {
        for (T item : this.list) {
            System.out.println(item);
        }
    }

    public void Sort() {
        Sorter.Sort(this.list);
    }
}
