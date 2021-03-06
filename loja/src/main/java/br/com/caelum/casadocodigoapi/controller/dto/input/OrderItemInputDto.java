package br.com.caelum.casadocodigoapi.controller.dto.input;

import br.com.caelum.casadocodigoapi.model.OrderItem;
import br.com.caelum.casadocodigoapi.restclient.ProductDto;
import br.com.caelum.casadocodigoapi.restclient.ProductRepository;

public class OrderItemInputDto {

	private Long productId;
	private Integer amount;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public OrderItem build(ProductRepository productRepository) {
		ProductDto product = productRepository.findById(productId).orElseThrow(
				() -> new IllegalArgumentException(String.format("The Product with id %d wasn't found!", productId))
		);
		
		return new OrderItem(product, amount);
	}
	
	
}
