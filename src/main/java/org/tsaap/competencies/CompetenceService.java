package org.tsaap.competencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsaap.competencies.repositories.CatalogRepository;
import org.tsaap.competencies.repositories.CompetenceRepository;

/**
 * Service to manage competencies
 */
@Service
public class CompetenceService {

    @Autowired
    private CatalogRepository catalogRepository;
    private CompetenceRepository mCompetenceRepository;

    public CompetenceService(CatalogRepository catalogRepository,
                             CompetenceRepository competenceRepository) {
        this.catalogRepository = catalogRepository;
        this.mCompetenceRepository = competenceRepository;
    }

    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public void setCompetenceRepository(CompetenceRepository mCompetenceRepository) {
        this.mCompetenceRepository = mCompetenceRepository;
    }

    /**
     * Save catalog in the database
     * @param catalog the catalog to save
     * @return the catalog
     */
    public Catalog saveCatalog(Catalog catalog) {
        Catalog res =  catalogRepository.save(catalog);
        return res;
    }

    /**
     * save a competence in the database
     * @param aCompetence the competence to save
     * @return the competence
     */
    public Competence saveCompetence(Competence aCompetence){
        Competence res = mCompetenceRepository.save(aCompetence);
        return res;
    }
}
