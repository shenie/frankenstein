package net.shenie.persistence;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

public abstract class HibernateRepositorySupport extends HibernateDaoSupport {

    public Object load(final Serializable id) {
        try {
            return getHibernateTemplate().execute(new HibernateCallback() {
                public Object doInHibernate(Session session) throws HibernateException {
                    // assumes id is integer type
                    Object found = session.load(model(), Integer.valueOf(id.toString()));
                    if (!Hibernate.isInitialized(found)) {
                        Hibernate.initialize(found);
                    }
                    return found;
                }

            });
        } catch (HibernateObjectRetrievalFailureException e) {
            throw new ObjectNotFoundException(id, model().toString());
        }
    }

    public List loadAll() {
        return getHibernateTemplate().loadAll(model());
    }

    public Serializable save(Object model) {
        return getHibernateTemplate().save(model);
    }

    protected abstract Class model();
}
