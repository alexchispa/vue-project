import HelloWorld from '../HelloWorld.vue'

describe('HelloWorld', () => {
  it('playground', () => {
    cy.mount(HelloWorld, { props: { msg: 'Hola Mundo' } })
  })

  it('renders properly', () => {
    cy.mount(HelloWorld, { props: { msg: 'Hola Mundo' } })
    cy.get('h1').should('contain', 'Hola Mundo')
  })
})
