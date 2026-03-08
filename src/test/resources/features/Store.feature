@Store
Feature: Product - Store

  @RegistroLogin
  Scenario Outline: Realizar el login - Store
    Given estoy en la página de la tienda
    When doy click en la opción iniciar sesión
    And doy click en el link text cree una cuenta aquí
    And lleno los campos del formulario para el registro con "<nombre>" "<apellido>" "<correo>" "<password>"
    And doy click en el botón guardar
    Then debería visualizar al usuario "<nombre>" "<apellido>" logeado en la pantalla

    Examples:
      | nombre | apellido | correo           | password              |
      | Juan   | Perez    | user@example.com | P@ssw0rd_Str0ng_2026! |
