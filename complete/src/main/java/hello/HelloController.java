package hello;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    /**
     *
     *  This is a request mapping.
     *
     *  www.spellchecker.com
     *
     */
    @RequestMapping("/")
    public String index() {
        return "Welcome to spellchecker.com!";
    }

    /**
     *
     *  This request mapping has a path
     *
     *  www.spellchecker.com/words
     *
     */
    @RequestMapping("/words")
    public String listTheWords() {
        return "Here is the list of all of our words...";
    }

    /**
     *
     *  This is a request mapping has multiple paths.
     *
     *  www.spellchecker.com/words/
     *
     */
//    @RequestMapping("/words/polymorphic")
//    public String  polymorphic() {
//        return "Polymorphic";
//    }

    /**
     *
     *  Usually we want our path to be dynamic though
     *
     *  www.spellchecker.com/words/inheritance
     *
     */
//    @RequestMapping("/words/{word}")
//    public String specifyWord(@PathVariable("word") String word) {
//        // the variable word will equal "word"
//
//        return "You wanted to look at " +  word;
//    }

    /**
     *
     *  We can even include parameters
     *
     *  www.spellchecker.com/words?rhymeWith=orphic
     *
     */
//    @RequestMapping("/words")
//    public String parameters(@RequestParam(value = "rhymeWith", required = false) String rhymeWith) {
//        System.out.println(rhymeWith);
//        return String.format("Searching for words that rhyme with %s", rhymeWith);
//    }

    /**
     *
     *  We can handle errors; like if they type in a bad
     *  search parameter we can give them a special message
     *
     *  www.spellchecker.com/words?doesNotExist=good
     *
     */
    @RequestMapping("/words")
    public String badParameters(@RequestParam(value = "rhymeWith", required = false) String rhymeWith) {
        if (rhymeWith == null || rhymeWith.isEmpty()) {
            throw new NotFoundError();
        }
        System.out.println(rhymeWith);
        return String.format("Searching for %s", rhymeWith);
    }

    @ExceptionHandler (NotFoundError.class)
    public String handleAllExceptions() {
        return "sorry there was an error man";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Did not find the content")
    private static class NotFoundError extends RuntimeException {
    }

    /**
     *
     * What about a bunch of beers!
     *
     */

    @RequestMapping(value = "/beers", method = RequestMethod.GET)
    public @ResponseBody List<Beer> getAllBeers() {
        // save it
        List<Beer> beerList = new ArrayList<Beer>();
        beerList.add(new Beer("Budweiser", "lager"));
        return beerList;
    }

    @RequestMapping(value = "/beers", method = RequestMethod.POST)
    public @ResponseBody Beer saveNewBeer(@RequestBody Beer newBeer) {
        // save it
        return newBeer;
    }

}
