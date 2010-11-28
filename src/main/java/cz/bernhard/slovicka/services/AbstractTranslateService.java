package cz.bernhard.slovicka.services;

import cz.bernhard.slovicka.domains.TranslationResult;

public abstract class AbstractTranslateService implements ITranslateService {

	public abstract TranslationResult translate(String word, String from, String to);

}
