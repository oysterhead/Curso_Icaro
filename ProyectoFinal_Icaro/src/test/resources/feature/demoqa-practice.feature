Feature: Completar formulario
  Background:
    Given usuario se encuentra en el HomePage de DEMOQA

    @OpenHomePage
    Scenario: Usuario ingresa a la web
      When usuario visualiza el titulo
      Then visualiza logo
      And hace click en Forms

    @FormsOk
    Scenario: Usuario ingresa a la automatizacion del formulario
      When hace click en Forms
      Then debe hacer click en Practice Form
      And ver el titulo Practice Form

    Scenario Outline: Usuario completa formulario
      When usuario visualiza el titulo
      Then ingresa Name "<name>" "<lastName>"
      And ingresa Email "<email>"
      And selecciona genero
      And ingresa nro de telefono "<mobile>"
      And elige una fecha de nacimiento
      And ingresa un texto largo
      And elige un Hobbie
      And hace click en el boton para cargar una foto
      And completa su direccion actual
      And selecciona un estado
      And selecciona una ciudad
      And hace click en el boton Submit
      Then visualiza un mensaje

      Examples:
        | name | lastName | email | mobile |
      | Pedro | Gutierrez | pgutierrez@yopmail.com | 543512345678 |
      | Lucas | Zelarrayan | elchino10@yopmail.com | 3543773986   |
      | Juan  | Espinola   | manodemanteca@yopmail.com | 11678901234 |
