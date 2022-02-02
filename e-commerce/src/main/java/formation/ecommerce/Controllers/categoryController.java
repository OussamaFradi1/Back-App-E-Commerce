package formation.ecommerce.Controllers;

import formation.ecommerce.Dao.categoryRepository;
import formation.ecommerce.Models.Category;
import formation.ecommerce.Models.Client;
import formation.ecommerce.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class categoryController {
    @Autowired
    private categoryRepository icategory;
    @GetMapping("/all")
    public List<Category> getAllcategory(){return icategory.findAll();}
    @PostMapping("/save")
    public Category savecategory(@RequestBody Category c){return icategory.save(c);}
    @PutMapping("/update/{Id}")
    public Category update (@RequestBody Category c, @PathVariable Long Id){
        c.setId(Id);
        return icategory.saveAndFlush(c);
    }
    @DeleteMapping("/delete/{Id}")
    public HashMap<String,String> deleteCategory (@PathVariable(value="Id") Long Id){
        HashMap message = new HashMap();
        try{
            icategory.deleteById(Id);
            message.put("etat","category deleted");
            return message;
        }
        catch (Exception e){
            message.put("etat","category not deleted");
            return message;
        }
    }
    @GetMapping("/GetOne/{id}")
    public Category getOneCategory(@PathVariable Long id){
        return icategory.findById(id).orElse(null);
    }
}
