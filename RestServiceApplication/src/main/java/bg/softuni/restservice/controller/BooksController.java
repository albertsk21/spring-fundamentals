package bg.softuni.restservice.controller;

import bg.softuni.restservice.model.dto.BookDTO;
import bg.softuni.restservice.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/books")
public class BooksController {

    private BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<BookDTO>> getAllBooks(){

        List<BookDTO> books = this.bookService.getAllBooks();


        if(books.size() == 0){
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity
                .ok(books);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<BookDTO>> getAllBooks(@RequestParam(name = "pageNo",  defaultValue = "0") int pageNo,
                                                     @RequestParam(name = "pageSize", defaultValue = "3") int pageSize,
                                                     @RequestParam(name = "sortBy", defaultValue = "id") String sortByt
                                                     ){


        Page<BookDTO> bookDTOPage = this.bookService.getBooks(pageNo,pageSize,sortByt);
        return ResponseEntity.ok(bookDTOPage);

    }


    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable(name = "id") long id){

        Optional<BookDTO> bookDtoOpt = bookService.findBookById(id);

        if(bookDtoOpt.isEmpty()){
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity
                    .ok(bookDtoOpt.get());

    }


    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBookById(@PathVariable(name = "id") long id,
                                                  @RequestBody BookDTO bookDTO){
       Optional<Long> bookId = this.bookService.updateBook(id,bookDTO);


      return bookId.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteBookById(@PathVariable(name = "id") long id){
        bookService.deleteBookById(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping("")
    public ResponseEntity<BookDTO> createBookById(@RequestBody BookDTO bookDTO,
                                                  UriComponentsBuilder uriBuilder){

        long bookId = this.bookService.createBook(bookDTO);
        URI location = uriBuilder.path("/api/books/{id}")
                .buildAndExpand(bookId)
                .toUri();
        return ResponseEntity
                .created(location)
                .build();

    }

}
