package org.tsaap.competencies

import org.tsaap.competencies.repositories.CatalogRepository
import org.tsaap.competencies.repositories.CompetenceRepository
import org.tsaap.competencies.repositories.CategoryRepository
import spock.lang.Specification


/**
 * Test competence service
 */
class CompetenceServiceTest extends Specification {


    private CompetenceService competenceService
    private CatalogRepository catalogRepository
    private CompetenceRepository competenceRepository
    private CategoryRepository categoryRepository

    void setup() {
        catalogRepository = Mock(CatalogRepository)
        categoryRepository = Mock(CategoryRepository)
        competenceRepository = Mock(CompetenceRepository)
        competenceService = new CompetenceService(catalogRepository, categoryRepository, competenceRepository)

    }

    def "test save a valid catalog"() {
        given: "a  catalog"
        def catalog = Mock(Catalog)

        when: "the catalog is saved"
        competenceService.saveCatalog(catalog);

        then: "catalogRepositpory save is triggered"
        1 * catalogRepository.save(catalog)
    }

    def "test save a valid category"() {
        given: "a category"
        def category = Mock(Category)

        when: "the category is saved"
        competenceService.saveCategory(category)

        then: "categoryRepository save is called"
        1 * categoryRepository.save(category)
    }

    def "test save a valid competence"(){
        given:"a competence"
            def competence = Mock(Competence)

        when:"the competence is saved"
            competenceService.saveCompetence(competence)

        then: "competence repository save is triggered"
            1 * competenceRepository.save(competence)
    }

    def "test competence service setters"() {
        given: "3 new competence, catalog and category repository and a competence, a catalog and a category"
        def catalogRepository_new = Mock(CatalogRepository)
        def categoryRepository_new = Mock(CategoryRepository)
        def competenceRepository_new = Mock(CompetenceRepository)
        def catalog = Mock(Catalog)
        def category = Mock(Category)
        def competence = Mock(Competence)

        when: "set the new competence, catalog and category repository and try to save objects"
        competenceService.setCatalogRepository(catalogRepository_new)
        competenceService.setCategoryRepository(categoryRepository_new)
        competenceService.setCompetenceRepository(competenceRepository_new)
        competenceService.saveCatalog(catalog)
        competenceService.saveCategory(category)
        competenceService.saveCompetence(competence)

        then: "The catalog, category and competence are saved in the new repository"
        1 * catalogRepository_new.save(catalog)
        1 * categoryRepository_new.save(category)
        1 * competenceRepository_new.save(competence)
    }


}
