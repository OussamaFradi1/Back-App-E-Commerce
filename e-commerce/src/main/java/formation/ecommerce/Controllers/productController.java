package formation.ecommerce.Controllers;

import formation.ecommerce.Dao.productRepository;
import formation.ecommerce.Dao.providerRepository;
import formation.ecommerce.Dao.subcategoryRepository;
import formation.ecommerce.Models.Product;
import formation.ecommerce.Models.Provider;
import formation.ecommerce.Models.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class productController {
    @Autowired
    private productRepository iproduct;
    @Autowired
    private providerRepository iprovider;
    @Autowired
    private subcategoryRepository isub;

    @GetMapping("/all")
    public List<Product> getAllProduct(){return iproduct.findAll();}

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product p){return iproduct.save(p);}

    @PutMapping("/update/{Id}/{idprovider}/{idsubcategory}")
    public Product update (@RequestBody Product p, @PathVariable Long Id, @PathVariable Provider idprovider, @PathVariable SubCategory idsubcategory){
        p.setId(Id);
        p.setProvider(idprovider);
        p.setSubcategory(idsubcategory);
        return iproduct.saveAndFlush(p);
    }
    @PostMapping("/save1/{idprovider}/{idsubcategory}")
    public Product savenew (@RequestBody Product p,  @PathVariable Long idprovider, @PathVariable Long idsubcategory){
       Provider provider = iprovider.findById((idprovider)).orElse(null);
        SubCategory s = isub.findById((idsubcategory)).orElse(null);
        p.setProvider(provider);
        p.setSubcategory(s);
        return iproduct.save(p);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String,String> deleteProduct (@PathVariable(value="Id") Long Id){
        HashMap message = new HashMap();
        try{
            iproduct.deleteById(Id);
            message.put("etat","Product deleted");
            return message;
        }
        catch (Exception e){
            message.put("etat","Product not deleted");
            return message;
        }
    }

    @GetMapping("/GetOne/{id}")
    public Product getOneProduct(@PathVariable Long id){
        return iproduct.findById(id).orElse(null);
    }
}
