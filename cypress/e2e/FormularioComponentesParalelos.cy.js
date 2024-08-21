describe('Formulario y Visualización', () => {
  beforeEach(() => {
    cy.visit('http://localhost:4173')
  })

  it('debería actualizar la visualización cuando se cambia el formulario', () => {

    cy.get('select#Edad').select('Mayor de edad')
    cy.get('select#Edad').should('have.value', 'Mayor de edad')

    cy.get('select#Lugar\\ de\\ nacimiento').select('Alemania')
    cy.get('select#Lugar\\ de\\ nacimiento').should('have.value', 'Alemania')

    cy.get('select#Situación').select('Empleado')
    cy.get('select#Situación').should('have.value', 'Empleado')

    cy.get('div').contains('Edad: Mayor de edad')
    cy.get('div').contains('Lugar de nacimiento: Alemania')
    cy.get('div').contains('Situación: Empleado')
  })
})