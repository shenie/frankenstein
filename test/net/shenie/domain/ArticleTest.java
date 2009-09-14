package net.shenie.domain;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created by IntelliJ IDEA.
 * User: andy
 * Date: Sep 8, 2009
 * Time: 10:32:18 PM
 */
public class ArticleTest extends TestCase {

    private static final Logger LOG = Logger.getLogger(ArticleTest.class);

    private HibernateTemplate hibernateTemplate;
    private SessionFactory sessionFactory;
    private Session session;
    private ApplicationContext context;

    protected void setUp() throws Exception {
        super.setUp();

        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        hibernateTemplate = (HibernateTemplate) context.getBean("hibernateTemplate");

        sessionFactory = (SessionFactory) context.getBean("sessionFactory");

        session = SessionFactoryUtils.getSession(sessionFactory, null, null);
        TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
    }

    @Override
    protected void tearDown() throws Exception {
        TransactionSynchronizationManager.unbindResource(sessionFactory);
        SessionFactoryUtils.releaseSession(session, sessionFactory);

        super.tearDown();
    }

    public void testLoad() {
        Article article = (Article) hibernateTemplate.get(Article.class, Integer.valueOf(1));
        assertNotNull(article);
        LOG.debug(article);
        assertEquals(2, article.getComments().size());

        ArticleRepository repos = (ArticleRepository) context.getBean("articlesRepository");
        assertEquals(1, repos.loadAll().size());

        assertNotNull(repos.load("1"));
    }
}
