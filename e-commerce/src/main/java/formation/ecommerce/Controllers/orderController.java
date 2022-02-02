package formation.ecommerce.Controllers;

import formation.ecommerce.Dao.orderRepository;
import formation.ecommerce.Models.Category;
import formation.ecommerce.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/order")
public class orderController {
    @Autowired
    private orderRepository iorder;
    @GetMapping("/all")
    public List<Order> getAllOrders(){return iorder.findAll();}
    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order o){return iorder.save(o);}
    @PutMapping("/update/{Id}")
    public Order update (@RequestBody Order o, @PathVariable Long Id){
        o.setId(Id);
        return iorder.saveAndFlush(o);
    }
    @DeleteMapping("/delete/{Id}")
    public HashMap<String,String> deleteOrder (@PathVariable(value="Id") Long Id){
        HashMap message = new HashMap();
        try{
            iorder.deleteById(Id);
            message.put("etat","Order deleted");
            return message;
        }
        catch (Exception e){
            message.put("etat","Order not deleted");
            return message;
        }
    }
    @GetMapping("/GetOne/{id}")
    public Order getOneOrder(@PathVariable Long id){
        return iorder.findById(id).orElse(null);
    }
}
