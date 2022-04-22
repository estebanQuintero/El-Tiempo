package co.com.eltiempo.certificacion.metro.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.eltiempo.certificacion.metro.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarBusqueda implements Task {

    private final String inmueble;
    private final String compra;
    private final String ciudad;


    public IngresarBusqueda(String inmueble, String compra, String ciudad) {
        this.inmueble = inmueble;
        this.compra = compra;
        this.ciudad = ciudad;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(INMUEBLE),
                Click.on(TIPO_INMUEBLE.of(inmueble)),
                Click.on(COMPRA),
                Click.on(TIPO_COMPRA.of(compra)),
                Enter.keyValues(ciudad).into(CIUDAD),
                Click.on(BUSCAR)
        );
    }

    public static IngresarBusqueda deInmuebles(String inmueble, String compra, String ciudad){
        return instrumented(IngresarBusqueda.class,inmueble,compra,ciudad);
    }
}
