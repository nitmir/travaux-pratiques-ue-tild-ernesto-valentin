package org.tsaap.competencies

import org.tsaap.competencies.repositories.CatalogRepository
import org.tsaap.competencies.repositories.CompetenceRepository
import spock.lang.Specification


/**
 * Test competence service
 */
class CompetenceServiceTest extends Specification {


    private CompetenceService competenceService
    private CatalogRepository catalogRepository
    private CompetenceRepository competenceRepository

    void setup() {
        catalogRepository = Mock(CatalogRepository)
        competenceRepository = Mock(CompetenceRepository)
        competenceService = new CompetenceService(catalogRepository,competenceRepository)

    }

    def "test save a valid catalog"() {
        given: "a  catalog"
        def catalog = Mock(Catalog)

        when: "the catalog is saved"
        competenceService.saveCatalog(catalog);

        then: "catalogRepositpory save is triggered"
        1 * catalogRepository.save(catalog)
    }

    def "test save a valid competence"(){
        given:"a competence"
            def competence = Mock(Competence)

        when:"the competence is saved"
            competenceService.saveCompetence(competence)

        then: "competence repository save is triggered"
            1 * competenceRepository.save(competence)
    }
}
