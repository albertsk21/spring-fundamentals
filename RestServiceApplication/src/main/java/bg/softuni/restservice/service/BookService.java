package bg.softuni.restservice.service;

import bg.softuni.restservice.model.dto.BookDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {


    List<BookDTO> getAllBooks();
    Optional<BookDTO> findBookById(Long id);
    Page<BookDTO> getBooks(int pageNo, int pageSize, String sortBy);
    void deleteBookById(Long id);
    Optional<Long> updateBook(long id,BookDTO bookToUpdate);
    Long createBook(BookDTO bookToCreate);
}
