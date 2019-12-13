package net.assignment.booksLoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.assignment.booksLoan.model.Copia;
import net.assignment.booksLoan.model.Libro;
import net.assignment.booksLoan.service.BookService;
import net.assignment.booksLoan.service.CopieService;

@Controller
public class AppController {
	@Autowired
	private BookService bookService;

    private CopieService copieService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping(value={"", "/", "/index"})
	public String index(Model model) {
		List<Libro> listBooks = bookService.listAll();
		model.addAttribute("listBooks", listBooks);

		return "indexUtente";
	}

	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Libro book = new Libro();
	    model.addAttribute("book", book);

	    return "new_book";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("book") Libro book) {
	    bookService.save(book);

	    return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_book");
	    Libro book = bookService.get(id);
	    mav.addObject("book", book);

	    return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProducte(@PathVariable(name = "id") int id) {
		bookService.delete(id);

	    return "redirect:/";
	}

	@RequestMapping("/ind2")
	public String showBoot(Model model) {
	    return "ind2";
	}

	@RequestMapping("/copie/{id}")
    public String showProductCopies(Model model, @PathVariable(name = "id") int id) {
        List<Copia> listCopie = copieService.CopieId(id);
        model.addAttribute("listCopie", listCopie);

        return "copie";

    }

}
