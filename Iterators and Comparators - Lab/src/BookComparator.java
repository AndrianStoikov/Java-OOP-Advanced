import java.util.Comparator;

/**
 * Created by Andrian on 23.3.2017 г..
 */
public class BookComparator implements Comparator<Book> {

    public int compare(Book b1, Book b2) {
        int titleCompareResult = b1.getTitle().compareTo(b2.getTitle());

        if (titleCompareResult > 0)
            return 1;
        else if (titleCompareResult < 0)
            return -1;

        int yearOfPublishingCompare = Integer.compare(b1.getYear(), b2.getYear());
        if (yearOfPublishingCompare > 0)
            return 1;
        if (yearOfPublishingCompare < 0)
            return -1;

        return 0;
    }
}
