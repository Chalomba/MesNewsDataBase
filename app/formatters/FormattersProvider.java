package formatters;

import org.joda.time.DateTime;
import play.data.format.Formatters;
import play.data.format.Formatters.SimpleFormatter;
import play.i18n.MessagesApi;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.text.ParseException;
import java.util.Locale;


@Singleton
public class FormattersProvider implements Provider<Formatters> {

    private final MessagesApi messagesApi;

    @Inject
    public FormattersProvider(MessagesApi messagesApi) {
        this.messagesApi = messagesApi;
    }

    @Override
    public Formatters get() {
        Formatters formatters = new Formatters(messagesApi);

        formatters.register(DateTime.class, new SimpleFormatter<DateTime>() {
            @Override
            public DateTime parse(String input, Locale l) throws ParseException {
                return DateTime.parse(input);
            }

            @Override
            public String print(DateTime dateTime, Locale l) {
                return dateTime.toString();
            }

        });

        return formatters;
    }
}