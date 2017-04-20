package io.iamkyu.paging;

/**
 * @author Kj Nam
 * @since 2017-04-20
 */
public class PageRequest implements Pageable {
    private int page;
    private int size;

    public PageRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

    @Override
    public int getPageNumber() {
        return page;
    }

    @Override
    public int getPageSize() {
        return size;
    }

    @Override
    public int getOffset() {
        return page * size;
    }
}
