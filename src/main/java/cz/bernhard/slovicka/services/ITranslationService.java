package cz.bernhard.slovicka.services;

import cz.bernhard.slovicka.domains.TranslationResult;


/**
 * Service for translation of given word.
 *
 * @author Michal Bernhard <michal@bernhard.cz>
 */
public interface ITranslationService {

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
