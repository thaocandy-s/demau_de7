package poly.thao.demau.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poly.thao.demau.Model.ProductBrandResponse;
import poly.thao.demau.Model.SearchRequest;
import poly.thao.demau.repository.ProductBrandRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/product-brand")
public class ProductController {

    @Autowired
    private ProductBrandRepository repository;


    @GetMapping("")
    public Page<ProductBrandResponse> hienThi(@RequestBody SearchRequest req,
                                              @RequestParam(defaultValue = "0", required = false) int currentPage
                                              ){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        return repository.getPage(req, pageable);
    }
}
