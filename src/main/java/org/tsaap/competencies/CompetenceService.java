package org.tsaap.competencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsaap.competencies.repositories.CatalogRepository;
import org.tsaap.competencies.repositories.CategoryRepository;
import org.tsaap.competencies.repositories.CompetenceRepository;

/**
 * Service to manage competencies
 */
@Service
public class CompetenceService {

    @Autowired
    private CatalogRepository catalogRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CompetenceRepository mCompetenceRepository;

    public CompetenceService(CatalogRepository catalogRepository, CategoryRepository categoryRepository,
                             CompetenceRepository competenceRepository) {
        this.catalogRepository = catalogRepository ;
        this.categoryRepository = categoryRepository;
        this.mCompetenceRepository = competenceRepository;
    }

    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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

    /**
     * save a category in the database
     * @param category the categary to save
     * @return the category
     */
    public Category saveCategory(Category category) {
        Category res = categoryRepository.save(category);
        return res;
    }


}
