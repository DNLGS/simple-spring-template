package application.controller;

import java.util.Optional;

import application.model.Categoria;

@Controller
@RequestMapping("/categoria")
public class CategoriaController{
    @Autowired
    private CategoriaRepository categoriarepo;

    @Requestmapping("/list")
    public String list(Model ui){
        ui.addAtribute("categorias", categoriarepo.fincAll());
        return "categoria/list";
    }

    @RequestMapping("/insert")
    public String insert(){
        return "categoria/insert";
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("nome") String nomee){
        Categoria categoria = new Categoria();
        categoria.setNome(nome);

        categoriarepo.save(catgoria);

        return "redirect:/categoria/list";
    }
    @RequestMapping("/update")
    public String update(
        @RequestParam("id") long id,
        Model ui){
            Optional<Categoria> categoria = categoriarepo.findById(id);
            if (categoria.isPresent()){
                ui.addAtribute("categoria", categoria.get());
                return "categoria/update";
            }
            return "redirect:/categoria/list";
        }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("id") long id,
        @RequestParam("nome") String nome){

            Optional<Categoria> categoria = categoriarepo.findById(id);

            if(categoria.isPresent()){
                categoria.get().setNome(nome);
                categoriarepo.save(categoria.get());                
            }

            return "redirect:/categoria/list";
        }
    @RequestMapping("/delete")
    public String delete(
        @RequestParam("id") long id,
        Model ui){
            Optional<Categoria> categoria = categoria.repo.findById(id);

            if(categoria.isPresent()){
                ui.addAtribute("categoria", categoria.get());
                return "categoria/delete";
            }
        
        }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") Long id) {
        categoriaRepo.deleteById(id);
        return "redirect:/categoria/list";
    }

}

