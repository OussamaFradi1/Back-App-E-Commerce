package formation.ecommerce.Controllers;

import formation.ecommerce.Dao.subcategoryRepository;
import formation.ecommerce.Models.Category;
import formation.ecommerce.Models.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/subcategory")
public class subcategoryController {
    @Autowired
    private subcategoryRepository isubcategory;
    @GetMapping("/all")
    public List<SubCategory> getAllcategory(){return isubcategory.findAll();}
    @PostMapping("/save")
    public SubCategory savecategory(@RequestBody SubCategory c){return isubcategory.save(c);}
    @PutMapping("/update/{Id}")
    public SubCategory update (@RequestBody SubCategory c, @PathVariable Long Id){
        c.setId(Id);
        return isubcategory.saveAndFlush(c);
    }
    @DeleteMapping("/delete/{Id}")
    public HashMap<String,String> deleteCategory (@PathVariable(value="Id") Long Id){
        HashMap message = new HashMap();
        try{
            isubcategory.deleteById(Id);
            message.put("etat","category deleted");
            return message;
        }
        catch (Exception e){
            message.put("etat","category not deleted");
            return message;
        }
    }
    @GetMapping("/GetOne/{id}")
    public SubCategory getOneSubCategory(@PathVariable Long id){
        return isubcategory.findById(id).orElse(null);
    }
}
