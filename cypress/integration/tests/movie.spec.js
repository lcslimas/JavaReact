/// <reference types="cypress" />

context('Filmes', () => {
    beforeEach(() => {
      cy.visit('http://localhost:8080/movies')
    })


    it('Salva Filme', () => {
        cy.get('.btn-link').click()
        
        cy.get('#name').clear()
        cy.get('#name').type('Movie2').should('have.value', 'Movie2')

        cy.get('#description').clear()
        cy.get('#description').type('Descrição alterada').should('have.value', 'Descrição alterada')

        cy.get('button').click()

        cy.get('.alert').should('have.text', 'Filme cadastrado com sucesso')
    })

    it('Conta a quantidade de filmes', () => {
      cy.get('.movie').should(($movie, $index) => {
        $index == 1 ? expect($movie).to.have.length(1): ''
      })
    })

    it('Verifica nome do Filme', () => {
        cy.get('.movie').each(($movie, $index) => {
            $index == 1 ? expect($movie.find('#name')).to.have.text('Movie2') : ''
        })
    })

    it('Verifica descricao do Filme', () => {
        cy.get('.movie').each(($movie, $index) => {
            $index == 1 ? expect($movie.find('#description')).to.have.text('Descrição alterada'): ''
        })
    })

    it('Edita Filme', () => {
        cy.get('.image').each(($image, index) =>{
            index == 1 ? $image.click(): ''
        })
        
        cy.get('.title').then(title => title.val() == 'Editar Filme')
        cy.get('#name').clear()
        cy.get('#name').type('Movie2').should('have.value', 'Movie2')

        cy.get('#description').clear()
        cy.get('#description').type('Descrição alterada').should('have.value', 'Descrição alterada')

        cy.get('button').click()

        cy.get('.alert').should('have.text', 'Filme cadastrado com sucesso')
    })

    it('Exclui Filme', () => {
        cy.get('.excluir').each(($movie, $index)=>{
            $index == 1 ? $movie.click(): ''
        })
        cy.get('.alert').should('have.text', 'Filme excluído com sucesso')
        cy.get('.alert').then($alert => $alert.is('visible'))
    })
})