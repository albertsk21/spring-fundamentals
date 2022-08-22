package bg.softuni.restservice.service.impl;

import bg.softuni.restservice.model.dto.AuthorDTO;
import bg.softuni.restservice.model.dto.BookDTO;
import bg.softuni.restservice.model.entity.AuthorEntity;
import bg.softuni.restservice.model.entity.BookEntity;
import bg.softuni.restservice.repository.AuthorRepository;
import bg.softuni.restservice.repository.BookRepository;
import bg.softuni.restservice.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private ModelMapper modelMapper;
    private AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository,
                           ModelMapper modelMapper, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::asDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDTO> findBookById(Long id) {
        return this.bookRepository.findById(id)
                .map(this::asDto);
    }

    @Override
    public Page<BookDTO> getBooks(int pageNo, int pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        return this.bookRepository.findAll(pageable)
                .map(this::asDto);
    }

    @Override
    public void deleteBookById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Long> updateBook(long id,BookDTO bookToUpdate) {

        Optional<BookEntity> book = this.bookRepository.findById(id);


        if(book.isEmpty()){
            return Optional.empty();
        }

        var authorName = bookToUpdate.getAuthorDTO().getName();


        AuthorEntity authorEntity = this.authorRepository
                .findByName(authorName)
                .orElseGet(() ->{
                    AuthorEntity author = new AuthorEntity().setName(authorName);
                    return this.authorRepository.save(author);
                });


             var bookUpdate = book.get()
                .setTitle(bookToUpdate.getTitle())
                .setIsbn(bookToUpdate.getIsbn())
                .setAuthor(authorEntity);


        return  Optional.of(this.bookRepository.save(bookUpdate).getId());
    }

    @Override
    public Long createBook(BookDTO bookToCreate) {


        AuthorEntity authorEntity = this.authorRepository
                .findByName(bookToCreate.getAuthorDTO().getName())
                .orElseGet(() ->{
                    AuthorEntity author = new AuthorEntity().setName(bookToCreate.getAuthorDTO().getName());
                    return this.authorRepository.save(author);
                });


        BookEntity book = new BookEntity()
                .setTitle(bookToCreate.getTitle())
                .setIsbn(bookToCreate.getIsbn())
                .setAuthor(authorEntity);

        book = this.bookRepository.save(book);
        return book.getId();
    }

    private BookDTO asDto(BookEntity bookEntity){
        BookDTO bookDTO = this.modelMapper.map(bookEntity,BookDTO.class);

        AuthorDTO authorDTO = this.modelMapper.map(bookEntity.getAuthor(),AuthorDTO.class);
        bookDTO.setAuthorDTO(authorDTO);
        return bookDTO;

    }
}
