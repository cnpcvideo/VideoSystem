
package org.jboss.seam.examples.booking.log;

import java.io.Serializable;
import javax.annotation.Generated;
import org.jboss.solder.logging.Logger;


/**
 * Warning this class consists of generated code.
 * 
 */
@Generated(value = "org.jboss.logging.generator.model.MessageLoggerImplementor", date = "2011-12-26T09:14:57+0000")
public class BookingLog_$logger
    implements Serializable, BookingLog
{

    private final static long serialVersionUID = 1L;
    private final static String FQCN = BookingLog_$logger.class.getName();
    protected final Logger log;
    private final static String bookingInitiated = "%s initiated a booking at the %s.";
    private final static String hotelSelected = "%s selected the %s in %s.";
    private final static String hotelEntityInPersistenceContext = "Does the persistence context still contain the hotel instance? %s";
    private final static String bookingConfirmed = "New booking at the %s confirmed for %s.";

    public BookingLog_$logger(final Logger log) {
        this.log = log;
    }

    @Override
    public final void bookingInitiated(final String customerName, final String hotelName) {
        log.logf(FQCN, (Logger.Level.INFO), null, bookingInitiated$str(), customerName, hotelName);
    }

    protected String bookingInitiated$str() {
        return bookingInitiated;
    }

    @Override
    public final void hotelSelected(final String customerName, final String hotelName, final String city) {
        log.logf(FQCN, (Logger.Level.INFO), null, hotelSelected$str(), customerName, hotelName, city);
    }

    protected String hotelSelected$str() {
        return hotelSelected;
    }

    @Override
    public final void hotelEntityInPersistenceContext(final boolean state) {
        log.logf(FQCN, (Logger.Level.INFO), null, hotelEntityInPersistenceContext$str(), state);
    }

    protected String hotelEntityInPersistenceContext$str() {
        return hotelEntityInPersistenceContext;
    }

    @Override
    public final void bookingConfirmed(final String hotelName, final String customerName) {
        log.logf(FQCN, (Logger.Level.INFO), null, bookingConfirmed$str(), hotelName, customerName);
    }

    protected String bookingConfirmed$str() {
        return bookingConfirmed;
    }

}
