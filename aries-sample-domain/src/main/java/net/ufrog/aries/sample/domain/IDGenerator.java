package net.ufrog.aries.sample.domain;

import net.ufrog.aries.sample.domain.models.ID;
import net.ufrog.common.utils.Strings;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-03-18
 * @since 0.1
 */
public class IDGenerator extends UUIDGenerator {

    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        if (object instanceof ID) {
            ID id = ID.class.cast(object);
            if (id._manualId() && !Strings.empty(id.getId())) {
                return id.getId();
            }
        }
        return super.generate(session, object);
    }
}
