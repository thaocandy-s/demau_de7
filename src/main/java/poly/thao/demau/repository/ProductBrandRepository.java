package poly.thao.demau.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poly.thao.demau.Model.ProductBrandResponse;
import poly.thao.demau.Model.SearchRequest;
import poly.thao.demau.entity.ProductBrand;

@Repository
public interface ProductBrandRepository extends JpaRepository<ProductBrand, Integer> {

    @Query("""
        select pb.product.productName,
                pb.brand.brandName,
                pb.product.quantity,
                pb.product.price,
                pb.product.status
        from  product_brand pb
        join brand  b on b.id = pb.brand.id
        where pb.product.productName like concat('%', :#{#req.productName}, '%')
        and pb.brand.id =  :#{#req.brandId}
        """)
    Page<ProductBrandResponse> getPage(SearchRequest req, Pageable pageable);

}
