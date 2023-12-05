// package uniandes.edu.co.proyecto.controller;

// import java.util.Collection;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import uniandes.edu.co.proyecto.modelo.Product;
// import uniandes.edu.co.proyecto.repositorio.ProductRepository;
// import uniandes.edu.co.proyecto.repositorio.ProductRepository.informacionProductos;

// @Controller
// public class ProductController {

//     @Autowired
//     private ProductRepository productRepository;

//     @GetMapping("/products")
//     public String getProduct(Model model) {
//         model.addAttribute("products", productRepository.darProducts());
//         return "products";
//     }

//     @GetMapping("/products/new")
//     public String ProductForm(Model model) {
//         model.addAttribute("product", new Product());
//         return "productNuevo";
//     }

//     @PostMapping("/products/new/save")
//     public String ProductGuardar(@ModelAttribute Product product) {
//         productRepository.insertarProduct(product.getCost(), product.getType(), product.getServices_idService().getIdService());
//         return "redirect:/products";
//     }

//     @GetMapping("/products/{id}/edit")
//     public String ProductEditarForm(@PathVariable("id") int id, Model model) {
//         Product product = productRepository.darProduct(id);
//         if (product != null) {
//             model.addAttribute("product", product);
//             return "productEditar";
//         }
//         return "redirect:/products";
//     }

//     @PostMapping("/products/{id}/edit/save")
//     public String ProductEditar(@PathVariable("id") int id, @ModelAttribute Product product) {
//         productRepository.actualizarProduct(id, product.getCost(), product.getType(), product.getServices_idService().getIdService());
//         return "redirect:/products";
//     }

//     @GetMapping("/products/{id}/delete")
//     public String ProductBorrar(@PathVariable("id") int id) {
//         productRepository.eliminarProduct(id);
//         return "redirect:/products";
//     }

//     @GetMapping("/productosFiltro")
//     public String ProductosFiltro(Model model, @RequestParam(required = false) String minCost, @RequestParam(required = false) String maxCost, String fechaInicio, String fechaFinal, String tipo) {
//         Collection<informacionProductos> productos;

//         if(minCost == "" || minCost == null) minCost = "0";
//         if(maxCost == "" || maxCost == null) maxCost = "10000000";

//         if(fechaInicio == "" || fechaInicio == null) fechaInicio = "10-Jun-21";
//         if(fechaFinal == "" || fechaFinal == null) fechaFinal = "17-Oct-23";

//         if(tipo == "" || tipo == null) tipo = "Producto de supermercado";

        
//         productos = productRepository.darInformacionProductosFiltros(Integer.parseInt(minCost), Integer.parseInt(maxCost), fechaInicio, fechaFinal, tipo);

//         model.addAttribute("productosFiltro", productos);
//         return "productosFiltro";
//     }
    
// }
