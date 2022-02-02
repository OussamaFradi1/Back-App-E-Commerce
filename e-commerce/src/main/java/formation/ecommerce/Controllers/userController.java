package formation.ecommerce.Controllers;

import formation.ecommerce.Dao.userRepository;
import formation.ecommerce.Models.Category;
import formation.ecommerce.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class userController {
    @Autowired
    private userRepository iuser;
    @GetMapping("/all")
    public List<User> getAllusers(){return iuser.findAll();}
    @PostMapping("/save")
    public User saveuser(@RequestBody User u){return iuser.save(u);}
    @PutMapping("/update/{Id}")
    public User update (@RequestBody User u, @PathVariable Long Id){
        u.setId(Id);
        return iuser.saveAndFlush(u);
    }
    @DeleteMapping("/delete/{Id}")
    public HashMap<String,String> deleteUser (@PathVariable(value="Id") Long Id){
        HashMap message = new HashMap();
        try{
            iuser.deleteById(Id);
            message.put("etat","user deleted");
            return message;
        }
        catch (Exception e){
            message.put("etat","user not deleted");
            return message;
        }
    }
    @GetMapping("/GetOne/{id}")
    public User getOneUser(@PathVariable Long id){
        return iuser.findById(id).orElse(null);
    }
}
