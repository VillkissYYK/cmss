package edu.ynmd.cms.action;

import edu.ynmd.cms.model.Users;
import edu.ynmd.cms.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@Controller
@CrossOrigin
@RequestMapping("public")
public class PublicAction {

    @Autowired
    private ManageService manageService;

    @PostMapping("login")
    @ResponseBody
    public HashMap login(@RequestBody Users users) throws Exception {
        HashMap m = new HashMap();
        Users u = manageService.findUserByUsernameAndPassword(users.getUsername(),users.getPassword());

        if(u!=null){
            m.put("message:","OK");
        }
        else{
            m.put("message:","Error");
        }
return m;
    }
}






