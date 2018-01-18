package com.niit.eshop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.eshop.dao.CategoryDao;
import com.niit.eshop.dao.ProductDao;
import com.niit.eshop.model.Category;
import com.niit.eshop.model.Product;


@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryDao categoriesDao;

	@RequestMapping("/addproduct")
	public ModelAndView add(HttpSession session) {
		List<Category> categoryList = categoriesDao.getlist();
		session.setAttribute("categoryList",categoryList);
		ModelAndView mv = new ModelAndView("addproduct","command", new Product());
		mv.addObject("categoryList",categoryList);

		return mv;
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("product") Product product, HttpServletRequest request,
			@RequestParam("file") MultipartFile file , HttpSession session) {

		byte fileBytes[];
		FileOutputStream fos = null;

		String fileName = "";
		String productImage = "";
		ServletContext context = request.getServletContext();
		String realContextPath = context.getRealPath("/");
		String pn = product.getProductName();
		if (file != null) {
			fileName = realContextPath + "/resources/img/" + pn + ".jpg";
			productImage = "resources/img/" + pn + ".jpg";
			File fileobj = new File(fileName);
			try {
				fos = new FileOutputStream(fileobj);
				fileBytes = file.getBytes();
				fos.write(fileBytes);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		product.setProductImage(productImage);
		product.setProductStatus(true);	
		ModelAndView mv=new ModelAndView("redirect:/viewproducts");
		if(productDao.insertProduct(product))
		{
			
			session.setAttribute("successMessage", "Product added successfully");
			return mv;
		}
		else
		{
			session.setAttribute("successMessage", "Product could not be added!!!!");
			return mv;
		}
		 
	}
	@RequestMapping("/viewproducts")
	public ModelAndView view(HttpSession session ) {
		
		List<Product> list = productDao.retreive();
		session.setAttribute("list", list);
		return new ModelAndView("viewproducts", "list", list);
	}
	@RequestMapping(value = "/discontinueproduct/{productId}", method = RequestMethod.GET)
	public ModelAndView deactivateProduct(@PathVariable int productId, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView("redirect:/viewproducts", "command", new Product());
		Product product = productDao.FindByProductID(productId);
		product.setProductStatus(false);
		if (productDao.updateProduct(product)) {
			httpSession.setAttribute("successMessage", "product deactivated sucessfully");

		} else {
			httpSession.setAttribute("successMessage", "Product Could not be Deactivated!!!!");

		}

		return modelAndView;
	}
	@RequestMapping(value = "/updateproduct/{productId}", method = RequestMethod.GET)
	public ModelAndView updateProduct(@PathVariable int productId, HttpSession session) {
		
		List<Category> categoryList = categoriesDao.getlist();
		session.setAttribute("categoryList", categoryList);
		Product p=productDao.FindByProductID(productId);
		ModelAndView mv = new ModelAndView("updateproducts", "command", p);
		mv.addObject("categoryList", categoryList);
        System.out.println("mmmm "+ categoryList.size());
		return mv;
	}
	@RequestMapping(value = "/updateproducts", method = RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute("Product") Product product, HttpServletRequest request,
			@RequestParam("productImageFile") MultipartFile productImageFile, HttpSession httpSession) {
		System.out.println("at updateProduct" + product.getProductId());
		ModelAndView modelAndView = new ModelAndView("redirect:/viewproducts");

		/*int productId = ((Product) httpSession.getAttribute("product")).getProductId();
		product.setProductId(productId);*/

		byte fileBytes[];
		FileOutputStream fos = null;
		String fileName = " ";
		String productImage ="";
		ServletContext context = request.getServletContext();
		String realContextPath = context.getRealPath("/");
		String ProductName = product.getProductName();
		fileName = realContextPath + "resources/img/" + ProductName + ".jpg";
		productImage="resources/img/" + ProductName + ".jpg";
		if (productImageFile != null && productImageFile.getSize()>0) {
			
			
			System.out.println("kkkkkkkkkkkkkk"+productImageFile.getSize());
			
			System.out.println("===" + fileName + "===");
			File fileobj = new File(fileName);
			try {
				fos = new FileOutputStream(fileobj);
				fileBytes = productImageFile.getBytes();
				fos.write(fileBytes);
			} catch (Exception e) {
				e.printStackTrace();

			}
			product.setProductImage("");
			product.setProductImage(productImage);
			product.setProductStatus(true);	
			productDao.updateProduct(product);
			httpSession.setAttribute("successMessage", "product updated sucessfully");
		} /*else {
			modelAndView.addObject("errorMessage", "failed to update product");*/
		/*}*/
		else
		{
			httpSession.setAttribute("successMessage", "product updateded sucessfully");
			System.out.println("MMMM "+product.getPrice());
			product.setProductImage("");
			product.setProductImage(productImage);
			product.setProductStatus(true);
			productDao.updateProduct(product);
		}
		return modelAndView;
	}

	@RequestMapping("/showproductsbycategory/{categoryId}")
	public ModelAndView showProductsByCategory(@PathVariable int categoryId) {
		System.out.println("cat id " + categoryId);
		ModelAndView mv = new ModelAndView("products");
		mv.addObject("productList", productDao.FindByCategoryId(categoryId));
		return mv;
	}
	@RequestMapping("/showproduct/{productId}")
	public ModelAndView showProduct(@PathVariable int productId) {

		ModelAndView mv = new ModelAndView("product");
		mv.addObject("product", productDao.FindByProductID(productId));
		return mv;
	}
}