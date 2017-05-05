package P04;

import java.util.*;

public class Lake implements Iterable {
    private List<Integer> nums;

    public Lake(Integer... nums) {
        this.setNums(nums);
    }

    private void setNums(Integer[] nums) {
        List<Integer> list = Arrays.asList(nums);
        this.nums = this.sortList(list);
    }

    private List<Integer> sortList(List<Integer> list) {
        ArrayList<Integer> evenIndex = new ArrayList<>();
        ArrayList<Integer> oddIndex = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0)
                evenIndex.add(i);
            else
                oddIndex.add(i);
        }
        evenIndex.sort(Comparator.naturalOrder());
        oddIndex.sort(Comparator.naturalOrder());

        evenIndex.addAll(oddIndex);

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer index : evenIndex) {
            result.add(list.get(index));
        }

        return result;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        int index;

        public Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < nums.size();
        }

        @Override
        public Integer next() {
            return nums.get(this.index++);
        }
    }
}
