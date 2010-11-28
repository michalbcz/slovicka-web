package cz.bernhard.slovicka.domains;

import java.util.Collections;
import java.util.List;


public class TranslationResult {

	private final List<Word> words;
	
	public TranslationResult(List<Word> words) {
		this.words = Collections.unmodifiableList(words);
	}
	
	public List<Word> getWords() {
		return words;
	}
	
}
