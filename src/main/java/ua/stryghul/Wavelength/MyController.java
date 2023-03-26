package ua.stryghul.Wavelength;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


    @GetMapping("/words")
    public ResponseEntity<String> getPairOfWords() {
        String pairOfWords = PairOfWords.getPairOfWords();
        return ResponseEntity.ok(pairOfWords);
    }


}
