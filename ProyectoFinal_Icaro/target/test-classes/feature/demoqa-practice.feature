Feature: Completar formulario
  Background:
    Given usuario se encuentra en el HomePage de DEMOQA

    @OpenHomePage @OK
    Scenario: Usuario ingresa a la web
      When usuario visualiza el titulo
      Then visualiza logo
      And hace click en Forms

    @OpenFormsPage @OK
    Scenario: Usuario ingresa a la automatizacion del formulario
      When usuario esta en la pagina del Form
      Then debe hacer click en Practice Form
      And ver el titulo Practice Form

    @CompleteForm @OK
    Scenario Outline: Usuario completa formulario
      When usuario visualiza el titulo del formulario
      Then ingresa Nombre "<name>"
      And ingresa Apellido "<lastName>"
      And ingresa Email "<email>"
      And selecciona genero "<genero>"
      And ingresa nro de telefono "<mobile>"
      And elige una fecha de nacimiento "<nacimiento>"
      And ingresa un texto largo
      And elige un Hobbie
      And hace click en el boton para cargar una foto
      And completa su direccion actual
      And selecciona un estado
      And selecciona una ciudad
      And hace click en el boton Submit
      Then visualiza un mensaje

      Examples:
        | name | lastName | email | genero | nacimiento | mobile |
      | Pedro | Gutierrez | pgutierrez@yopmail.com | Male | 10 Dec 1990 | 543512345678 |
      | Lucas | Zelarrayan | elchino10@yopmail.com | Female |22 Jan 1989 | 3543773986   |
      | Juan  | Espinola   | manodemanteca@yopmail.com | Other | 30 Oct 1943 | 1167890123 |
