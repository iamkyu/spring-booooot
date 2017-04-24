package io.iamkyu.paging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Kj Nam
 * @since 2017-04-21
 */
public class Page<T> {
    private final List<T> content = new ArrayList<>();
    private final long total;
    private final Pageable pageable;

    public Page(List<T> content, long total, Pageable pageable) {
        this.content.addAll(content);
        this.pageable = pageable;
        this.total = !content.isEmpty() && pageable != null && pageable.getOffset() + pageable.getPageSize() > total
                ? pageable.getOffset() + content.size() : total;
    }

    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
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
