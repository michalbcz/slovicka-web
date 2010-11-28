package cz.bernhard.slovicka.services;

import cz.bernhard.slovicka.domains.TranslationResult;

public interface ITranslateService {

	/**
	 * Translate word from one language to other language.
	 * 
	 * @param word to translate
	 * @param from language
	 * @param to language
	 * @return
	 */
	TranslationResult translate(String word, String from, String to);
	
}
