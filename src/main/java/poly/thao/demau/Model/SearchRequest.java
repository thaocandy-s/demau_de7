package poly.thao.demau.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchRequest{

    // Có thể kế thừa lại PageRequest để có thông tin trang

    public String productName;

    public Integer brandId;
}
