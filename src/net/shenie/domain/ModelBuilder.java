package net.shenie.domain;

/**
 * Created by IntelliJ IDEA.
 * User: andy
 * Date: Sep 14, 2009
 * Time: 7:19:21 PM
 */
public interface ModelBuilder<T> {
    void build(T model);
}
