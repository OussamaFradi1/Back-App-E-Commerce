package formation.ecommerce.Controllers;

import formation.ecommerce.Dao.clientRepository;
import formation.ecommerce.Dao.userRepository;
import formation.ecommerce.Models.Category;
import formation.ecommerce.Models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/client")
public class clientController {
    @Autowired
    private clientRepository iclient;
    @GetMapping("/all")
    public List<Client> getAllusers(){return iclient.findAll();}
    @PostMapping("/save")
    public Client saveclient(@RequestBody Client c){return iclient.save(c);}
    @PutMapping("/update/{Id}")
    public Client update (@RequestBody Client c, @PathVariable Long Id){
        c.setId(Id);
        return iclient.saveAndFlush(c);
    }
    @DeleteMapping("/delete/{Id}")
    public HashMap<String,String> deleteClient (@PathVariable(value="Id") Long Id){
        HashMap message = new HashMap();
        try{
            iclient.deleteById(Id);
            message.put("etat","client deleted");
            return message;
        }
        catch (Exception e){
            message.put("etat","client not deleted");
            return message;
        }
    }
    @GetMapping("/GetOne/{id}")
    public Client getOneClient(@PathVariable Long id){
        return iclient.findById(id).orElse(null);
    }
}
