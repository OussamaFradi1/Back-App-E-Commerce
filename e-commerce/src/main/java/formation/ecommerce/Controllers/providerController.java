package formation.ecommerce.Controllers;

import formation.ecommerce.Dao.providerRepository;
import formation.ecommerce.Models.Category;
import formation.ecommerce.Models.Client;
import formation.ecommerce.Models.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/providers")
public class providerController {
    @Autowired
    private providerRepository iprovider;
    @GetMapping("/all")
    public List<Provider> getAllprovider(){return iprovider.findAll();}
    @PostMapping("/save")
    public Provider saveuser(@RequestBody Provider p){return iprovider.save(p);}
    @PutMapping("/update/{Id}")
    public Provider update (@RequestBody Provider p, @PathVariable Long Id){
        p.setId(Id);
        return iprovider.saveAndFlush(p);
    }
    @DeleteMapping("/delete/{Id}")
    public HashMap<String,String> deleteProvider (@PathVariable(value="Id") Long Id){
        HashMap message = new HashMap();
        try{
            iprovider.deleteById(Id);
            message.put("etat","provider deleted");
            return message;
        }
        catch (Exception e){
            message.put("etat","provider not deleted");
            return message;
        }
    }
    @GetMapping("/GetOne/{id}")
    public Provider getOneProvider(@PathVariable Long id){
        return iprovider.findById(id).orElse(null);
    }
}
