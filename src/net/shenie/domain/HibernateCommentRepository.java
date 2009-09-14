package net.shenie.domain;

import net.shenie.persistence.HibernateRepositorySupport;

/**
 * Created by IntelliJ IDEA.
 * User: andy
 * Date: Sep 9, 2009
 * Time: 9:15:33 AM
 */
public class HibernateCommentRepository extends HibernateRepositorySupport implements CommentRepository {

    protected Class model() {
        return Comment.class;
    }
}