package net.ufrog.aries.common.jpa;

import net.ufrog.common.Logger;
import net.ufrog.common.utils.Strings;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-03-18
 * @since 0.1
 */
public class IDGenerator extends UUIDGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        if ((object instanceof ManualID) && (object instanceof ID)) {
            ID id = ID.class.cast(object);
            if (!Strings.empty(id.getId())) {
                Logger.debug("original primary key: %s", id.getId());
                return id.getId();
            }
        }
        return super.generate(session, object);
    }
}
