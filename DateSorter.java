package sample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Comparator;
import java.util.Locale;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 package sample;

 import java.time.LocalDate;
 import java.util.Collection;
 import java.util.List;

 /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {
    private static final String LETTER = "r";

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        Comparator<LocalDate> myComparator = new Comparator<>() {
            @Override
            public int compare(LocalDate date1, LocalDate date2) {
                boolean firstDateContainsLetter = containsLetter(date1);
                boolean secondDateContainsLetter = containsLetter(date2);
                if (firstDateContainsLetter && secondDateContainsLetter) {
                    return date1.compareTo(date2);
                }
                if (secondDateContainsLetter) {
                    return 1;
                }
                if (firstDateContainsLetter) {
                    return -1;
                }
                return date2.compareTo(date1);
            }

            private boolean containsLetter(LocalDate localDate) {
                String month = localDate.format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH));
                return month.contains(DateSorter.LETTER);
            }
        };
        unsortedDates.sort(myComparator);
        return unsortedDates;
    }
}