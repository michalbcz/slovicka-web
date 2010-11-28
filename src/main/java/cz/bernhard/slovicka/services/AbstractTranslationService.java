package cz.bernhard.slovicka.services;

import cz.bernhard.slovicka.domains.TranslationResult;

public abstract class AbstractTranslationService implements ITranslationService {

	public abstract TranslationResult translate(String word, String from, String to);

}
