import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Partner A — word counts + sorted unique words.
 * See ../../README.md
 */
public class WordFrequencyApp {
    private static final Logger logger = LoggerFactory.getLogger("pair.a.words");
    static final String SAMPLE = """
            Java collections maps sets queues lambdas
            Java maps and sets and more Java
            """;

    public static void main(String[] args) {
        Map<String, Integer> counts = new HashMap<>();
        // TODO: tokenize SAMPLE, populate counts (lower-case tokens)
        if(SAMPLE.isBlank()){
            logger.warn("Input was empty");
        }
        String [] words = SAMPLE.toLowerCase().split("[^A-Za-z]+");
        TreeSet<String> vocabulary = new TreeSet<>();
        // TODO: add all distinct words to vocabulary
        // for(String word: words){
        //     vocabulary.add(word);
        //     counts.put(word, counts.getOrDefault(word, 0) + 1);
            
        // }
        Arrays.stream(words).forEach((word ->{
            vocabulary.add(word);
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }));
        
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());
        
        System.out.println("print counts and top N");
        for(Map.Entry<String, Integer> entry: entries){
            logger.debug("{} : {}",entry.getKey(), entry.getValue());
        }


        logger.info("print first of vocabulary: {}", vocabulary.first());
        logger.info("print last of vocabulary: {}", vocabulary.last());
    }
}