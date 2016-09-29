package org.tsaap.competencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsaap.competencies.repositories.CatalogRepository;
import org.tsaap.competencies.repositories.CategoryRepository;

/**
 * Service to manage competencies
 */
@Service
public class CompetenceService {

    @Autowired
    private CatalogRepository catalogRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public CompetenceService(CatalogRepository catalogRepository, CategoryRepository categoryRepository) {
        this.catalogRepository = catalogRepository ;
        this.categoryRepository = categoryRepository;
    }

    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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

    public Category saveCategory(Category category) {
        Category res = categoryRepository.save(category);
        return res;
    }
}
