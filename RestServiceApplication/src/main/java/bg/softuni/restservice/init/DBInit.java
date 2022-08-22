package bg.softuni.restservice.init;

import bg.softuni.restservice.model.entity.AuthorEntity;
import bg.softuni.restservice.model.entity.BookEntity;
import bg.softuni.restservice.repository.AuthorRepository;
import bg.softuni.restservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DBInit(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        if(bookRepository.count() == 0){
            AuthorEntity joshua = new AuthorEntity().setName("Joshua Bloch");
            AuthorEntity craig = new AuthorEntity().setName("Craig Walls");
            AuthorEntity marko = new AuthorEntity().setName("Marko Luksa");

            joshua = authorRepository.save(joshua);
            craig = authorRepository.save(craig);
            marko = authorRepository.save(marko);


            BookEntity effectiveJava = new BookEntity()
                    .setTitle("Effective Java")
                    .setIsbn("978-0134685991")
                    .setAuthor(joshua);

            BookEntity javaPuzzlers = new BookEntity()
                    .setTitle("Java Puzzlers: Traps, Pitfalls, and Corner Cases")
                    .setIsbn("978-0321336781")
                    .setAuthor(joshua);

            BookEntity springInAction = new BookEntity()
                    .setTitle("Spring in Action, Fifth Edition")
                    .setIsbn("978-161729945")
                    .setAuthor(craig);

            BookEntity k8sInAction = new BookEntity()
                    .setTitle("Kubernetes inAction")
                    .setIsbn("978-161729326")
                    .setAuthor(marko);

            joshua.setBooks(List.of(effectiveJava,javaPuzzlers));
            craig.setBooks(List.of(springInAction));
            marko.setBooks(List.of(k8sInAction));


            bookRepository.saveAll(List.of(effectiveJava, javaPuzzlers, springInAction, k8sInAction));

        }
    }
}
