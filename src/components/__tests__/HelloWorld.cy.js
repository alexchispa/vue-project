import HelloWorld from '../HelloWorld.vue'

describe('HelloWorld', () => {
  it('playground', () => {
    cy.mount(HelloWorld, { props: { msg: 'Hola mundo' } })
  })

  it('renders properly', () => {
    cy.mount(HelloWorld, { props: { msg: 'Hola mundo' } })
    cy.get('h1').should('contain', 'Hola mundo')
  })
})
