package io.iamkyu.paging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Kj Nam
 * @since 2017-04-21
 */
abstract class Chunk<T> {
    private final List<T> content = new ArrayList<>();
    private final Pageable pageable;

    public Chunk(List<T> content, Pageable pageable) {
        this.content.addAll(content);
        this.pageable = pageable;
    }

    public int getNumber() {
        return pageable == null ? 0 : pageable.getPageNumber();
    }

    public int getSize() {
        return pageable == null ? 0 : pageable.getPageSize();
    }


    public List<T> getContent() {
        return Collections.unmodifiableList(content);
    }
}
