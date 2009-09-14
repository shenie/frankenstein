package net.shenie.persistence;

import java.util.List;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: andy
 * Date: Sep 14, 2009
 * Time: 8:26:26 PM
 */
public interface Repository {
    Object load(Serializable id);
    List loadAll();
    Serializable save(Object model);
}
