package co.com.eltiempo.certificacion.metro.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.eltiempo.certificacion.metro.userinterfaces.BusquedaPage.*;
import static co.com.eltiempo.certificacion.metro.userinterfaces.HomePage.BUSCAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FiltrarInmuebles implements Task {

    private final String precioDesde;
    private final String precioHasta;
    private final int banios;
    private final String areaDesde;
    private final String areaHasta;

    public FiltrarInmuebles(String precioDesde, String precioHasta, int banios, String areaDesde, String areaHasta) {
        this.precioDesde = precioDesde;
        this.precioHasta = precioHasta;
        this.banios = banios;
        this.areaDesde = areaDesde;
        this.areaHasta = areaHasta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(precioDesde).into(PRECIO_DESDE),
                Enter.keyValues(precioHasta).into(PRECIO_HASTA),
                Scroll.to(FILTRAR_PRECIOS),
                Click.on(FILTRAR_PRECIOS),
                Click.on(BANIOS.of(String.valueOf(banios))),
                Click.on(AREA_DESDE),
                Click.on(CAMPO_AREA.of(areaDesde)),
                Click.on(AREA_HASTA),
                Click.on(CAMPO_AREA.of(areaHasta)),
                Scroll.to(BUSCAR),
                Click.on(PRIMER_RESULTADO)
        );

    }

    public static FiltrarInmuebles conLosDatos(String precioDesde, String precioHasta, int banios, String areaDesde, String areaHasta){
        return instrumented(FiltrarInmuebles.class,precioDesde,precioHasta,banios,areaDesde,areaHasta);
    }
}
