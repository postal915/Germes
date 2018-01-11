package com.github.postal915.germes.app.model.search.criteria.range;

/**
 * Pagination parameters for data retrieval operations
 */

public class RangeCriteria {

    /**
     * Page index (0-base)
     */
    private final int page;

    /**
     * Number of element per page
     */
    private final int rowCount;

    public RangeCriteria(final int page, final int rowCount) {
        this.page = page;
        this.rowCount = rowCount;
    }

    public int getPage() {
        return page;
    }

    public int getRowCount() {
        return rowCount;
    }
}
