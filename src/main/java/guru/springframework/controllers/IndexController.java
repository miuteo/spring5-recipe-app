package guru.springframework.controllers;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @GetMapping("/")
    public String getIndexPage(){
        categoryRepository.findByDescription("Mexican")
                .ifPresent(category -> System.out.println("Cat id is: "+category.getId()));
        unitOfMeasureRepository.findByDescription("Pinch")
                .ifPresent(unitOfMeasure -> System.out.println("UOM id is: "+unitOfMeasure.getId()));
        return "index";
    }
}
