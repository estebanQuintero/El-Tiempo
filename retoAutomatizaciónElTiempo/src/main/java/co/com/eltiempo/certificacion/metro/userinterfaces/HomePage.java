package co.com.eltiempo.certificacion.metro.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.metrocuadrado.com/")

public class HomePage extends PageObject {
    public static final Target INMUEBLE = Target.the("Campo para seleccionar tipo de inmueble")
            .locatedBy("//div[@class=\"m2-select__value-container m2-select__value-container--is-multi css-1hwfws3\"]");
    public static final Target TIPO_INMUEBLE = Target.the("Opcion de oficinas del menu inmueble")
            .locatedBy("(//*[contains(text(),'{0}')])[1]");
    public static final Target COMPRA = Target.the("Campo para seleccionar tipo de Compra")
            .locatedBy("//div[@class='m2-select__value-container m2-select__value-container--has-value css-1hwfws3']");
    public static final Target TIPO_COMPRA = Target.the("Opcion del tipo de compra")
            .locatedBy("//*[contains(text(),'{0}')]");
    public static final Target CIUDAD = Target.the("Campo para infresar la ciudad")
            .locatedBy("//input[@class='Input-wun2o8-0 jThSBh Autocomplete-sc-1gumhaq-0 fazExU CityAutocomplete-sc-1o8qzu4-0 cruVAa form-control']");
    public static final Target  BUSCAR = Target.the("Boton para buscar")
            .located(By.id("btnSearch"));
}
