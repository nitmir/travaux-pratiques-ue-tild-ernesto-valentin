package org.tsaap.competencies

import org.tsaap.competencies.repositories.CatalogRepository
import org.tsaap.competencies.repositories.CategoryRepository
import spock.lang.Specification


/**
 * Test competence service
 */
class CompetenceServiceTest extends Specification {


    private CompetenceService competenceService
    private CatalogRepository catalogRepository
    private CategoryRepository categoryRepository

    void setup() {
        catalogRepository = Mock(CatalogRepository)
        categoryRepository = Mock(CategoryRepository)
        competenceService = new CompetenceService(catalogRepository, categoryRepository)
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

}
