## Creado por Oskar Orozco
## 11/12/2021

Feature: Listar ofertas de trabajo disponibles
  Ingresar a la web de Sophos y listar las ofertas laborales disponibles

@ConsultarTrabajos
Scenario: Consulta Oferta de Trabajos Disponibles
  Given Que ingreso a la web de Sophos
  When Ingreso a trabaja con nosotros
  Then Genera lista con ofertas laborales disponibles
