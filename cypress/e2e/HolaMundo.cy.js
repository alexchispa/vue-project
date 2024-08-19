// cypress/e2e/hola-mundo.cy.js
describe('Prueba de Hola Mundo', () => {
  it('Muestra el mensaje "Hola Mundo" y hace clic en el botón', () => {
    // Visita la aplicación
    cy.visit('http://localhost:5173')

    // Verifica que el mensaje "Hola Mundo" esté presente
    cy.contains('h1', 'Hola Mundo')

    // Hace clic en el botón y verifica que aparezca una alerta
    cy.on('window:alert', (str) => {
      expect(str).to.equal('¡Hola desde Vue!')
    })

    // Hace clic en el botón
    cy.get('button').click()
  })
})
