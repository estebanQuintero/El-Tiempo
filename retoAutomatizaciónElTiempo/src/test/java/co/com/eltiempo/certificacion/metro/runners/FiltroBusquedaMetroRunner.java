package co.com.eltiempo.certificacion.metro.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "co.com.eltiempo.certificacion.metro",
        features = "src/test/resources/features/filtro_busqueda_metro.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class FiltroBusquedaMetroRunner {
}
