package io.iamkyu.paging;

import java.util.List;

/**
 * @author Kj Nam
 * @since 2017-04-21
 */
public class Page<T> extends Chunk {
    private final long total;
    private final Pageable pageable;

    public Page(List<T> content, long total, Pageable pageable) {
        super(content, pageable);

        this.pageable = pageable;
        this.total = !content.isEmpty() && pageable != null && pageable.getOffset() + pageable.getPageSize() > total
                ? pageable.getOffset() + content.size() : total;
    }

    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
    }
}
