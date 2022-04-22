package co.com.eltiempo.certificacion.metro.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.eltiempo.certificacion.metro.userinterfaces.BusquedaPage.*;
import static co.com.eltiempo.certificacion.metro.util.ConstantesBusqueda.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarResultado implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(VALOR_INMUEBLE, PRECIO_RESULTADO.resolveFor(actor).getText().replace("$","").replace(".",""));
        actor.attemptsTo(
                Scroll.to(BANIOS_RESULTADO)
        );
        actor.remember(AREA_INMUEBLE, METROS_RESULTADO.resolveFor(actor).getText().substring(0,2));
        actor.remember(BANIOS_INMUEBLE, BANIOS_RESULTADO.resolveFor(actor).getText().substring(0,1));

    }

    public static SeleccionarResultado deBusqueda(){
        return instrumented(SeleccionarResultado.class);
    }
}
