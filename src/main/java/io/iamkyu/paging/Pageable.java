package io.iamkyu.paging;

/**
 * @author Kj Nam
 * @since 2017-04-20
 */
public interface Pageable {
    int getPageNumber();

    int getPageSize();

    int getOffset();
}
