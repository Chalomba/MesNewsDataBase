package formatters;

import com.google.inject.AbstractModule;
import play.data.format.Formatters;

/**
 * Created by kirill on 5/22/16.
 */
public class FormattersModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Formatters.class).toProvider(FormattersProvider.class);
    }
}
