package co.com.eltiempo.certificacion.metro.stepdefinitions;

import co.com.eltiempo.certificacion.metro.exceptions.GeneralExceptions;
import co.com.eltiempo.certificacion.metro.interactions.CambiarVentana;
import co.com.eltiempo.certificacion.metro.questions.BusquedaCorrecta;
import co.com.eltiempo.certificacion.metro.tasks.FiltrarInmuebles;
import co.com.eltiempo.certificacion.metro.tasks.IngresarBusqueda;
import co.com.eltiempo.certificacion.metro.tasks.SeleccionarResultado;
import co.com.eltiempo.certificacion.metro.userinterfaces.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static co.com.eltiempo.certificacion.metro.util.ConstantesBusqueda.VALOR_INMUEBLE;
import static co.com.eltiempo.certificacion.metro.util.ConstantesExceptions.ERROR_DATOS_INCORRECTOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class FiltroBusquedaMetroStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver herBrowser;
    private final Actor actor= Actor.named("Esteban");
    private final HomePage homepage = new HomePage();

    @Before
    public void setUp(){
        actor.can(BrowseTheWeb.with(herBrowser));
    }

    @Given("ingrear al portarl")
    public void ingrearAlPortarl() {
        actor.wasAbleTo(Open.browserOn(homepage));
    }

    @When("En el modulo de busqueda ingresar tipo y filtrar: {}, {}, {}, {}, {}, {int}, {}, {}")
    public void enElModuloDeBusquedaIngresarTipoYFiltrar(String inmueble, String compra, String ciudad, String precioDesde, String precioHasta, Integer banios, String areaDesde, String areaHasta) {
        actor.attemptsTo(
                IngresarBusqueda.deInmuebles(inmueble,compra,ciudad),
                FiltrarInmuebles.conLosDatos(precioDesde,precioHasta,banios,areaDesde,areaHasta),
                CambiarVentana.delNavegador(herBrowser),
                SeleccionarResultado.deBusqueda()
        );

    }

   @Then("Verificar que en el primer resultado arrojado, los datos esten de acuerdo a los filtros ingresados {int}, {int}, {int}, {}, {}")
    public void verificarQueEnElPrimerResultadoArrojadoLosDatosEstenDeAcuerdoALosFiltrosIngresados(int precioDesde, int preciohasta, int banios, String areaDesde, String areaHasta) {
       actor.should(
               seeThat(BusquedaCorrecta.delInmueble(precioDesde,preciohasta,banios,areaDesde,areaHasta))
                       .orComplainWith(GeneralExceptions.class,ERROR_DATOS_INCORRECTOS)
       );

   }
}
