package org.tsaap.competencies

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.validation.ConstraintViolationException

/**
 * Test competence service
 */
@ContextConfiguration
@SpringBootTest
class CompetenceServiceITest extends Specification {

    @Autowired
    private CompetenceService competenceService

    def "test save a valid catalog"() {
        given: "a valid catalog"
        Catalog catalog = new Catalog();
        catalog.setName("Catalog 1");
        catalog.setDescription("Description 1");

        when: "the catalog is saved"
        competenceService.saveCatalog(catalog);

        then: "the catalog has an id"
        catalog.getId() != null
        catalog.getName() == "Catalog 1"
        catalog.getDescription() == "Description 1"
    }

    def "test save a non valid catalog"() {
        given: "a non valid catalog"
        Catalog catalog = new Catalog();
        catalog.setName("C1");
        catalog.setDescription("Description 1");

        when: "the catalog is saved"
        competenceService.saveCatalog(catalog);

        then: "a validation exception is thrown"
        thrown ConstraintViolationException
    }

    def "test save a valid category"() {
        given: "a valid category"
        Category category = new Category()
        category.setName("Category 1")
        category.setDescription("Description 2")

        when: "the category is save"
        competenceService.saveCategory(category)

        then: "the category has an id"
        category.getId() != null
        category.getName() == "Category 1"
        category.getDescription() == "Description 2"
    }

    def "test save a non valid category"() {
        given: "a non valid category"
        Category category = new Category()
        category.setName("C2")
        category.setDescription("Description 2")

        when: "the category is saved"
        competenceService.saveCategory(category)

        then: "a validation exception is thrown"
        thrown ConstraintViolationException
    }

    def "test save a valid competence"(){
        given: "a valid competence"
        Category category = new Category()
        category.setName("Category 1")
        competenceService.saveCategory(category)
        Catalog catalog = new Catalog();
        catalog.setName("Catalog 1");
        competenceService.saveCatalog(catalog)
        Competence competence = new Competence()
        competence.setName("Competence 1")
        competence.setDescription("Description de la competence 1")
        competence.setCategory(category)
        competence.setCatalog(catalog)

        when: "the competence is saved"
        competenceService.saveCompetence(competence)

        then: "the competence newly added has an id"
        competence.getId() != null
        competence.getName() == "Competence 1"
        competence.getDescription() == "Description de la competence 1"
    }

    def "test save a non valid competence"(){
        given: "a non valid competence"
        Competence competence = new Competence()
        competence.setName("C1")
        competence.setDescription("Description de la competence 1")

        when: "the competence is saved"
        competenceService.saveCompetence(competence)

        then: "the a validation exception is thrown"
        thrown ConstraintViolationException
    }
}
