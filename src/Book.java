

package online.book.reader;
/**
 *
 * @author Ahmed Mabrouk
 */

public class Book {

    private static int id = 0;
    private int bookId;
    private String name;
    private String author;
    private int noPage;
    private int currentPage;
    private boolean isEnd;

    public Book(String name, String author, int noPage)
    {
        ++id;
        setBookId();
        setName(name);
        setAuthor(author);
        setNoPage(noPage);
        setCurrentPage(1);
    } // End Constructor

    // Setter and Getter

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNoPage(int noPage) {
        if (noPage <= 0)
            System.out.println("Invalid value ... try again");
        else
            this.noPage = noPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setIsEnd() {

        if (getCurrentPage() == getNoPage())
            this.isEnd = true;
    }



    public void setBookId()
    {
        this.bookId = id;
    }

    public int getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getNoPage() {
        return noPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void nextPage()
    {
        if (!getIsEnd())
            setCurrentPage(getCurrentPage() + 1);
        else
            System.out.println("This page is last page in book");
    } // End nextPage function

    public void previousPage()
    {
        if (getCurrentPage() != 1)
            setCurrentPage(getCurrentPage() - 1);
        else
            System.out.println("This page is first page in book");
    } //End previousPage function

    public void stopReading()
    {
        setCurrentPage(getNoPage());
        setIsEnd();
    } // End stopReading function

}
