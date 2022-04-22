Feature: Yo como usuario quiero realizar una busqueda con los filtros que yo requiero para realizar la compra

  Scenario Outline: validacion de los filtros de busqueda del portal metrocuadrado
    Given ingrear al portarl
    When En el modulo de busqueda ingresar tipo y filtrar: <inmueble>, <compra>, <ciudad>, <precio desde>, <precio hasta>, <banios>, <area desde>, <area hasta>
    Then Verificar que en el primer resultado arrojado, los datos esten de acuerdo a los filtros ingresados <precio desde>, <precio hasta>, <banios>, <area desde>, <area hasta>


    Examples:

      | inmueble | compra               | ciudad     | precio desde | precio hasta | banios | area desde | area hasta |
      | Oficinas | Compra Nuevo y Usado | Bogota D.C | 100000000    | 500000000    | 2      | 60 m2      | 200 m2     |
